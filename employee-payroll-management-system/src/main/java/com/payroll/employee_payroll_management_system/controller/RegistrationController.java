package com.payroll.employee_payroll_management_system.controller;

import com.payroll.employee_payroll_management_system.entity.User;
import com.payroll.employee_payroll_management_system.repository.UserRepository;
import com.payroll.employee_payroll_management_system.service.EmailService;
import com.payroll.employee_payroll_management_system.service.OtpService;
import com.payroll.employee_payroll_management_system.service.OtpStorage;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final OtpService otpService;
    private final OtpStorage otpStorage;
    private final EmailService emailService;

    public RegistrationController(
            UserRepository userRepository,
            OtpService otpService,
            OtpStorage otpStorage,
            EmailService emailService) {

        this.userRepository = userRepository;
        this.otpService = otpService;
        this.otpStorage = otpStorage;
        this.emailService = emailService;
    }

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String email) {

        String otp = otpService.generateOtp();

        otpStorage.saveOtp(email, otp);
        emailService.sendOtp(email, otp);

        return "OTP sent successfully";
    }
    @PostMapping("/verify-otp")
public String verifyOtp(@RequestParam String email,
                        @RequestParam String otp) {

    if (otpStorage.verifyOtp(email, otp)) {
        return "OTP verified successfully";
    }

    return "Invalid OTP";
}
@PostMapping("/create-account")
public String createAccount(
        @RequestParam String email,
        @RequestParam String username,
        @RequestParam String password) {

    if (!otpStorage.verifyOtp(email, otpStorage.getOtp(email))) {
        return "Please verify OTP first";
    }

    if (userRepository.findByUsername(username).isPresent()) {
        return "Username already exists";
    }

    User user = new User(username, email, password, "USER");
    userRepository.save(user);

    return "Account created successfully";
}
}