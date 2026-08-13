package com.payroll.employee_payroll_management_system.controller;

import com.payroll.employee_payroll_management_system.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if (userService.login(username, password)) {
            return "Login successful";
        }

        return "Invalid username or password";
    }
}