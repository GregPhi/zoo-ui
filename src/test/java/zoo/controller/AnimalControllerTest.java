package zoo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import zoo.api.bo.animal.Animal;
import zoo.api.service.animal.AnimalService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AnimalControllerTest {

    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(AnimalController.class.getAnnotation(Controller.class));
    }

    @Test
    void findAllAnimals_shouldReturnTheNameOfTheIndexTemplate() {
        var animalService = mock(AnimalService.class);

        when(animalService.findAllAnimals()).thenReturn(List.of(new Animal(), new Animal()));

        var animalController = new AnimalController(animalService);
        animalController.setAnimalService(animalService);
        var modelAndView = animalController.findAllAnimals();

        assertEquals("animals", modelAndView.getViewName());
        var animals = (List<Animal>)modelAndView.getModel().get("animalsInZoo");
        assertEquals(2, animals.size());
        verify(animalService).findAllAnimals();
    }

    @Test
    void findAllAnimals_shouldBeAnnotated() throws NoSuchMethodException {
        var findAllAnimals = AnimalController.class.getDeclaredMethod("findAllAnimals");
        var getMapping = findAllAnimals.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/animals"}, getMapping.value());
    }
}