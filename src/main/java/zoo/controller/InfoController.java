package zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import zoo.api.service.animal.AnimalService;
import zoo.api.service.info.InfoService;

@Controller
public class InfoController {
    private InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/infos")
    ModelAndView findAllInfos(){
        ModelAndView modelAndView = new ModelAndView("infos");
        modelAndView.addObject("info",infoService.findAllInfos());
        return modelAndView;
    }

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }
}
