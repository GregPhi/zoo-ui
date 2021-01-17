package zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import zoo.api.service.animal.AnimalService;
import zoo.api.service.routes.RoutesService;

@Controller
public class ParcoursController {
    private RoutesService routesService;

    public ParcoursController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @GetMapping("/parcours")
    ModelAndView findAllRoutes(){
        ModelAndView modelAndView = new ModelAndView("parcours");
        modelAndView.addObject("parcoursDuZoo",routesService.findAllRoutes());
        return modelAndView;
    }

    @Autowired
    public void setRoutesService(RoutesService routesService) {
        this.routesService = routesService;
    }
}
