# College Campus Placement Management System

A Java-based application developed to automate and streamline campus placement activities by managing Students, Companies, and Job Applications efficiently.

This project is built using Core Java, JDBC, and Oracle Database, following a clean layered architecture to ensure maintainability, modularity, and scalability.


## Features:

Add new students with academic details

Add and manage company recruitment details

Apply students to companies

Validate student eligibility based on CGPA

Organized layered architecture (Bean → DAO → Service → App)

## Tech Stack:

Backend: Java, JDBC

Database: Oracle SQL

IDE: Eclipse

JDK: Java SE 23

Version Control: Git & GitHub

## Project Structure:
```plaintext

/ CollegeCampusManagementSystem
│
├── src
│
├── com.placement.app
│      └── PlacementMain.java
│
├── com.placement.bean
│      ├── Application.java
│      ├── Company.java
│      └── Student.java
│
├── com.placement.dao
│      ├── ApplicationDAO.java
│      ├── CompanyDAO.java
│      └── StudentDAO.java
│
├── com.placement.service
│      └── PlacementService.java
│
├── com.placement.util
│      ├── ActiveApplicationsExistException.java
│      ├── DBUtil.java
│      ├── EligibilityViolationException.java
│      └── ValidationException.java
│
└── Query.txt
```
## Architecture:

The application follows a structured layered architecture:

### Model (Bean Layer):

Student.java – Represents student details

Company.java – Represents company details

Application.java – Represents job application records

### DAO Layer:

Handles all database operations using JDBC

Performs insert, update, delete, and fetch operations

### Service Layer:

Contains business logic

Performs eligibility validation

Manages application constraints

Throws custom exceptions

### App Layer:

PlacementMain.java

Provides menu-driven console interaction

### Utility Layer:

DBUtil.java → Handles database connectivity

Custom exception classes → Manage validation and eligibility errors

## Database Schema:
Table: STUDENT:
```plaintext
| Column Name | Description    |
| ----------- | -------------- |
| student_id  | Primary Key    |
| name        | Student Name   |
| branch      | Department     |
| cgpa        | Academic CGPA  |
| phone       | Contact Number |
```
Table: COMPANY:
```plaintext
| Column Name | Description    |
| ----------- | -------------- |
| student_id  | Primary Key    |
| name        | Student Name   |
| branch      | Department     |
| cgpa        | Academic CGPA  |
| phone       | Contact Number |
```
Table: COMPANY:
```plaintext
| Column Name  | Description           |
| ------------ | --------------------- |
| company_id   | Primary Key           |
| company_name | Company Name          |
| min_cgpa     | Minimum CGPA Required |
| package      | Salary Package        |
```
<img width="1524" height="178" alt="image" src="https://github.com/user-attachments/assets/112b1b60-95ea-4d30-b217-15e08aa74094" />

<img width="1576" height="224" alt="image" src="https://github.com/user-attachments/assets/4b2bdab1-9572-4d77-a21c-18369bea5e2c" />

<img width="884" height="732" alt="image" src="https://github.com/user-attachments/assets/93fbaa37-2c04-483a-8cd0-c5acd9c58663" />

## How to Run the Project:

- Clone the Repository
git clone https://github.com/your-username/CollegeCampusManagementSystem.git
- Import into Eclipse

File → Import → Existing Projects into Workspace

Select the project folder

- Setup Database

Create STUDENT table

Create COMPANY table

Create APPLICATION table

Add required constraints and foreign keys

Update database credentials in DBUtil.java

- Add Oracle JDBC Driver

Add ojdbc6.jar (or compatible version) to Referenced Libraries

- Run the Application

Run PlacementMain.java

Use console menu options

## Test Scenarios:

Add student with valid & invalid CGPA

Add company with eligibility criteria

Apply eligible student to company

Prevent application if CGPA is below required minimum

## Exception Handling:

Custom exceptions implemented:

ValidationException

EligibilityViolationException

ActiveApplicationsExistException

These ensure structured error handling and clean business logic separation.

## Output Screenshot:
<img width="740" height="429" alt="image" src="https://github.com/user-attachments/assets/70b2ef63-aad6-44ea-8326-28e135ac2eec" />

## Student Details:

Name: Vishvadharshini

