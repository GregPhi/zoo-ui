package zoo.api.service.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zoo.api.bo.routes.Routes;

import java.util.Arrays;
import java.util.List;

@Service
public class RoutesServiceImpl implements RoutesService{
    private RestTemplate restTemplate;
    private String url;

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.routes.service.url}")
    void setRoutesServiceUrlUrl(String routesServiceUrl) {
        this.url = routesServiceUrl;
    }

    @Override
    public List<Routes> findAllRoutes() {
        Routes[] routes = this.restTemplate.getForObject(this.url, Routes[].class);
        return Arrays.asList(routes.clone());
    }

    @Override
    public Routes findRoutesById(int id) {
        return this.restTemplate.getForObject(this.url+"{id}", Routes.class,id);
    }

    @Override
    public Routes addRoutes(Routes routes) {
        return this.restTemplate.postForObject(this.url, routes, Routes.class);
    }

    @Override
    public Routes updateRoutes(Routes routes) {
        this.restTemplate.put(this.url, routes);
        return routes;
    }

    @Override
    public void deleteRoutes(Routes routes) {
        this.restTemplate.delete(this.url,routes);
    }
}
