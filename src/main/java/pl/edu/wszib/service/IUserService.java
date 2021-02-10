package pl.edu.wszib.service;

import pl.edu.wszib.model.UserApp;

import java.util.List;

public interface IUserService {
    void registerUser(UserApp userApp);

    UserApp getUserByLogin(String username);

    UserApp getUserById(int idUser);

    List<UserApp> getAllUser();
}
