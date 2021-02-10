package pl.edu.wszib.controller.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.UserDAOImpl;
import pl.edu.wszib.model.UserApp;


import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource(name = "sessionObject")
    SessionObject sessionObject;


    @Autowired
    UserDAOImpl userDAO;


    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public ModelAndView addUser(){
        return new ModelAndView("addUser","addUserKey",new UserApp());
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUserForm(@ModelAttribute("addUserKey") UserApp userApp){
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        userDAO.addUser(userApp);
        return  "addUser";
    }

    @RequestMapping(value ="/allUser",method = RequestMethod.GET)
    public String AllUsers(Model model){
        model.addAttribute("allUser",userDAO.getAllUser());
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        return "allUser";
    }
/*
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public ModelAndView getUser(){
        return new ModelAndView("getUser","getUserKey",new User());
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public String getUserForm(@ModelAttribute("getUserKey") User user){
        userDAO.getUserById(user.getIdUser());
        return "getUser";
    }

 */

    @RequestMapping("/getUser")
    public String getUser(Model model, UserApp userApp, BindingResult bindingResult){
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        if(bindingResult.hasErrors()) {
            return "getUser"; // powrót do formularza
        }
        UserApp result =  userDAO.getUserById(userApp.getIdUser());
        model.addAttribute("result", result);
        return "resultGetUser";

    }

    @GetMapping("/getUser")
    public String getUserForm(UserApp userApp) {
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        return "getUser";
    }


    @RequestMapping("/userApp")
    public String user(Model model, UserApp userApp, BindingResult bindingResult){
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        if(bindingResult.hasErrors()) {
            return "userApp"; // powrót do formularza
       }
        UserApp result =  userDAO.getUserByLogin(userApp.getUsername());
        model.addAttribute("result", result);
        return "resultUser";

    }

    @GetMapping("/userApp")
    public String userForm(UserApp userApp) {
        return "userApp";
    }


    @RequestMapping(value = "/removeUser",method = RequestMethod.GET)
    public ModelAndView removeUserId(){
        return new ModelAndView("removeUser","removeUserIdKey",new UserApp());
    }

    @RequestMapping(value = "/removeUser",method = RequestMethod.POST)
    public String removeUserForm(@ModelAttribute("removeUserIdKey") UserApp userApp){
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        userDAO.removeUserId(userApp.getIdUser());
        return "removeUser";
    }


    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public ModelAndView updateVehicle(){
        return new ModelAndView("updateUser","updateUserKey",new UserApp());
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateVehicleForm(@ModelAttribute("updateUserKey") UserApp userApp){
        if(this.sessionObject.getUserApp() == null){
            return "redirect:login";
        }
        userDAO.getUpdate(userApp.getIdUser(), userApp);
        return "updateUser";
    }


}
