package zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import zoo.api.bo.animal.Animal;
import zoo.api.service.animal.AnimalService;

import java.util.List;

@Controller
public class AnimalController {
    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    ModelAndView findAllAnimals(){
        ModelAndView modelAndView = new ModelAndView("animals");
        modelAndView.addObject("animalsInZoo",animalService.findAllAnimals());
        return modelAndView;
    }

    @Autowired
    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }
}
