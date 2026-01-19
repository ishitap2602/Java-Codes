
package com.example.rbacdemo;

import com.example.rbacdemo.security.Role;
import com.example.rbacdemo.user.User;
import com.example.rbacdemo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BootstrapData {

    @Bean
    CommandLineRunner initUsers(UserRepository users, PasswordEncoder encoder) {
        return args -> {
            createIfMissing(users, encoder, "admin",   "password", Role.ADMIN);
            createIfMissing(users, encoder, "manager", "password", Role.MANAGER);
            createIfMissing(users, encoder, "user",    "password", Role.USER);
        };
    }

    private void createIfMissing(UserRepository repo, PasswordEncoder encoder,
                                 String username, String rawPassword, Role role) {
        repo.findByUsername(username).ifPresentOrElse(
            u -> {},
            () -> {
                User u = new User();
                u.setUsername(username);
                u.setPassword(encoder.encode(rawPassword));
                u.setRole(role);
                u.setEnabled(true);
                repo.save(u);
            }
        );
    }
}
