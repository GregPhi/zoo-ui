package zoo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import zoo.api.bo.info.Info;
import zoo.api.bo.quiz.Quiz;
import zoo.api.service.info.InfoService;
import zoo.api.service.quiz.QuizService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QuizControllerTest {

    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(InfoController.class.getAnnotation(Controller.class));
    }

    @Test
    void findAllQuizzes_shouldReturnTheNameOfTheIndexTemplate() {
        var quizService = mock(QuizService.class);

        when(quizService.findAllQuizzes()).thenReturn(List.of(new Quiz(), new Quiz()));

        var quizzesController = new QuizzesController(quizService);
        quizzesController.setQuizService(quizService);
        var modelAndView = quizzesController.findAllQuizzes();

        assertEquals("quizzes", modelAndView.getViewName());
        var quizzes = (List<Quiz>)modelAndView.getModel().get("quiz");
        assertEquals(2, quizzes.size());
        verify(quizService).findAllQuizzes();
    }

    @Test
    void findAllQuizzes_shouldBeAnnotated() throws NoSuchMethodException {
        var findAllQuizzes = QuizzesController.class.getDeclaredMethod("findAllQuizzes");
        var getMapping = findAllQuizzes.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/quizzes"}, getMapping.value());
    }
}