package com.payroll.employee_payroll_management_system.service;

import com.payroll.employee_payroll_management_system.entity.User;
import com.payroll.employee_payroll_management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}