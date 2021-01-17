package zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import zoo.api.service.animal.AnimalService;
import zoo.api.service.interest.InterestService;

@Controller
public class InterestController {
    private InterestService interestService;

    public InterestController(InterestService interestService) {
        this.interestService = interestService;
    }

    @GetMapping("/interest")
    ModelAndView findAllInterest(){
        ModelAndView modelAndView = new ModelAndView("interest");
        modelAndView.addObject("visible",interestService.findAllInterest());
        return modelAndView;
    }

    @Autowired
    public void setInterestService(InterestService interestService) {
        this.interestService = interestService;
    }
}
