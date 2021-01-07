package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.Rent;
import pl.edu.wszib.service.impl.RentServiceImpl;

import javax.annotation.Resource;

@Controller
public class RentController {
    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    private RentServiceImpl rentService;

    @RequestMapping("/rent")
    public String rent(Model model, Rent rent, BindingResult bindingResult){
        if(this.sessionObject.getUser() == null){
            return "redirect:login";
        }
        if(bindingResult.hasErrors()) {
            return "rent"; // powrót do formularza
        }
        double result2 = rentService.price(rent.getIdGroupVehicle(),rent.getHowLong());
        model.addAttribute("result2", result2);
        return "result2";
    }

    @GetMapping("/rent")
    public String rentForm(Rent rent) {
        if(this.sessionObject.getUser() == null){
            return "redirect:login";
        }
        return "rent";
    }
}
