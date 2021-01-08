package pl.edu.wszib.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class RentServiceImplTest {
    @Autowired
    private MockMvc mockMvc;


   



    @Test
    public double price2(int idGroupVehicle,double howLong){
        double pricePerMinute = 0;
        double price = 0;
        if(idGroupVehicle == 1) {
            pricePerMinute=0.5;
            price = howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 2){
            pricePerMinute = 1;
            price= howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 3){
            pricePerMinute = 0.7;
            price = howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 4){
            pricePerMinute= 0.3;
            price = howLong * pricePerMinute;
            return price;
        }
        throw new IllegalArgumentException("Incorrect idGroupVehicle: " + idGroupVehicle);
    }
    @Test
    public double price3(int idGroupVehicle,double howLong){
        double pricePerMinute = 0;
        double price = 0;
        if(idGroupVehicle == 1) {
            pricePerMinute=0.5;
            price = howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 2){
            pricePerMinute = 1;
            price= howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 3){
            pricePerMinute = 0.7;
            price = howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 4){
            pricePerMinute= 0.3;
            price = howLong * pricePerMinute;
            return price;
        }
        throw new IllegalArgumentException("Incorrect idGroupVehicle: " + idGroupVehicle);
    }
    @Test
    public double price4(int idGroupVehicle,double howLong){
        double pricePerMinute = 0;
        double price = 0;
        if(idGroupVehicle == 1) {
            pricePerMinute=0.5;
            price = howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 2){
            pricePerMinute = 1;
            price= howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 3){
            pricePerMinute = 0.7;
            price = howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 4){
            pricePerMinute= 0.3;
            price = howLong * pricePerMinute;
            return price;
        }
        throw new IllegalArgumentException("Incorrect idGroupVehicle: " + idGroupVehicle);
    }
}
