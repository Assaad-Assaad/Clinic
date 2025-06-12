# 🏥 Clinic Application

## Overview
**Clinic** is a RESTful API built with **Spring Boot** and **Maven**. It is designed to manage **patients** and their **appointments**. The system provides endpoints to register patients, retrieve patient information, create appointments, and view today’s scheduled visits. The project is modular, validated using Spring’s `@Valid`, and follows clean RESTful design principles.

---

## Project Objectives
This project aims to:
- Provide a simple, backend-only clinic management API.
- Allow registering and retrieving patient information.
- Allow scheduling appointments for patients.
- Provide endpoints to retrieve today's appointments.

---

## Features
1. **Patient Management**:
   - Register new patients.
   - Retrieve all patients or individual patient records.

2. **Appointment Management**:
   - Schedule an appointment for a patient.
   - View all appointments scheduled for the current day.

3. **Validation**:
   - Uses Spring’s validation mechanism to ensure data integrity.

---

## API Endpoints

### Patients
| HTTP Method | Endpoint            | Description                    |
|-------------|---------------------|--------------------------------|
| GET         | `/patients`         | Retrieve all patients.         |
| GET         | `/patients/{id}`    | Retrieve a patient by ID.      |
| POST        | `/patients`         | Register a new patient.        |

### Appointments
| HTTP Method | Endpoint                          | Description                          |
|-------------|-----------------------------------|--------------------------------------|
| POST        | `/patients/appointment/{id}`      | Create an appointment for a patient. |
| GET         | `/patients/appointments/today`    | Retrieve today's appointments.       |

---

## ⚙️ Technology Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Validation**
- **Maven**
- **Spring Data JPA**
- **MySQL**


---

## 🛠 Project Setup

### 📦 Prerequisites

- Java 17 or higher
- Maven 3.6 or higher


