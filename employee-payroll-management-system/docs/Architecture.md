# System Architecture

## Employee Payroll Management System

The Employee Payroll Management System follows a layered architecture using Spring Boot and MySQL.

## Architecture Layers

### 1. Presentation Layer

The Presentation Layer receives requests from the user through REST API endpoints.

Responsibilities:

- Accept user requests
- Send requests to the backend
- Display responses

### 2. Controller Layer

The Controller Layer handles HTTP requests and maps them to the appropriate service methods.

Responsibilities:

- Handle GET requests
- Handle POST requests
- Handle PUT requests
- Handle DELETE requests

### 3. Service Layer

The Service Layer contains the main business logic of the application.

Responsibilities:

- Process employee information
- Perform payroll calculations
- Validate data
- Apply business rules

### 4. Repository Layer

The Repository Layer communicates with the MySQL database.

Responsibilities:

- Save employee records
- Retrieve employee records
- Update employee records
- Delete employee records

### 5. Database Layer

MySQL is used to store employee and payroll information.

## Architecture Flow

```text
User
  ↓
REST API
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
MySQL Database