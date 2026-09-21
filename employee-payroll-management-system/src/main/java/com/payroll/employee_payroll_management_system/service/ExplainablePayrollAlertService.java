package com.payroll.employee_payroll_management_system.service;

import com.payroll.employee_payroll_management_system.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class ExplainablePayrollAlertService {

    public String generateAlert(
            Employee employee,
            double previousSalary,
            int presentDays,
            int totalDays) {

        StringBuilder alert = new StringBuilder();

        if (previousSalary > 0) {

            double change =
                    Math.abs(employee.getSalary() - previousSalary);

            double percentage =
                    (change / previousSalary) * 100;

            if (percentage >= 30) {
                alert.append("Salary changed significantly. ");
            }
        }

        if (totalDays > 0 && presentDays < totalDays) {
            alert.append("Attendance is below full working days. ");
        }

        if (alert.length() == 0) {
            return "No major payroll alert detected.";
        }

        return "Payroll Alert: " + alert;
    }
}