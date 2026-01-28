## **Project Update: Core OOP Implementation**

This project is an ongoing development of the **MotorPH Payroll System**. The latest updates focus on refactoring the core logic to strictly follow **Object-Oriented Programming (OOP)** principles, specifically focusing on **Inheritance**, **Encapsulation**, and **Abstraction**.

> [!IMPORTANT]
> **Status:** Code is being continued. Current efforts are focused on modularizing the `model` package to allow for scalable employee management.

---

### **Key OOP Principles Applied**

#### **1. Inheritance (New Update)**

We have introduced a hierarchical structure to the employee data model. By using the `extends` keyword, we've created a relationship where specific employee types (like `regularEmployee`) inherit all identity and financial attributes from the base `Employee` class. This eliminates code redundancy and improves maintainability.

#### **2. Encapsulation**

Applied in **`Employee.java`** using `protected` access modifiers and `public` getters. This ensures that sensitive data, such as `basicSalary` and `sss`, are protected and only accessible through controlled methods.

#### **3. Abstraction**

The system uses the **`grossPayable.java`** interface to define the structural requirements for salary computations. By declaring the `Employee` class as `abstract`, we ensure that a generic employee cannot be instantiated, forcing the use of specialized subclasses that implement the specific logic for weekly gross salary.

---

### **File Overview**

The following files represent the core logic of the system's architecture:

| File Name | Role in System | OOP Principle |
| --- | --- | --- |
| **`Employee.java`** | Base Data Model & Template | **Encapsulation & Abstraction** |
| **`regularEmployee.java`** | Specific Logic Implementation | **Inheritance** |
| **`grossPayable.java`** | System-wide Interface | **Abstraction** |

---

### **Folder Structure**

The files are organized for easy access and modularity:

* `src/model/`: Contains the data models and business logic.
* `src/gui/`: Contains the visual components (Swing/AWT).
* `src/assets/`: Contains project resources like images and icons.
