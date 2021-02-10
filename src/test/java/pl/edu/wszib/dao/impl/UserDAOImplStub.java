package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

public class UserDAOImplStub implements IUserDAO {
    @Override
    public void addUser(UserApp userApp) {

    }

    @Override
    public UserApp getUserByLogin(String username) {
        return null;
    }

    @Override
    public UserApp getUserById(int idUser) {
        return null;
    }

    @Override
    public List<UserApp> getAllUser() {
        return null;
    }

    @Override
    public Vehicle removeUserId(int idUser) {
        return null;
    }

    @Override
    public UserApp getUpdate(int idUser, UserApp userApp) {
        return null;
    }

    @Override
    public void getUpdateUser(int idUser, UserApp userApp) {

    }

    @Override
    public void updateUser(int idUser, UserApp userApp) {

    }
}
