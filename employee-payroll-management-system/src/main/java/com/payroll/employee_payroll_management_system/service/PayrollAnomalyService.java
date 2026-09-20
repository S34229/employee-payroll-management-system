package com.payroll.employee_payroll_management_system.service;

import com.payroll.employee_payroll_management_system.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class PayrollAnomalyService {

    public String checkSalaryAnomaly(Employee employee, double previousSalary) {

        double currentSalary = employee.getSalary();

        if (previousSalary > 0) {

            double change = Math.abs(currentSalary - previousSalary);
            double percentage = (change / previousSalary) * 100;

            if (percentage >= 30) {
                return "Payroll Anomaly Detected: Salary changed by "
                        + String.format("%.2f", percentage) + "%";
            }
        }

        return "No Payroll Anomaly Detected";
    }
}
