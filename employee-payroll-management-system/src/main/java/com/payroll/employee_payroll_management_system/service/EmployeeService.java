package com.payroll.employee_payroll_management_system.service;

import com.payroll.employee_payroll_management_system.entity.Employee;
import com.payroll.employee_payroll_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }
    public Employee updateEmployee(Long id, Employee employee) {
    Employee existingEmployee = repository.findById(id).orElse(null);

    if (existingEmployee != null) {
        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        return repository.save(existingEmployee);
    }

    return null;
}
}