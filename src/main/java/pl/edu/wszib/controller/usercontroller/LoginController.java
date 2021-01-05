package pl.edu.wszib.controller.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.User;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String mainSite(){
        return "redirect:login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage( ) {
        return new ModelAndView("login", "loginKey", new User());
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginForm(@ModelAttribute("loginKey") User user){
        if(user.getUsername().equals("admin") && user.getPassword().equals("admin") ){
            this.sessionObject.setUser(user);
            return "redirect:rentAppPage";
        }
        System.out.println(user);
        return "login";
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        this.sessionObject.setUser(null);
        return "redirect:login";
    }


}
