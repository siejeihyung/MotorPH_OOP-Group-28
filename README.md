Gemini said
<h1 align="center">MotorPH Payroll & HR System — NewGUI Version 1.4</h1>
<p align="center">
<strong>Description:</strong> Enterprise-grade update featuring Full RBAC Implementation, Multi-Role Dashboards, and Employee Leave Management.
</p>

<hr>

<h2>📝 Description</h2>
<ul>
<li>Welcome to the official release of <b>MotorPH NewGUI (Version 1.4)</b>.</li>
<li>This milestone marks the transition to a sophisticated <b>Role-Based Access Control (RBAC)</b> system and introduces a comprehensive <b>Employee Self-Service</b> module for leave management.</li>
<li>The system has been refactored to prioritize data integrity by moving all legacy <code>.txt</code> storage to standardized <b>CSV</b> formats.</li>
</ul>

<h2>🚀 What's New in Version 1.4</h2>
<ul>
<li><b>Employee Leave Management:</b> Regular employees now have a dedicated module to:
<ul>
<li><b>File Leave Requests:</b> Submit requests for vacation, sick, or emergency leave directly through the dashboard.</li>
<li><b>Leave History:</b> Access a transparent, real-time log of all previous leave applications and their current status.</li>
</ul>
</li>
<li><b>Full RBAC Implementation:</b> Refactored <code>credentials.csv</code> with a new <b>Role</b> column for intelligent system routing.
<ul>
<li><i>New Format:</i> <code>admin,1234,ADMIN</code> | <code>hr,hr123,HR</code> | <code>finance,finance123,FINANCE</code>.</li>
</ul>
</li>
<li><b>New Specialized Dashboards:</b>
<ul>
<li><b>HRDashboard:</b> Dedicated interface for HR to add, update, delete, and view all employees.</li>
<li><b>FinanceDashboard:</b> Optimized for Finance to compute salaries and print payslips.</li>
<li><b>LoginPanel Update:</b> Routes users to 4 specialized roles: <b>ADMIN, HR, FINANCE, and EMPLOYEE</b>.</li>
</ul>
</li>
<li><b>Salary Report Cleanup:</b> Streamlined <code>ViewEmployeePanel</code> by removing legacy metrics (Monthly Total Hours, Late Minutes, and Late Deductions) to focus on net pay accuracy.</li>
<li><b>Logic Optimization:</b>
<ul>
<li>Removed redundant <code>latePenalty</code> and <code>overtime</code> tracking for a cleaner financial model.</li>
<li>Renamed <code>calculateWorkAndLateOffset()</code> to <b><code>calculateWorkedMinutes()</code></b> for better architectural clarity.</li>
</ul>
</li>
</ul>

<h2>🛠 Technical Features (OOP Principles)</h2>
<p>The system leverages core Java OOP principles to manage complex data flow and role segregation:</p>

<ul>
<li><b>Encapsulation:</b> File I/O is centralized in <code>FileHandler.java</code>, ensuring <b>CSV</b> data for employees and leave requests is handled securely via private list structures and controlled getters.</li>
<li><b>Abstraction:</b> The <code>Employee</code> abstract class and <code>IPayable</code> interface provide a blueprint for all employee types, hiding internal calculation complexities from the UI.</li>
<li><b>Inheritance:</b> <code>RegularEmployee</code> reuses the identity and salary fields of the <code>Employee</code> base class, extending functionality for personal dashboard access.</li>
<li><b>Polymorphism:</b> Method overriding ensures that calculation and navigation logic behave correctly based on the specific role logged in.</li>
<li><b>Composition:</b> The <code>Employee</code> class implements a "Has-A" relationship by containing a <code>Benefits</code> object for modular allowance management.</li>
</ul>

<h2>📋 System Roles & Access</h2>
<table border="1" style="width:100%; border-collapse: collapse; text-align: left;">
<tr style="background-color: #f2f2f2;">
<th>Role</th>
<th>Primary Access</th>
</tr>
<tr>
<td><b>ADMIN</b></td>
<td>Full system CRUD, role management, and global report viewing.</td>
</tr>
<tr>
<td><b>HR</b></td>
<td>Employee lifecycle management and leave request auditing.</td>
</tr>
<tr>
<td><b>FINANCE</b></td>
<td>Salary computation, deduction auditing, and payslip generation.</td>
</tr>
<tr>
<td><b>EMPLOYEE</b></td>
<td>Profile viewing, <b>Leave Filing</b>, and self-service <b>Leave History</b>.</td>
</tr>
</table>

<h2>⚙️ Development Setup</h2>
<ul>
<li><b>Clone Branch:</b> <code>git clone -b NewGUI-Version1.4 https://github.com/siejeihyung/MotorPH_OOP-Group-28.git</code></li>
<li><b>CSV Integrity:</b> Ensure all files in the <code>data/</code> folder (employee, attendance, and credentials) use the <code>.csv</code> extension.</li>
<li><b>Clean and Build:</b> Always perform a clean build to compile the updated <code>LoginPanel</code> routing and Leave Management modules.</li>
</ul>

<hr>
<p align="center"><em>This project is maintained by SunnyEljohn and Group 28. Version 1.4 focuses on professional role segregation and employee self-service features.</em></p>
