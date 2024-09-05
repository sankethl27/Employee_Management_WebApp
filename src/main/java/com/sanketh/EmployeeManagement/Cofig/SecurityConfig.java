package com.sanketh.EmployeeManagement.Cofig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http
////                .authorizeHttpRequests(auth -> {
////                    auth.requestMatchers("/loginController").permitAll();
////                    auth.anyRequest().authenticated();
////                })
////                .formLogin(form ->
////                        form
////                                .loginPage("/loginController")               // Specify the custom loginController page
////                                .permitAll()                       // Allow everyone to access the loginController page
////                                .defaultSuccessUrl("/")            // Redirect to the homepage on successful loginController
////                                .failureUrl("/loginController?error=true")   // Redirect to the loginController page with an error on failure
////                )
////                .oauth2Login(oauth2 -> oauth2
////                        .loginPage("/loginController")                        // Specify the custom loginController page for OAuth2 loginController
////                )
////                .formLogin(Customizer.withDefaults())
////                .build();
////    }
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        //define query to retrieve users by user name query
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT email, password, enabled FROM employees WHERE email = ?");
//
//        //define query to retrieve the authorities roles by username
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "SELECT email, authority FROM authorities WHERE email = ?");
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
////                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
////                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
////                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
////                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
////                        .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("ADMIN")
//                        .anyRequest().authenticated() // Ensure other requests are authenticated
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/authenticateTheUser")
//                        .permitAll()
//                )
////                .oauth2Login(oauth2 -> oauth2
////                        .loginPage("/login")                // Specify the custom loginController page for OAuth2 loginController
////                )
//                .csrf(csrf -> csrf.disable());          // Disable CSRF protection
//
//        return http.build();
//    }
//}

@Configuration
public class SecurityConfig{

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails sanketh = User.builder()
                .username("sanketh")
                .password("{noop}test123")
                .roles("TEAMLEAD","EMPLOYEE","ADMIN")
                .build();

        UserDetails vivek = User.builder()
                .username("vivek")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(sanketh , vivek);
    }
}