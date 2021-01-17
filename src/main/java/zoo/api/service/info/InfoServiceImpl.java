package zoo.api.service.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zoo.api.bo.info.Info;

import java.util.Arrays;
import java.util.List;


@Service
public class InfoServiceImpl implements InfoService {

    private RestTemplate restTemplate;
    private String url;

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.infos.service.url}")
    void setInfoServiceUrl(String infoServiceUrl) {
        this.url = infoServiceUrl;
    }

    @Override
    public List<Info> findAllInfos() {
        Info[] infos = this.restTemplate.getForObject(this.url, Info[].class);
        return Arrays.asList(infos.clone());
    }

    @Override
    public Info findInfoById(int id) {
        return this.restTemplate.getForObject(this.url+"{id}",Info.class);
    }

    @Override
    public Info addInfo(Info info) {
        return this.restTemplate.postForObject(this.url,info,Info.class);
    }

    @Override
    public Info updateInfo(Info info) {
        this.restTemplate.put(this.url,info);
        return info;
    }

    @Override
    public void deleteInfo(Info info) {
        this.restTemplate.delete(this.url,info);
    }
}
