
package com.example.rbacdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // enables @PreAuthorize on controller methods
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService uds) {
        this.userDetailsService = uds;
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
            .authorizeHttpRequests(auth -> auth
                // static + login allowed
                .requestMatchers("/css/**","/js/**","/images/**","/webjars/**","/login","/error","/403").permitAll()

                // View products: USER or higher
                .requestMatchers(HttpMethod.GET, "/products/**").hasAnyRole("USER","MANAGER","ADMIN")

                // Create/Update products: MANAGER or ADMIN
                .requestMatchers(HttpMethod.POST, "/products/**").hasAnyRole("MANAGER","ADMIN")
                .requestMatchers(HttpMethod.PUT,  "/products/**").hasAnyRole("MANAGER","ADMIN")

                // Delete: ADMIN only
                .requestMatchers(HttpMethod.DELETE,"/products/**").hasRole("ADMIN")

                // Home/dashboard requires login
                .requestMatchers("/", "/home").authenticated()

                // everything else
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )
            .exceptionHandling(ex -> ex
                .accessDeniedPage("/403")
            )
            // CSRF is ON by default; keep it enabled and include tokens in forms
            .csrf(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // strong hash
    }


}
