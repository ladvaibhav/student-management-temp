
# Student Management System

A Spring Boot REST API for managing student records.

## 🚀 Features
- Create, Read, Update, Delete students
- Search by ID, Email, Name
- Validation using Jakarta Validation
- Exception handling
- Layered architecture (Controller, Service, Repository)

## 🛠 Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL / H2
- Maven

## 📌 API Endpoints
| Method | Endpoint | Description |
|------|---------|-------------|
| POST | /v1/students | Create student |
| GET | /v1/students/all | Get all students |
| GET | /v1/students/id/{id} | Get by ID |
| GET | /v1/students/email/{email} | Get by email |
| GET | /v1/students/name/{name} | Get by name |
| PUT | /v1/students/{id} | Update student |
| DELETE | /v1/students/id/{id} | Delete by ID |

## 🧪 Status
🚧 **Work in Progress**

## 📌 Author
Vaibhav Lad
