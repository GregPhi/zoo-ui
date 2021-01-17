package zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import zoo.api.service.animal.AnimalService;
import zoo.api.service.quiz.QuizService;

@Controller
public class QuizzesController {
    private QuizService quizService;

    public QuizzesController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quizzes")
    ModelAndView findAllQuizzes(){
        ModelAndView modelAndView = new ModelAndView("quizzes");
        modelAndView.addObject("quiz",quizService.findAllQuizzes());
        return modelAndView;
    }

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }
}
