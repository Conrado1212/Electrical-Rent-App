package pl.edu.wszib.dao;

import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

public interface IUserDAO {
    void addUser(UserApp userApp);

    UserApp getUserByLogin(String username);

    UserApp getUserById(int idUser);

    List<UserApp> getAllUser();

    Vehicle removeUserId(int idUser);

    UserApp getUpdate(int idUser, UserApp userApp);

    void getUpdateUser(int idUser, UserApp userApp);

    void updateUser(int idUser, UserApp userApp);
}
