package com.payroll.employee_payroll_management_system.service;

import com.payroll.employee_payroll_management_system.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class AttendanceSalaryValidationService {

    public String validateSalary(Employee employee, int presentDays, int totalDays) {

        if (totalDays <= 0 || presentDays < 0 || presentDays > totalDays) {
            return "Invalid attendance details";
        }

        double expectedSalary =
                employee.getSalary() * ((double) presentDays / totalDays);

        double difference =
                Math.abs(employee.getSalary() - expectedSalary);

        if (difference > 0.01) {
            return "Attendance-Salary Mismatch Detected";
        }

        return "Attendance and Salary are Valid";
    }
}
