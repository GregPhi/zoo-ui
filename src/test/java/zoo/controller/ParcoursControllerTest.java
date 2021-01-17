package zoo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import zoo.api.bo.info.Info;
import zoo.api.bo.routes.Routes;
import zoo.api.service.routes.RoutesService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParcoursControllerTest {

    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(InfoController.class.getAnnotation(Controller.class));
    }

    @Test
    void findAllRoutes_shouldReturnTheNameOfTheIndexTemplate() {
        var routesService = mock(RoutesService.class);

        when(routesService.findAllRoutes()).thenReturn(List.of(new Routes(), new Routes()));

        var parcoursController = new ParcoursController(routesService);
        parcoursController.setRoutesService(routesService);
        var modelAndView = parcoursController.findAllRoutes();

        assertEquals("parcours", modelAndView.getViewName());
        var routes = (List<Routes>)modelAndView.getModel().get("parcoursDuZoo");
        assertEquals(2, routes.size());
        verify(routesService).findAllRoutes();
    }

    @Test
    void findAllRoutes_shouldBeAnnotated() throws NoSuchMethodException {
        var findAllRoutes = ParcoursController.class.getDeclaredMethod("findAllRoutes");
        var getMapping = findAllRoutes.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/parcours"}, getMapping.value());
    }
}