package pl.edu.wszib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import pl.edu.wszib.service.UserDetailsService;
import pl.edu.wszib.service.impl.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();

        http.authorizeRequests()

                .antMatchers("/").authenticated()
                .antMatchers("/rentAppPage/*").hasRole("ADMIN")
                .antMatchers("/addVehicle").hasRole("ADMIN")
                .antMatchers("/getVehicle").hasRole("ADMIN")
                .antMatchers("/removeVehicle").hasRole("ADMIN")
                .antMatchers("/updateVehicle").hasRole("ADMIN")
                .antMatchers("/allUser").hasRole("ADMIN")
                .antMatchers("/resultGet").hasRole("ADMIN")
                .antMatchers("/addUser").hasRole("ADMIN")
                .antMatchers("/getUser").hasRole("ADMIN")
                .antMatchers("/updateUser").hasRole("ADMIN")
                .antMatchers("/removeUserById").hasRole("ADMIN")
                .antMatchers("/price").hasRole("USER")
                .antMatchers("/allScooter").permitAll()
                .antMatchers("/allCar").permitAll()
                .antMatchers("/allMotorBike").permitAll()
                .antMatchers("/allBike").permitAll()
                .antMatchers("/distance").permitAll()
                .antMatchers("/user").permitAll()
                .antMatchers("/rent").permitAll()
                .antMatchers("/rent2").permitAll()
                .antMatchers("/buy").permitAll()
                .antMatchers("/buy2").permitAll()
                .antMatchers("/thanks").permitAll()
                .antMatchers("/rentAppPage").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true);
        ;

        http.sessionManagement()
                //.expiredUrl("/sessionExpired.html")
                .invalidSessionUrl("/login.html");
    }
}
