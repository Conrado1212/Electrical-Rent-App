package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.IVehicleDAO;
import pl.edu.wszib.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImplStub implements IVehicleDAO {
    @Override
    public void addVehicle(Vehicle vehicle) {

    }

    @Override
    public Vehicle getVehicle(int idVehicle) {
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


        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return null;
    }

    @Override
    public List<Vehicle> getID(int idVehicle) {
        return null;
    }

    @Override
    public Vehicle getUpdate(int idVehicle, Vehicle vehicle) {
        return null;
    }

    @Override
    public void getUpdateVehicle(int idVehicle, Vehicle vehicle) {

    }

    @Override
    public void updateVehicle(int idVehicle, Vehicle vehicle) {

    }

    @Override
    public Vehicle removeVehicleId(int idVehicle) {
        return null;
    }
    List<Vehicle> cars = new ArrayList<>();
    @Override
    public List<Vehicle> getAllCars() {
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
        return cars;
    }
    List<Vehicle> motoreBike = new ArrayList<>();
    @Override
    public List<Vehicle> getAllMotorBike() {
        Vehicle vehicle = new Vehicle();
        vehicle.setIdVehicle(1);
        vehicle.setIdGroupVehicle(3);
        vehicle.setBrand("Ktm");
        vehicle.setModel("Freeride ");
        vehicle.setMaxRange(150);
        vehicle.setWeight(150);
        vehicle.setPricePerSale(40000);
        vehicle.setMaxSpeed(150);
        vehicle.setLatitude(49.67643561098892);
        vehicle.setLongitude(19.757226741508546);
        vehicle.setLocationName("adsdsasds");


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setIdVehicle(1);
        vehicle1.setIdGroupVehicle(3);
        vehicle1.setBrand("Yamaha ");
        vehicle1.setModel("r1 ");
        vehicle1.setMaxRange(300);
        vehicle1.setWeight(200);
        vehicle1.setPricePerSale(100000);
        vehicle1.setMaxSpeed(299);
        vehicle1.setLatitude(49.64726726960124);
        vehicle1.setLongitude(19.879460107526455);
        vehicle1.setLocationName("sds");
        return motoreBike;
    }
    List<Vehicle> bikes = new ArrayList<>();
    @Override
    public List<Vehicle> getAllBike() {
        Vehicle vehicle = new Vehicle();
        vehicle.setIdVehicle(1);
        vehicle.setIdGroupVehicle(4);
        vehicle.setBrand("Ktm");
        vehicle.setModel("Freeride ");
        vehicle.setMaxRange(50);
        vehicle.setWeight(25);
        vehicle.setPricePerSale(10000);
        vehicle.setMaxSpeed(50);
        vehicle.setLatitude(49.67643561098892);
        vehicle.setLongitude(19.757226741508546);
        vehicle.setLocationName("adsdsasds");


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setIdVehicle(1);
        vehicle1.setIdGroupVehicle(4);
        vehicle1.setBrand("Merida ");
        vehicle1.setModel("xd ");
        vehicle1.setMaxRange(66);
        vehicle1.setWeight(30);
        vehicle1.setPricePerSale(15000);
        vehicle1.setMaxSpeed(26699);
        vehicle1.setLatitude(49.64726726960124);
        vehicle1.setLongitude(19.879460107526455);
        vehicle1.setLocationName("sdsdss");
        return bikes;
    }
    List<Vehicle> scooters = new ArrayList<>();
    @Override
    public List<Vehicle> getAllScooter() {
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
        vehicle1.setIdVehicle(1);
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
        return scooters;
    }
}
