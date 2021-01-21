package pl.edu.wszib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import pl.edu.wszib.service.impl.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();

        http.authorizeRequests()

                .antMatchers("/").authenticated()
                .antMatchers("/rentAppPage/*").permitAll()
                .antMatchers("/addVehicle").permitAll()
                .antMatchers("/getVehicle").permitAll()
                .antMatchers("/removeVehicle").permitAll()
                .antMatchers("/updateVehicle").permitAll()
                .antMatchers("/allUser").permitAll()
                .antMatchers("/resultGet").permitAll()
                .antMatchers("/addUser").permitAll()
                .antMatchers("/getUser").permitAll()
                .antMatchers("/updateUser").permitAll()
                .antMatchers("/removeUserById").permitAll()
                .antMatchers("/price").permitAll()
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
                .antMatchers("/thanks2").permitAll()
                .antMatchers("/result2").permitAll()
                .antMatchers("/rentAppPage").permitAll()
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
