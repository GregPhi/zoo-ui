package zoo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import zoo.api.bo.animal.Animal;
import zoo.api.bo.info.Info;
import zoo.api.service.animal.AnimalService;
import zoo.api.service.info.InfoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InfoControllerTest {

    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(InfoController.class.getAnnotation(Controller.class));
    }

    @Test
    void findAllInfos_shouldReturnTheNameOfTheIndexTemplate() {
        var infoService = mock(InfoService.class);

        when(infoService.findAllInfos()).thenReturn(List.of(new Info(), new Info()));

        var infoController = new InfoController(infoService);
        infoController.setInfoService(infoService);
        var modelAndView = infoController.findAllInfos();

        assertEquals("infos", modelAndView.getViewName());
        var infos = (List<Info>)modelAndView.getModel().get("info");
        assertEquals(2, infos.size());
        verify(infoService).findAllInfos();
    }

    @Test
    void findAllInfos_shouldBeAnnotated() throws NoSuchMethodException {
        var findAllInfos = InfoController.class.getDeclaredMethod("findAllInfos");
        var getMapping = findAllInfos.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/infos"}, getMapping.value());
    }
}