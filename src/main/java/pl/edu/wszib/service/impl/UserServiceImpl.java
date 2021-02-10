package pl.edu.wszib.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    public void registerUser(UserApp userApp){
        UserApp userAppFromDb = this.userDAO.getUserByLogin(userApp.getUsername());
        if(userAppFromDb == null){
            userApp.setPassword(DigestUtils.md5Hex(userApp.getPassword()));
            this.userDAO.addUser(userApp);
        }
    }

    @Override
    public UserApp getUserByLogin(String username){
        return this.userDAO.getUserByLogin(username);
    }

    @Override
    public UserApp getUserById(int idUser){
        return this.userDAO.getUserById(idUser);
    }

    @Override
    public List<UserApp> getAllUser(){
        return this.userDAO.getAllUser();
    }
}
