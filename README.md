# MotorPH Payroll System (Bravo Version)

### **Course: MO-IT110 – Object-Oriented Programming**
**Group 28 – Milestone 2 Implementation Package**

---

## 🛠 Project Overview
MotorPH Payroll System is a Java-based desktop application designed to streamline employee management, attendance tracking, and payroll processing. The "Bravo Version" introduces a robust layered architecture, role-based access control, and an integrated IT support ticketing system.

This project was developed as a major requirement for the **Object-Oriented Programming (MO-IT110)** subject, demonstrating the practical application of software design patterns and lifecycle management.

---

## 👥 The Developers (Group 28)
* **Anton Roger Galfo** – Service & DAO Layer, Authentication Logic, RBAC
* **Sunny Eljohn Lico** – System Architecture, IT Support & Ticket Management
* **Carl Justine Pontanilla** – Employee Management, Salary Computation Pipeline
* **Isidro Romano** – Quality Assurance, Smoke Testing, & Documentation

---

## ✨ Key Features
* **Role-Based Access Control (RBAC):** Distinct dashboards for Staff (Admin/HR) and regular Employees.
* **Payroll Engine:** Automated calculation of Gross Pay, Deductions (SSS, PhilHealth, Pag-IBIG, Tax), and Net Pay.
* **Attendance Management:** Comprehensive tracking and filtering of employee work hours.
* **IT Support Module:** A built-in ticketing system using UUIDs for tracking technical issues.
* **Security:** Account lockout mechanism (60-second cooldown after 3 failed login attempts).

---

## 🏗 OOP Principles Applied
To meet the "Advanced" criteria of the project rubric, we implemented the following:
* **Inheritance & Abstraction:** Used an abstract `Employee` class and `RegularEmployee` subclass to share core logic while allowing for specific payroll implementations.
* **Interfaces:** Implemented the `IPayable` interface to ensure a standardized contract for all salary-related computations.
* **Encapsulation:** All model attributes are kept private and accessed via strict Getters and Setters to protect data integrity.
* **Polymorphism:** Utilized polymorphic methods in the GUI to handle different employee types during computation.

---

## 📂 Project Structure (Layered Architecture)
The project is organized into clear packages to ensure high modularity:
* `gui`: Handles the Swing-based user interface and event listeners.
* `service`: Contains business logic for payroll, leaves, and attendance.
* `dao`: (Data Access Object) Handles all file I/O operations with CSV data sources.
* `model`: Defines the core objects (Employee, Ticket, Deduction, etc.).

---

## 🚀 Getting Started
1. **Prerequisites:** Ensure you have Java JDK 11 or higher installed.
2. **Clone the Repo:** ```bash
   git clone -b MotorPH_Payroll-Bravo-Version [https://github.com/siejeihyung/MotorPH_OOP-Group-28.git](https://github.com/siejeihyung/MotorPH_OOP-Group-28.git)
