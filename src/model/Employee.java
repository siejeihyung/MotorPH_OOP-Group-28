// This is the SINGLE Parent Class for all types of Employees

/**
 *
 * @author CJPontanilla
 */
// Inside Employee.java
package model;

import java.time.LocalDate;

public abstract class Employee {

    // Identity fields (private for encapsulation, access via getters)
    private String employeeID;
    private String lastName;
    private String firstName;
    private String sss;
    private String philhealth;
    private String tin;
    private String pagibig;
    // Salary fields
    private double basicSalary;
    private double semiMonthlyRate;
    private double hourlyRate;
    private double totalBenefits;

    public Employee(String employeeID, String lastName, String firstName,
                    String sss, String philhealth, String tin, String pagibig,
                    double basicSalary, double semiMonthlyRate, double hourlyRate, double totalBenefits) {

        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sss = sss;
        this.philhealth = philhealth;
        this.tin = tin;
        this.pagibig = pagibig;
        this.basicSalary = basicSalary;
        this.semiMonthlyRate = semiMonthlyRate;
        this.hourlyRate = hourlyRate;
        this.totalBenefits = totalBenefits;
        
    }

    // Basic getters
    public String getEmployeeID() { return employeeID; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getFullName() { return firstName + " " + lastName; }

    public String getSss() { return sss; }
    public String getPhilhealth() { return philhealth; }
    public String getTin() { return tin; }
    public String getPagibig() { return pagibig; }

    public double getBasicSalary() { return basicSalary; }
    public double getSemiMonthlyRate() { return semiMonthlyRate; }
    public double getHourlyRate() { return hourlyRate; }
    public double getTotalBenefits() { return totalBenefits; }
    
    public LeaveRequest requestLeave(LocalDate startDate, LocalDate endDate, String leaveType, String reason) {
    // any employee can create a leave request
    return new LeaveRequest(getEmployeeID(), startDate, endDate, leaveType, reason);
}

    // Abstraction: subclasses must provide formulas
    public abstract double calculateGrossWeeklySalary();
    public abstract double computeGrossPay();
}
