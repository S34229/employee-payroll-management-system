package com.payroll.employee_payroll_management_system.controller;

import com.payroll.employee_payroll_management_system.entity.Employee;
import com.payroll.employee_payroll_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

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
}