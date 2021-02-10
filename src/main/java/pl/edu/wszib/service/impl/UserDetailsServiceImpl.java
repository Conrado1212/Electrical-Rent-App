package pl.edu.wszib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.UserApp;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserDAO userDAO;


    public UserDetailsServiceImpl(IUserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp = userDAO.getUserByLogin(username);
        if(userApp == null){
            throw  new UsernameNotFoundException("User dont exist");
        }
        return userApp;
    }
}
