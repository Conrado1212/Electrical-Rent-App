package pl.edu.wszib;

import pl.edu.wszib.model.UserApp;

public class SessionObject {
    private UserApp userApp = null;

    public UserApp getUserApp(){
        return userApp;
    }
    public void setUserApp(UserApp userApp){
        this.userApp = userApp;
    }
}
