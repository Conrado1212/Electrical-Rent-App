package pl.edu.wszib.controller.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.service.IAuthenticationService;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    IAuthenticationService authenticationService;

    public LoginController(){

    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    public String mainSite(){
        return "redirect:login";
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
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

     */

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginForm(Model model){
        model.addAttribute("userModel",new UserApp());
        model.addAttribute("errorMessage","");
        return "login";
    }

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public  String authenticateUser(@ModelAttribute("userModel") UserApp userApp, Model model){
        boolean authResult = this.authenticationService.authenticationUser(userApp);
        if(authResult){
            System.out.println("logged  !!");
            this.sessionObject.setUserApp(userApp);
            System.out.println(userApp);
            return "rentAppPage";
        }else{
            model.addAttribute("errorMessage","error data!!!");
            model.addAttribute("userModel",new UserApp());
            return "login";
        }
    }

    @RequestMapping(value = "/rentAppPage", method = RequestMethod.GET)
    public String page(Model model) {
        if(this.sessionObject.getUserApp() == null) {
            return "redirect:/login";
        }

        model.addAttribute("username", this.sessionObject.getUserApp().getUsername());
        System.out.println(this.sessionObject.getUserApp().getUsername());
        return "rentAppPage";
    }

   /* @RequestMapping(value = "/rentAppPage",method = RequestMethod.GET)
    public ModelAndView rentAppPage(){
        return new ModelAndView("rentAppPage","rentKey",new Vehicle());
    }

    @RequestMapping(value = "/rentAppPage",method = RequestMethod.POST)
    public String rentForm(@ModelAttribute("rentKey") Vehicle vehicle){
        System.out.println(vehicle);
        return "rentAppPage";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "rentAppPage";
    }

    */



    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        this.sessionObject.setUserApp(null);
        return "redirect:login";
    }


}
