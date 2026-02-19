🛠 Employee & Leave Management Module
This module implements the core business logic for employee data and leave tracking using standard OOP design patterns.

Technical Implementation
Abstraction: The Employee class is implemented as an abstract base class to provide a template for all employee types and prevent direct instantiation.

Inheritance: RegularEmployee extends the Employee class to manage specific salary-related attributes.

Polymorphism (Overriding): The calculateGrossWeeklySalary() method is overridden in child classes to handle specific calculation logic through a unified interface.

Method Overloading: Implemented multiple constructors in RegularEmployee to allow flexible object creation depending on the available data.

Encapsulation: Sensitive fields like leave balances and salary rates are kept private, with access and modifications controlled via public Getters and Setters.

Leave Management Features
Composition: The Employee class maintains a List<Leave> to track an individual's leave history.

LeaveManager Engine: A logic-driven class that validates leave requests against specific balances (Sick, Vacation, and Emergency) to ensure requests are only approved if sufficient days remain.