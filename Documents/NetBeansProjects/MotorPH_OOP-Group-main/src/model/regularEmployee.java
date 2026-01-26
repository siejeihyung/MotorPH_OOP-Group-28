/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class regularEmployee extends Employee {
    public regularEmployee (String employeeID, String name, double basicSalary, double semiMonthlyRate, double hourlyRate, double totalBenefits)
    {
        super(employeeID, name, basicSalary, semiMonthlyRate, hourlyRate, totalBenefits);
    }
    
    @Override
    public double getcalculateGrossWeeklySalary()
    {
        // Changed totalBenefits() to getTotalBenefits()
        return getBasicSalary() + getTotalBenefits();
    }
}
