package model;

public class PayrollLogic {

    // Instance of Deductions class to handle all deduction-related computations
    private Deductions deductions;

    // Constructor initializes the Deductions object
    public PayrollLogic() {
        this.deductions = new Deductions();
    }
    
    /**
     * CORE OOP IMPLEMENTATION: processNetPay
     * This uses Abstraction by accepting the parent class 'Employee'.It uses Polymorphism by calling 'calculateGrossPay()'.
     * @param emp
     * @return 
     */
    public double processNetPay(Employee emp) {
        // Polymorphism: The program decides at runtime whether to use 
        // RegularEmployee's or a different subclass's version of the calculation.
        double gross = emp.calculateGrossPay(); 
        
        // Use the common getBasicSalary() from the abstract Employee class.
        double taxDeductions = deductions.getTotalDeductions(emp.getBasicSalary(), gross);
        
        // Returns the final net pay (weekly calculation).
        return gross - (taxDeductions / 4);
    }
    
    // Calculates gross weekly salary based on hourly rate, hours worked, and benefits
    public double calculateGrossWeeklySalary(double hourlyRate, double hoursWorked, double rice, double phone, double clothing) {
        double basicSalary = hourlyRate * hoursWorked; // Basic salary from hours worked
        double totalBenefits = rice + phone + clothing; // Sum of all allowances
        return basicSalary + totalBenefits; // Gross salary = base salary + benefits
    }

    // Calculates net weekly salary after deducting a quarter of monthly deductions
    public double calculateNetWeeklySalary(double basicSalary, double grossWeeklySalary) {
        // Get total monthly deductions based on basic and gross salary
        double totalMonthlyDeductions = deductions.getTotalDeductions(basicSalary, grossWeeklySalary);

        // Approximate weekly deductions (1/4 of monthly)
        double weeklyDeductions = totalMonthlyDeductions / 4;

        // Net salary = gross - weekly deductions
        return grossWeeklySalary - weeklyDeductions;
    }
     /**
     * REFACTORED BREAKDOWN: Now uses the Employee object instead of 6 manual parameters.
     * @param emp
     */
    public void displaySalaryBreakdown(Employee emp) {
        // Calculate gross and net using the new polymorphic methods
        double grossWeekly = emp.calculateGrossPay();
        double netWeekly = processNetPay(emp);
        
        // Calculate individual monthly deductions
        double basicSalary = emp.getBasicSalary();
        double monthlySSS = deductions.calculateSSS(basicSalary);
        double monthlyPH = deductions.calculatePhilHealth(basicSalary);
        double monthlyPI = deductions.calculatePagIbig(basicSalary);
        double monthlyTax = deductions.getMonthlyWithholdingTax(basicSalary);

        // Print salary breakdown with formatted values
        System.out.println("EMPLOYEE: " + emp.getFullName());
        System.out.println("GROSS WEEKLY SALARY: ₱" + String.format("%.2f", grossWeekly));
        System.out.println("SSS DEDUCTION (monthly): ₱" + monthlySSS);
        System.out.println("PhilHealth DEDUCTION (monthly): ₱" + monthlyPH);
        System.out.println("Pag-IBIG DEDUCTION (monthly): ₱" + monthlyPI);
        System.out.println("Withholding TAX (monthly): ₱" + String.format("%.2f", monthlyTax));
        System.out.println("TOTAL DEDUCTIONS (weekly): ₱" + String.format("%.2f", (monthlySSS + monthlyPH + monthlyPI + monthlyTax) / 4));
        System.out.println("NET WEEKLY SALARY: ₱" + String.format("%.2f", netWeekly));
    }
  
    // Calculates deduction amount for late minutes based on hourly rate
    public double calculateLateDeduction(double hourlyRate, int lateMinutes) {
        double perMinuteRate = hourlyRate / 60; // Convert hourly rate to per-minute rate
        return perMinuteRate * lateMinutes; // Multiply by number of late minutes
    }
}
