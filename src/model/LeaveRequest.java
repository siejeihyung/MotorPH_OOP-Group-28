/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
/**
 *
 * @author antongalfo
 */
public class LeaveRequest {
    
    private String employeeID;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;   
    private String status;      
    private String reason;
    
    public LeaveRequest(String employeeID, LocalDate startDate, LocalDate endDate,
                        String leaveType, String reason) {
        this.employeeID = employeeID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.reason = reason;
        this.status = "PENDING";
    
}
    
public String getEmployeeID() { return employeeID; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getLeaveType() { return leaveType; }
    public String getStatus() { return status; }
    public String getReason() { return reason; }

    public void setStatus(String status) { this.status = status; }
}
