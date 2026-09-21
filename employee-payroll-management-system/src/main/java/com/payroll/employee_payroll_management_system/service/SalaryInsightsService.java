package com.payroll.employee_payroll_management_system.service;

import com.payroll.employee_payroll_management_system.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryInsightsService {

    public String getSalaryInsights(List<Employee> employees) {

        if (employees.isEmpty()) {
            return "No employee data available";
        }

        double total = 0;
        double highest = employees.get(0).getSalary();
        double lowest = employees.get(0).getSalary();

        for (Employee employee : employees) {

            double salary = employee.getSalary();

            total += salary;

            if (salary > highest) {
                highest = salary;
            }

            if (salary < lowest) {
                lowest = salary;
            }
        }

        double average = total / employees.size();

        return "Average Salary: " + String.format("%.2f", average)
                + " | Highest Salary: " + highest
                + " | Lowest Salary: " + lowest;
    }
}
