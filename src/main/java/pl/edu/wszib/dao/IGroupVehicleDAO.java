package pl.edu.wszib.dao;

import pl.edu.wszib.model.GroupVehicle;

import java.util.List;

public interface IGroupVehicleDAO {
    void addGroupVehicle(GroupVehicle groupVehicle);

    GroupVehicle removeGroupVehicleId(int idGroupVehicle);

    GroupVehicle getGroupVehicle(int idGroupVehicle);

    java.util.List<GroupVehicle> getPriceCar();


    java.util.List<GroupVehicle> getPriceMotorBike();

    java.util.List<GroupVehicle> getPriceBike();

    java.util.List<GroupVehicle> getPriceScooter();

    List<GroupVehicle> getPriceVehicle();
}
