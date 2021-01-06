package pl.edu.wszib.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.controller.BuyController;
import pl.edu.wszib.controller.DistanceController;
import pl.edu.wszib.controller.RentController;
import pl.edu.wszib.controller.groupcontroller.GroupVehicleController;
import pl.edu.wszib.controller.usercontroller.LoginController;
import pl.edu.wszib.controller.usercontroller.RegisterController;
import pl.edu.wszib.controller.usercontroller.UserController;
import pl.edu.wszib.controller.vehiclecontroller.VehicleController;
import pl.edu.wszib.controller.vehiclecontroller.VehiclesController;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.dao.IVehicleDAO;
import pl.edu.wszib.model.GroupVehicle;
import pl.edu.wszib.service.IDistanceService;
import pl.edu.wszib.service.IUserService;
import pl.edu.wszib.service.IVehicleService;
import pl.edu.wszib.service.impl.UserServiceImpl;
import pl.edu.wszib.service.impl.VehicleServiceImpl;

@Configuration
public class AppConfigurationTest {
    @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public LoginController loginController(){
        return new LoginController();
    }

    @Bean
    public GroupVehicleController groupVehicleController(){
        return new GroupVehicleController();
    }

    @Bean
    public RegisterController registerController(){
        return new RegisterController();
    }

    @Bean
    public UserController userController(){
        return new UserController();
    }

    @Bean
    public VehicleController vehicleController(){
        return new VehicleController();
    }

    @Bean
    public VehiclesController vehiclesController(){
        return new VehiclesController();
    }

    @Bean
    public BuyController buyController(){
        return new BuyController();
    }

    @Bean
    public DistanceController distanceController(){
        return new DistanceController();
    }

    @Bean
    public RentController rentController(){
        return new RentController();
    }

    @Bean
    public IVehicleService vehicleService(IVehicleDAO vehicleDAO){
        return new VehicleServiceImpl(vehicleDAO);
    }

    @Bean
    public IUserService userService(IUserDAO userDAO){
        return new UserServiceImpl(userDAO);
    }


}
