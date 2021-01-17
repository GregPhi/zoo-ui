package zoo.api.service.routes;

import zoo.api.bo.routes.Routes;

import java.util.List;

public interface RoutesService {
    List<Routes> findAllRoutes();

    Routes findRoutesById(int id);

    Routes addRoutes(Routes routes);

    Routes updateRoutes(Routes routes);

    void deleteRoutes(Routes routes);
}
