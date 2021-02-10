package pl.edu.wszib.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.UserApp;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

public class UserAppServiceImplTest {

    @Autowired
    IUserService userService;


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IUserDAO userDAO;

    @Test
    public void getUser(){
        UserApp userApp = new UserApp();
        userApp.setIdUser(1);
        userApp.setUsername("ahnasd");
        userApp.setPassword("dasda");
        userApp.setName("dasda");
        userApp.setSurname("jakoba");
        userApp.setEmail("jakoba@gmail.com");
        userApp.setLatitude(49.65102728278116);
        userApp.setLongitude(19.839176173939617);
        userApp.setRole("ROLE_USER");
        userApp.setLocationName("adasds");
        Mockito.when(this.userDAO.getUserById(anyInt())).thenReturn(new UserApp("ahnasd","dasda","dasda","jakoba","jakoba@gmail.com",49.65102728278116,19.839176173939617,"ROLE_USER","adasds"));
        UserApp result = this.userService.getUserById(1);
        Assert.assertNotNull(result);

    }


    @Test
    public  void allUser() {
        List<UserApp> getAllUsersses = new ArrayList<>();
        UserApp userApp = new UserApp();
        userApp.setIdUser(1);
        userApp.setUsername("ahnasd");
        userApp.setPassword("dasda");
        userApp.setName("dasda");
        userApp.setSurname("jakoba");
        userApp.setEmail("jakoba@gmail.com");
        userApp.setLatitude(49.65102728278116);
        userApp.setLongitude(19.839176173939617);
        userApp.setRole("ROLE_USER");
        userApp.setLocationName("adasds");

        UserApp userApp1 = new UserApp();
        userApp1.setIdUser(2);
        userApp1.setUsername("ahnasd");
        userApp1.setPassword("dasda");
        userApp1.setName("dasda");
        userApp1.setSurname("jakoba");
        userApp1.setEmail("jakoba@gmail.com");
        userApp1.setLatitude(49.65102728278116);
        userApp1.setLongitude(19.839176173939617);
        userApp1.setRole("ROLE_USER");
        userApp1.setLocationName("adasds");



        UserApp userApp2 = new UserApp();
        userApp2.setIdUser(3);
        userApp2.setUsername("ahnasd");
        userApp2.setPassword("dasda");
        userApp2.setName("dasda");
        userApp2.setSurname("jakoba");
        userApp2.setEmail("jakoba@gmail.com");
        userApp2.setLatitude(49.65102728278116);
        userApp2.setLongitude(19.839176173939617);
        userApp2.setRole("ROLE_USER");
        userApp2.setLocationName("adasds");


        UserApp userApp3 = new UserApp();
        userApp3.setIdUser(4);
        userApp3.setUsername("ahnasd");
        userApp3.setPassword("dasda");
        userApp3.setName("dasda");
        userApp3.setSurname("jakoba");
        userApp3.setEmail("jakoba@gmail.com");
        userApp3.setLatitude(49.65102728278116);
        userApp3.setLongitude(19.839176173939617);
        userApp3.setRole("ROLE_USER");
        userApp3.setLocationName("adasds");



        Mockito.when(userDAO.getAllUser()).thenReturn(getAllUsersses);


        List result = this.userDAO.getAllUser();
        Assert.assertEquals(result,userDAO.getAllUser());
    }


}
