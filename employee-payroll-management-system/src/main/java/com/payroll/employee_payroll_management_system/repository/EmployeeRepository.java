package com.payroll.employee_payroll_management_system.repository;

import com.payroll.employee_payroll_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}