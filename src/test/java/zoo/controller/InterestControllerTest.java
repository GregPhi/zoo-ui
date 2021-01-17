package zoo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import zoo.api.bo.info.Info;
import zoo.api.bo.interest.Interest;
import zoo.api.service.info.InfoService;
import zoo.api.service.interest.InterestService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InterestControllerTest {

    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(InfoController.class.getAnnotation(Controller.class));
    }

    @Test
    void findAllInterest_shouldReturnTheNameOfTheIndexTemplate() {
        var interestService = mock(InterestService.class);

        when(interestService.findAllInterest()).thenReturn(List.of(new Interest(), new Interest()));

        var interestController = new InterestController(interestService);
        interestController.setInterestService(interestService);
        var modelAndView = interestController.findAllInterest();

        assertEquals("interest", modelAndView.getViewName());
        var interests = (List<Interest>)modelAndView.getModel().get("visible");
        assertEquals(2, interests.size());
        verify(interestService).findAllInterest();
    }

    @Test
    void findAllInterest_shouldBeAnnotated() throws NoSuchMethodException {
        var findAllInterest = InterestController.class.getDeclaredMethod("findAllInterest");
        var getMapping = findAllInterest.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/interest"}, getMapping.value());
    }
}