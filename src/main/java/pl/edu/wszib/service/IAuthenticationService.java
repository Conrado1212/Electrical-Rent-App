package pl.edu.wszib.service;

import pl.edu.wszib.model.UserApp;

public interface IAuthenticationService {
    boolean authenticationUser(UserApp userApp);
}
