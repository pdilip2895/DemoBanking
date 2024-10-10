# Demo Banking Application

This is a **Demo Banking Application** built using Spring Boot. The application provides functionalities to manage accounts and perform basic banking operations. The repository includes various components such as controllers, services, entities, and repositories to handle different aspects of the banking system.

## Features

- **Account Management**: Create, retrieve, update, and delete bank accounts.
- **REST API**: Exposes endpoints for interacting with the banking application.
- **DTO and Mapper Support**: Ensures clean data transfer between the application layers.
- **Service Layer**: Contains business logic to manage accounts.
- **Repository Layer**: Handles data access and interaction with the database.

## Project Structure

```bash
src/
├── main/
│   ├── java/com/dilip/banking1/
│   │   ├── Banking1Application.java         # Main application class
│   │   ├── controller/AccountController.java # REST controller for account operations
│   │   ├── dto/AccountDto.java               # Data Transfer Object for accounts
│   │   ├── entity/Account.java               # Account entity representing database table
│   │   ├── mapper/AccountMapper.java         # Mapper to map between DTO and Entity
│   │   ├── repository/AccountRepository.java # Repository interface for account persistence
│   │   ├── service/                         # Business service logic
│   │   │   ├── AccountService.java
│   │   │   └── impl/AccountServiceImpl.java  # Implementation of AccountService
│   ├── resources/
│   │   ├── application.properties            # Spring Boot application configuration
│   └── test/java/com/dilip/banking1/
│       └── Banking1ApplicationTests.java     # Unit tests for the application


Technologies Used

Java 21
Spring Boot 3.24
Maven: Build automation tool
MySQL: Database for storing account details
Spring Data JPA: For repository and database interactions
Lombok: Used to reduce boilerplate code
JUnit: For unit testing
Getting Started

Prerequisites
Java 21
Maven 3.x or higher
MySQL (or any other relational database)
Git

Example Endpoints:
GET /api/v1/accounts – Get all accounts
POST /api/v1/accounts – Create a new account
GET /api/v1/accounts/{id} – Get account details by ID
PUT /api/v1/accounts/{id} – Update account details
DELETE /api/v1/accounts/{id} – Delete an account
Contributing

Fork the repository.
Create a feature branch (git checkout -b feature/your-feature-name).
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature/your-feature-name).
Open a pull request.
