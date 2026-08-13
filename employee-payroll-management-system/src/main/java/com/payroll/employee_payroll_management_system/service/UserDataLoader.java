package com.payroll.employee_payroll_management_system.service;

import com.payroll.employee_payroll_management_system.entity.User;
import com.payroll.employee_payroll_management_system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        if (userRepository.findByUsername("admin").isEmpty()) {

            User user = new User(
                    "admin",
                    "admin123",
                    "ADMIN"
            );

            userRepository.save(user);
        }
    }
}