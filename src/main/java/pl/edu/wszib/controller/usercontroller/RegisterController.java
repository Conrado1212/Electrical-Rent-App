package pl.edu.wszib.controller.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.dao.impl.UserDAOImpl;
import pl.edu.wszib.model.RegisterUser;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.service.IUserService;


@Controller
public class RegisterController {

    @Autowired
    UserDAOImpl userDAO;

    @Autowired
    IUserService userService;

    public RegisterController() {

    }
    /*
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView Registry(){
        return new ModelAndView("register","addUserKey",new User());
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registryForm(@ModelAttribute("addUserKey") User user){
        userDAO.addUser(user);
        return  "login";
    }

     */


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("userModel", new RegisterUser());
        model.addAttribute("incorrectRepeat", "");
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegisterUser registerUser, Model model) {
        if (registerUser.getPassword().equals(registerUser.getRepeatPass())) {
            this.userService.registerUser(this.convertRegisterUserToUser(registerUser));
            return "redirect:login";
        } else {
            model.addAttribute("userModel", new RegisterUser());
            model.addAttribute("incorrectRepeat", "Zle haslo");
            return "register";
        }
    }

    private UserApp convertRegisterUserToUser(RegisterUser registerUser) {
        UserApp userApp = new UserApp();
        userApp.setUsername(registerUser.getUsername());
        userApp.setPassword(registerUser.getPassword());
        userApp.setName(registerUser.getName());
        userApp.setSurname(registerUser.getSurname());
        userApp.setEmail(registerUser.getEmail());
        userApp.setLongitude(registerUser.getLongitude());
        userApp.setLatitude(registerUser.getLatitude());
        userApp.setRole(registerUser.getRole());
        userApp.setLocationName(registerUser.getLocationName());
        return userApp;
    }


}
