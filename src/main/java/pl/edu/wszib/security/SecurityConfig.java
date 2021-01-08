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
                //.antMatchers("/showInfo").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/rentAppPage/*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/addVehicle").hasAuthority("ROLE_ADMIN")
                .antMatchers("/getVehicle").hasAuthority("ROLE_ADMIN")
                .antMatchers("/removeVehicle").hasAuthority("ROLE_ADMIN")
                .antMatchers("/updateVehicle").hasAuthority("ROLE_ADMIN")
                .antMatchers("/allUser").hasAuthority("ROLE_ADMIN")
                .antMatchers("/resultGet").hasAuthority("ROLE_ADMIN")
                .antMatchers("/addUser").hasAuthority("ROLE_ADMIN")
                .antMatchers("/getUser").hasAuthority("ROLE_ADMIN")
                .antMatchers("/updateUser").hasAuthority("ROLE_ADMIN")
                .antMatchers("/removeUserById").hasAuthority("ROLE_ADMIN")
                .antMatchers("/price").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/allScooter").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/allCar").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/allMotorBike").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/allBike").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/distance").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/user").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/rent").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/rent2").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/buy").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/buy2").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/thanks").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/rentAppPage").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true);
        ;
    }
}
