/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.EmployeeDAO;
import java.io.*;
import java.util.*;

/**
 * EmployeeService — Business logic for employee management.
 *
 * Handles:
 *  - Login authentication (Admin + Employee CSV)
 *  - CRUD operations
 *  - Role detection (admin vs employee)
 */
public class EmployeeService {

    private final EmployeeDAO employeeDAO;
    private final String credentialsFilePath = "data/credentials.txt";

    // Roles for RBAC
    public static final String ROLE_ADMIN    = "ADMIN";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
        this.employeeDAO.load();
    }

    // ── Authentication ───────────────────────────────────────────────────────

    /**
     * Returns the role of the authenticated user, or null if login fails.
     * ADMIN   → username/password match credentials.txt
     * EMPLOYEE → username = Employee ID, password = Last Name
     */
    public String authenticate(String username, String password) {
        // Check admin credentials first
        if (isAdmin(username, password)) return ROLE_ADMIN;

        // Check employee login (ID + Last Name)
        for (String[] emp : employeeDAO.findAll()) {
            if (emp.length > 1
                    && emp[0].trim().equals(username)
                    && emp[1].trim().equalsIgnoreCase(password)) {
                return ROLE_EMPLOYEE;
            }
        }
        return null; // Login failed
    }

    private boolean isAdmin(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(credentialsFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(",");
                if (parts.length == 2
                        && parts[0].trim().equals(username)
                        && parts[1].trim().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading credentials: " + e.getMessage());
        }
        return false;
    }

    // ── CRUD ─────────────────────────────────────────────────────────────────
    public List<String[]> getAllEmployees() { return employeeDAO.findAll(); }

    public String[] getEmployeeById(String id) { return employeeDAO.findById(id); }

    public boolean addEmployee(String[] row) { return employeeDAO.append(row); }

    public boolean updateField(String id, String column, String value) {
        return employeeDAO.updateField(id, column, value);
    }

    public boolean deleteEmployee(String id) { return employeeDAO.deleteById(id); }

    // ── Get employee name by ID ───────────────────────────────────────────────
    public String getEmployeeName(String employeeId) {
        String[] emp = employeeDAO.findById(employeeId);
        if (emp != null && emp.length > 2) {
            return emp[2] + " " + emp[1]; // First + Last name
        }
        return employeeId;
    }
}
