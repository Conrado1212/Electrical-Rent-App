package pl.edu.wszib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.edu.wszib.dao.impl.UserDAOImpl;
import pl.edu.wszib.model.User;

import java.security.Principal;

@Controller
@SessionAttributes("signIn")
public class SessionController {
    @Autowired
    UserDAOImpl userDAO;

    public SessionController(UserDAOImpl userDAO){
        this.userDAO = userDAO;
    }



    public String signIn(){


        return "";
    }
}
