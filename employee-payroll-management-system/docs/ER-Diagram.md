# ER Diagram

## Employee Payroll Management System

### Entities

#### Employee
- employee_id (PK)
- employee_name
- email
- phone
- department
- designation
- basic_salary
- joining_date

#### Payroll
- payroll_id (PK)
- employee_id (FK)
- basic_salary
- allowances
- deductions
- net_salary
- pay_date

#### Attendance
- attendance_id (PK)
- employee_id (FK)
- attendance_date
- status
- overtime_hours

#### User
- user_id (PK)
- username
- password
- role

### Relationships

- One Employee can have many Payroll records.
- One Employee can have many Attendance records.
- One User can manage multiple Employee records.