package com.payroll.employee_payroll_management_system.service;

import com.payroll.employee_payroll_management_system.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollHealthDashboardService {

    public String getPayrollHealth(List<Employee> employees) {

        if (employees.isEmpty()) {
            return "Payroll Health: No employee data available";
        }

        double totalSalary = 0;

        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }

        double averageSalary = totalSalary / employees.size();

        return "Payroll Health: Healthy | Employees: "
                + employees.size()
                + " | Average Salary: "
                + String.format("%.2f", averageSalary);
    }
}