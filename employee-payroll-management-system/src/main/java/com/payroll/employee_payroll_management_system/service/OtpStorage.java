package com.payroll.employee_payroll_management_system.service;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class OtpStorage {

    private final Map<String, String> otpMap = new HashMap<>();

    public void saveOtp(String email, String otp) {
        otpMap.put(email, otp);
    }

    public boolean verifyOtp(String email, String otp) {
        return otp.equals(otpMap.get(email));
    }
    public String getOtp(String email) {
    return otpMap.get(email);
}
}