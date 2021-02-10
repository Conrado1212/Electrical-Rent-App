package pl.edu.wszib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.edu.wszib.dao.impl.UserDAOImpl;

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
