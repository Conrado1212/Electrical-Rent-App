package pl.edu.wszib.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.dao.IVehicleDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

public class UserServiceImplTest {

    @Autowired
    IUserService userService;


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IUserDAO userDAO;

    @Test
    public void getUser(){
        User user = new User();
        user.setIdUser(1);
        user.setUsername("ahnasd");
        user.setPassword("dasda");
        user.setName("dasda");
        user.setSurname("jakoba");
        user.setEmail("jakoba@gmail.com");
        user.setLatitude(49.65102728278116);
        user.setLongitude(19.839176173939617);
        user.setRole("ROLE_USER");
        user.setLocationName("adasds");
        Mockito.when(this.userDAO.getUserById(anyInt())).thenReturn(new User("ahnasd","dasda","dasda","jakoba","jakoba@gmail.com",49.65102728278116,19.839176173939617,"ROLE_USER","adasds"));
        User result = this.userService.getUserById(1);
        Assert.assertNotNull(result);

    }


    @Test
    public  void allUser() {
        List<User> getAllUserss = new ArrayList<>();
        User user = new User();
        user.setIdUser(1);
        user.setUsername("ahnasd");
        user.setPassword("dasda");
        user.setName("dasda");
        user.setSurname("jakoba");
        user.setEmail("jakoba@gmail.com");
        user.setLatitude(49.65102728278116);
        user.setLongitude(19.839176173939617);
        user.setRole("ROLE_USER");
        user.setLocationName("adasds");

        User user1 = new User();
        user1.setIdUser(2);
        user1.setUsername("ahnasd");
        user1.setPassword("dasda");
        user1.setName("dasda");
        user1.setSurname("jakoba");
        user1.setEmail("jakoba@gmail.com");
        user1.setLatitude(49.65102728278116);
        user1.setLongitude(19.839176173939617);
        user1.setRole("ROLE_USER");
        user1.setLocationName("adasds");



        User user2 = new User();
        user2.setIdUser(3);
        user2.setUsername("ahnasd");
        user2.setPassword("dasda");
        user2.setName("dasda");
        user2.setSurname("jakoba");
        user2.setEmail("jakoba@gmail.com");
        user2.setLatitude(49.65102728278116);
        user2.setLongitude(19.839176173939617);
        user2.setRole("ROLE_USER");
        user2.setLocationName("adasds");


        User user3 = new User();
        user3.setIdUser(4);
        user3.setUsername("ahnasd");
        user3.setPassword("dasda");
        user3.setName("dasda");
        user3.setSurname("jakoba");
        user3.setEmail("jakoba@gmail.com");
        user3.setLatitude(49.65102728278116);
        user3.setLongitude(19.839176173939617);
        user3.setRole("ROLE_USER");
        user3.setLocationName("adasds");



        Mockito.when(userDAO.getAllUser()).thenReturn(getAllUserss);


        List result = this.userDAO.getAllUser();
        Assert.assertEquals(result,userDAO.getAllUser());
    }


}
