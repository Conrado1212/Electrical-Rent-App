package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

public class UserDAOImplStub implements IUserDAO {
    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserByLogin(String username) {
        return null;
    }

    @Override
    public User getUserById(int idUser) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public Vehicle removeUserId(int idUser) {
        return null;
    }

    @Override
    public User getUpdate(int idUser, User user) {
        return null;
    }

    @Override
    public void getUpdateUser(int idUser, User user) {

    }

    @Override
    public void updateUser(int idUser, User user) {

    }
}
