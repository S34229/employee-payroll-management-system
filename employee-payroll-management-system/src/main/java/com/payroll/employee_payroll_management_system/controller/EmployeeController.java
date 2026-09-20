package com.payroll.employee_payroll_management_system.controller;

import com.payroll.employee_payroll_management_system.entity.Employee;
import com.payroll.employee_payroll_management_system.service.EmployeeService;
import com.payroll.employee_payroll_management_system.service.PayrollAnomalyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.payroll.employee_payroll_management_system.service.PayrollAnomalyService;
import com.payroll.employee_payroll_management_system.service.AttendanceSalaryValidationService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

@Autowired
private PayrollAnomalyService payrollAnomalyService;

@Autowired
private AttendanceSalaryValidationService attendanceSalaryValidationService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

@PutMapping("/{id}")
public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    return service.updateEmployee(id, employee);
}
@GetMapping("/anomaly/{id}")
public String checkPayrollAnomaly(
        @PathVariable Long id,
        @RequestParam double previousSalary) {

    Employee employee = service.getAllEmployees()
            .stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .orElse(null);

    if (employee == null) {
        return "Employee not found";
    }

    return payrollAnomalyService.checkSalaryAnomaly(employee, previousSalary);
}
@GetMapping("/attendance-validation/{id}")
public String validateAttendanceSalary(
        @PathVariable Long id,
        @RequestParam int presentDays,
        @RequestParam int totalDays) {

    Employee employee = service.getAllEmployees()
            .stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .orElse(null);

    if (employee == null) {
        return "Employee not found";
    }

    return attendanceSalaryValidationService.validateSalary(
            employee, presentDays, totalDays);
}
}
