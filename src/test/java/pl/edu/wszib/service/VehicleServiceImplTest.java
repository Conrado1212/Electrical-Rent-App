package pl.edu.wszib.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.wszib.dao.IVehicleDAO;
import pl.edu.wszib.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class VehicleServiceImplTest  {
    @Autowired
    IVehicleService vehicleService;

    @MockBean
    IVehicleDAO vehicleDAO;

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void getVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setIdVehicle(1);
        vehicle.setIdGroupVehicle(1);
        vehicle.setBrand("Xiaomi");
        vehicle.setModel("Mijia M365");
        vehicle.setMaxRange(42);
        vehicle.setWeight(12);
        vehicle.setPricePerSale(1200);
        vehicle.setMaxSpeed(30);
        vehicle.setLatitude(49.65102728278116);
        vehicle.setLongitude(19.839176173939617);
        vehicle.setLocationName("adasds");
        Mockito.when(this.vehicleDAO.getVehicle(anyInt())).thenReturn(new Vehicle(1,1,"Xiaomi","Mijia M365",42,12,1200,30,49.65102728278116,19.839176173939617,"adasds"));
        Vehicle result = this.vehicleService.getVehicle(1);
        Assert.assertNotNull(result);

    }

    @Test
    public  void allVehicle(){
        List<Vehicle> getAllVehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle();

        vehicle.setIdVehicle(1);
        vehicle.setIdGroupVehicle(1);
        vehicle.setBrand("Xiaomi");
        vehicle.setModel("Mijia M365");
        vehicle.setMaxRange(42);
        vehicle.setWeight(12);
        vehicle.setPricePerSale(1200);
        vehicle.setMaxSpeed(30);
        vehicle.setLatitude(49.65102728278116);
        vehicle.setLongitude(19.839176173939617);
        vehicle.setLocationName("adasds");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setIdVehicle(2);
        vehicle1.setIdGroupVehicle(2);
        vehicle1.setBrand("Tesla");
        vehicle1.setModel("Model 5");
        vehicle1.setMaxRange(400);
        vehicle1.setWeight(2300);
        vehicle1.setPricePerSale(210000);
        vehicle1.setMaxSpeed(240);
        vehicle1.setLatitude(49.65813111337792);
        vehicle1.setLongitude(19.78757475613507);
        vehicle1.setLocationName("ada");



        Vehicle vehicle2 = new Vehicle();
        vehicle2.setIdVehicle(3);
        vehicle2.setIdGroupVehicle(3);
        vehicle2.setBrand("Ktm");
        vehicle2.setModel("Freeride ");
        vehicle2.setMaxRange(150);
        vehicle2.setWeight(150);
        vehicle2.setPricePerSale(40000);
        vehicle2.setMaxSpeed(150);
        vehicle2.setLatitude(49.67643561098892);
        vehicle2.setLongitude(19.757226741508546);
        vehicle2.setLocationName("adsdsasds");

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setIdVehicle(4);
        vehicle3.setIdGroupVehicle(3);
        vehicle3.setBrand("Yamaha ");
        vehicle3.setModel("r1 ");
        vehicle3.setMaxRange(300);
        vehicle3.setWeight(200);
        vehicle3.setPricePerSale(100000);
        vehicle3.setMaxSpeed(299);
        vehicle3.setLatitude(49.64726726960124);
        vehicle3.setLongitude(19.879460107526455);
        vehicle3.setLocationName("sds");

        Mockito.when(vehicleDAO.getAllVehicle()).thenReturn(getAllVehicles);


        List result = this.vehicleDAO.getAllVehicle();
        Assert.assertEquals(result,vehicleDAO.getAllVehicle());
    }

    @Test
    public  void getAllScooter(){
        List<Vehicle> getAllScooter = new ArrayList<>();
        Vehicle vehicle = new Vehicle();


        vehicle.setIdVehicle(1);
        vehicle.setIdGroupVehicle(1);
        vehicle.setBrand("Xiaomi");
        vehicle.setModel("MiJia M365 ");
        vehicle.setMaxRange(50);
        vehicle.setWeight(20);
        vehicle.setPricePerSale(1200);
        vehicle.setMaxSpeed(30);
        vehicle.setLatitude(49.67643561098892);
        vehicle.setLongitude(19.757226741508546);
        vehicle.setLocationName("adsddasasds");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setIdVehicle(2);
        vehicle1.setIdGroupVehicle(1);
        vehicle1.setBrand("Xiaomi ");
        vehicle1.setModel("MiJia M365 PRO ");
        vehicle1.setMaxRange(40);
        vehicle1.setWeight(21);
        vehicle1.setPricePerSale(1500);
        vehicle1.setMaxSpeed(30);
        vehicle1.setLatitude(49.64726726960124);
        vehicle1.setLongitude(19.879460107526455);
        vehicle1.setLocationName("sadads");





        Mockito.when(vehicleDAO.getAllScooter()).thenReturn(getAllScooter);

        List result = this.vehicleDAO.getAllScooter();
        Assert.assertEquals(result,vehicleDAO.getAllScooter());
    }

    @Test
    public  void getAllCar(){
        List<Vehicle> getAllCar = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setIdVehicle(1);
        vehicle.setIdGroupVehicle(2);
        vehicle.setBrand("Tesla");
        vehicle.setModel("Model 3");
        vehicle.setMaxRange(300);
        vehicle.setWeight(2000);
        vehicle.setPricePerSale(200000);
        vehicle.setMaxSpeed(230);
        vehicle.setLatitude(49.65102728278116);
        vehicle.setLongitude(19.839176173939617);
        vehicle.setLocationName("adasds");


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setIdVehicle(1);
        vehicle1.setIdGroupVehicle(2);
        vehicle1.setBrand("Tesla");
        vehicle1.setModel("Model 5");
        vehicle1.setMaxRange(400);
        vehicle1.setWeight(2300);
        vehicle1.setPricePerSale(210000);
        vehicle1.setMaxSpeed(240);
        vehicle1.setLatitude(49.65813111337792);
        vehicle1.setLongitude(19.78757475613507);
        vehicle1.setLocationName("ada");

        Mockito.when(vehicleDAO.getAllCars()).thenReturn(getAllCar);

        List result = this.vehicleDAO.getAllCars();
        Assert.assertEquals(result,vehicleDAO.getAllCars());
    }



    @Test
    public  void getAllMotorBike(){
        List<Vehicle> getAllMotorBike = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setIdVehicle(1);
        vehicle.setIdGroupVehicle(3);
        vehicle.setBrand("Ktm");
        vehicle.setModel("Freeride 3");
        vehicle.setMaxRange(100);
        vehicle.setWeight(150);
        vehicle.setPricePerSale(50000);
        vehicle.setMaxSpeed(150);
        vehicle.setLatitude(49.65102728278116);
        vehicle.setLongitude(19.839176173939617);
        vehicle.setLocationName("adasds");


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setIdVehicle(1);
        vehicle1.setIdGroupVehicle(3);
        vehicle1.setBrand("Yamaha ");
        vehicle1.setModel("r 5");
        vehicle1.setMaxRange(250);
        vehicle1.setWeight(200);
        vehicle1.setPricePerSale(100000);
        vehicle1.setMaxSpeed(299);
        vehicle1.setLatitude(49.65813111337792);
        vehicle1.setLongitude(19.78757475613507);
        vehicle1.setLocationName("ada");

        Mockito.when(vehicleDAO.getAllMotorBike()).thenReturn(getAllMotorBike);

        List result = this.vehicleDAO.getAllMotorBike();
        Assert.assertEquals(result,vehicleDAO.getAllMotorBike());
    }


    @Test
    public  void getAllBike(){
        List<Vehicle> getAllBike = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setIdVehicle(1);
        vehicle.setIdGroupVehicle(4);
        vehicle.setBrand("Ktm");
        vehicle.setModel(" 3");
        vehicle.setMaxRange(50);
        vehicle.setWeight(25);
        vehicle.setPricePerSale(15000);
        vehicle.setMaxSpeed(50);
        vehicle.setLatitude(49.65102728278116);
        vehicle.setLongitude(19.839176173939617);
        vehicle.setLocationName("adasds");


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setIdVehicle(2);
        vehicle1.setIdGroupVehicle(4);
        vehicle1.setBrand("Kymco ");
        vehicle1.setModel("r 5");
        vehicle1.setMaxRange(50);
        vehicle1.setWeight(30);
        vehicle1.setPricePerSale(15000);
        vehicle1.setMaxSpeed(66);
        vehicle1.setLatitude(49.65813111337792);
        vehicle1.setLongitude(19.78757475613507);
        vehicle1.setLocationName("ada");

        Mockito.when(vehicleDAO.getAllMotorBike()).thenReturn(getAllBike);

        List result = this.vehicleDAO.getAllMotorBike();
        Assert.assertEquals(result,vehicleDAO.getAllMotorBike());
    }
}
