package pl.edu.wszib.controller.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.dao.impl.UserDAOImpl;
import pl.edu.wszib.model.User;


@Controller
public class RegisterController {

    @Autowired
    UserDAOImpl userDAO;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView Registry(){
        return new ModelAndView("register","addUserKey",new User());
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registryForm(@ModelAttribute("addUserKey") User user){
        userDAO.addUser(user);
        return  "login";
    }





}
