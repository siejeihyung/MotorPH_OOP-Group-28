package model;

// This class represents an Employee with relevant salary details
public abstract class Employee implements grossPayable {

    // Employee ID (e.g., unique identifier for each employee)
    private String employeeID;

    // Full name of the employee
    private String name;

    // Basic monthly salary of the employee
    private double basicSalary;
 

    // Semi-monthly salary rate (used if paid twice a month)
    private double semiMonthlyRate;

    // Hourly rate used for computing pay based on hours worked
    private double hourlyRate;
    private double totalBenefits;
    
    

    // Constructor to initialize all attributes of the Employee object
    public Employee(String employeeID, String name, double basicSalary, double semiMonthlyRate, double hourlyRate, double totalBenefits) {
        this.employeeID = employeeID;
        this.name = name;
        this.basicSalary = basicSalary;
        this.semiMonthlyRate = semiMonthlyRate;
        this.hourlyRate = hourlyRate;
        this.totalBenefits = totalBenefits;
    }

    // Getter method to retrieve employee ID
    public String getEmployeeID() {
        return employeeID;
    }

    // Getter method to retrieve employee name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the basic salary
    public double getBasicSalary() {
        return basicSalary;
    }

    // Getter method to retrieve the semi-monthly rate
    public double getSemiMonthlyRate() {
        return semiMonthlyRate;
    }

    // Getter method to retrieve the hourly rate
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
    /**
     * @return the totalBenefits
     */
    public double getTotalBenefits() {
        return totalBenefits;
    }
    

    
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * @param semiMonthlyRate the semiMonthlyRate to set
     */
    public void setSemiMonthlyRate(double semiMonthlyRate) {
        this.semiMonthlyRate = semiMonthlyRate;
    }

    /**
     * @param hourlyRate the hourlyRate to set
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * @param totalBenefits the totalBenefits to set
     */
    public void setTotalBenefits(double totalBenefits) {
        this.totalBenefits = totalBenefits;
    }

    @Override
    public abstract double getcalculateGrossWeeklySalary();
    
}

