package pl.edu.wszib.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.service.IAuthenticationService;

public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;


    public AuthenticationServiceImpl(IUserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public boolean authenticationUser(UserApp userApp){
        UserApp userAppFromDb = this.userDAO.getUserByLogin(userApp.getUsername());
        return userAppFromDb != null && userAppFromDb.getPassword().equals(DigestUtils.md5Hex(userApp.getPassword()));
    }
}
