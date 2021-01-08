package pl.edu.wszib.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class DistanceServiceImplTest {
    @Autowired
    private MockMvc mockMvc;



    @Test
    public double  distance(double lat1, double lon1, double lat2, double lon2){
        double R = 6371e3; // metry
        double φ1 = lat1 * Math.PI / 180; // φ, λ w radianach
        double φ2 = lat2 * Math.PI / 180;
        double Δφ = (lat2-lat1) * Math.PI / 180;
        double Δλ = (lon2-lon1) * Math.PI / 180;

        double a = Math.sin (Δφ / 2) * Math.sin (Δφ / 2) +
                Math.cos (φ1) * Math.cos (φ2) *
                        Math.sin (Δλ / 2) * Math.sin (Δλ / 2);
        double c = 2 * Math.atan2 (Math.sqrt (a), Math.sqrt (1-a));

        double d = R * c; // w metrach
        d = Math.round(d);
        return  d/1000;
    }
}
