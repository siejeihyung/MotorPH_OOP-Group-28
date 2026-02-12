/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * MotorPH Regular Employee Subclass
 */
public class RegularEmployee extends Employee {
    

    public RegularEmployee(String employeeID, String lastName, String firstName,
                       String sss, String philhealth, String tin, String pagibig,
                       double basicSalary, double semiMonthlyRate, double hourlyRate, double totalBenefits) {
    super(employeeID, lastName, firstName, sss, philhealth, tin, pagibig,
          basicSalary, semiMonthlyRate, hourlyRate, totalBenefits);
}
    // Override for weekly gross salary
    @Override
    public double calculateGrossWeeklySalary() {
        return getBasicSalary() + getTotalBenefits();
    }
    // Polymorphic behavior
    @Override
       public double computeGrossPay() {
        return getBasicSalary() + getTotalBenefits();
    }
}

