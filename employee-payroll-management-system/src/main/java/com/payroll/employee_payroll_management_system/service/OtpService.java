package com.payroll.employee_payroll_management_system.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class OtpService {

    private final Random random = new Random();

    public String generateOtp() {
        return String.valueOf(100000 + random.nextInt(900000));
    }
}