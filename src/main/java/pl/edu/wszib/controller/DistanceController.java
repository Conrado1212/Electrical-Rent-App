package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.Distance;
import pl.edu.wszib.service.impl.DistanceServiceImpl;

import javax.annotation.Resource;

@Controller
public class DistanceController {
    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    private DistanceServiceImpl distanceService;


    @RequestMapping("/distance")
    public String calculate(Model model, Distance distance, BindingResult bindingResult){
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        if(bindingResult.hasErrors()) {
            return "distance"; // powrót do formularza
        }
        double result = distanceService.distance(distance.getLat1(),distance.getLon1(),distance.getLat2(),distance.getLon2());
        model.addAttribute("result", result);
        return "result";

    }

    @GetMapping("/distance")
    public String distanceForm(Distance distance) {
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        return "distance";
    }
}
