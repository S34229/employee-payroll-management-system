# Employee Payroll Management System

## Overview

The Employee Payroll Management System is a Java and Spring Boot based application developed to digitally manage employee information and payroll details in a centralized system.

The system helps authorized users maintain employee records, manage salary information and perform payroll-related operations efficiently.

## Problem Statement

Managing employee details and salary information manually is time-consuming and may lead to errors. Maintaining employee records using manual files or spreadsheets makes it difficult to search, update and manage payroll information efficiently.

## Proposed Solution

The Employee Payroll Management System provides a centralized digital solution for managing employee and payroll information.

The system allows authorized users to add, view and update employee records such as employee name, department and salary.

## Objectives

- Reduce manual work in payroll management.
- Improve employee data accuracy.
- Maintain employee information in a centralized system.
- Provide efficient employee record management.
- Make payroll information easier to manage and update.

## Technologies Used

- Java
- Spring Boot
- MySQL
- REST API
- Maven
- Git
- GitHub
- Visual Studio Code

## Project Structure

```text
employee-payroll-management-system
│
├── docs
│   ├── Problem-statement.md
│   └── ER-Diagram.md
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.payroll.employee_payroll_management_system
│   │   │       ├── controller
│   │   │       ├── entity
│   │   │       ├── repository
│   │   │       └── service
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md

##  Main Features

--> Add employee details
--> View employee details
--> Update employee details
--> Manage salary information
--> Store employee records in MySQL
--> REST API based employee operations

## Proposed Unique Features

1. Payroll Anomaly Alert

The system can identify unusual payroll values, such as an unexpected salary change, and provide an alert for verification before payroll processing.

2. Salary Revision History

The system can maintain a history of salary changes for each employee, including the previous salary, updated salary and revision date.

## Database

MySQL is used as the database to store employee and payroll-related information.
The database design is documented in:
docs/ER-Diagram.md

## API
REST APIs are used to perform operations on employee records.
Planned operations include:
Create Employee
Get Employee
Get All Employees
Update Employee
Delete Employee

## Development Workflow
The project is developed using Git and GitHub for version control.
Each major project update is committed and pushed to the GitHub repository.

## Project Status
🚧 Project under development.

** Author
Swathi J
BE Computer Science and Engineering

##  License
This project is developed for academic purposes.
