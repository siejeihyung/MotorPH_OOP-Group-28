<h1 align="center">MotorPH Payroll & HR System — NewGUI Version 1.4.3</h1>
<p align="center">
<strong>Description:</strong> Enterprise-grade update featuring Full RBAC Implementation, Multi-Role Dashboards, and specialized IT Ticketing support.
</p>

<hr>

<h2>📝 Description</h2>
<ul>
<li>Welcome to the official release of <b>MotorPH NewGUI (Version 1.4.2)</b>.</li>
<li>This milestone introduces the <b>IT Specialist</b> role, specifically dedicated to system maintenance and the management of our new <b>Internal Ticketing System</b>.</li>
<li>The system has been refactored to prioritize data integrity by moving all legacy <code>.txt</code> storage to standardized <b>CSV</b> formats.</li>
</ul>

<h2>🚀 What's New in Version 1.4.3</h2>
<ul>
<li><b>IT Support & Ticketing Module:</b>
<ul>
<li><b>Ticketing System:</b> All employees can now file support tickets (bugs, login issues, etc.) directly through their dashboard.</li>
<li><b>IT Specialist Dashboard:</b> A dedicated environment for IT staff to monitor, categorize, and resolve incoming tickets with a full <b>Ticket History</b> log.</li>
</ul>
</li>
<li><b>Expanded RBAC:</b> Intelligent routing now supports 5 roles: <b>ADMIN, HR, FINANCE, EMPLOYEE, and IT SPECIALIST</b> via <code>credentials.csv</code>.</li>
<li><b>Salary Report Cleanup:</b> Streamlined <code>ViewEmployeePanel</code> by removing legacy metrics (Monthly Total Hours, Late Minutes, and Late Deductions) to focus on net pay accuracy.</li>
<li><b>Logic Optimization:</b> Renamed <code>calculateWorkAndLateOffset()</code> to <b><code>calculateWorkedMinutes()</code></b> for better architectural clarity.</li>
</ul>

<h2>🛠 Technical Features (OOP Principles)</h2>
<ul>
<li><b>Encapsulation:</b> Ticket and leave data are centralized in <code>FileHandler.java</code>, ensuring <b>CSV</b> data is accessed only through secure, controlled methods.</li>
<li><b>Abstraction:</b> The UI interaction layer is decoupled from file storage, allowing for seamless updates to data formats.</li>
<li><b>Inheritance:</b> Custom UI components for the IT Support dashboard extend base layout classes to ensure UI consistency.</li>
<li><b>Polymorphism:</b> Overridden navigation logic ensures that the dashboard interface dynamically adapts to the specific permissions of the logged-in user.</li>
<li><b>Composition:</b> The <code>Employee</code> class uses <code>Benefits</code> and <code>Ticket</code> objects to maintain modularity.</li>
</ul>

<h2>📋 System Roles & Access</h2>
<table border="1" style="width:100%; border-collapse: collapse; text-align: left;">
<tr style="background-color: #f2f2f2;">
<th>Role</th>
<th>Primary Access</th>
</tr>
<tr>
<td><b>ADMIN</b></td>
<td>Full system CRUD, role/ticket management, and global report viewing.</td>
</tr>
<tr>
<td><b>HR</b></td>
<td>Employee lifecycle management and leave auditing.</td>
</tr>
<tr>
<td><b>FINANCE</b></td>
<td>Salary computation and payslip generation.</td>
</tr>
<tr>
<td><b>IT SPECIALIST</b></td>
<td><b>Ticketing System Management</b>, and audit logs.</td>
</tr>
<tr>
<td><b>EMPLOYEE</b></td>
<td>Profile, Leave Filing, and IT Support Ticket history.</td>
</tr>
</table>

<h2>⚠️ Current Known Issues & Roadmap</h2>
<ul>
<li><b>Dashboard Polishing:</b> The IT Support dashboard requires further visual refinement to ensure it meets the "MotorPH Blue" corporate theme.</li>
<li><b>Ticket Format Audit:</b> The current ticket format is undergoing a total redesign to ensure consistency across the ADMIN, HR, FINANCE, and IT roles.</li>
<li><b>Standardization:</b> Ongoing efforts to unify the "Ticket History" and "Leave History" visual formats to ensure a seamless experience for all users.</li>
</ul>

<h2>⚙️ Development Setup</h2>
<ul>
<li><b>Clone Branch:</b> <code>git clone -b NewGUI-Version1.4.2 https://github.com/siejeihyung/MotorPH_OOP-Group-28.git</code></li>
<li><b>CSV Integrity:</b> Ensure all data files in the <code>data/</code> directory (specifically <code>tickets.csv</code> and <code>leave_history.csv</code>) utilize <code>.csv</code> extensions.</li>
<li><b>Build:</b> Perform a <b>"Clean and Build"</b> to ensure new IT Specialist routing and ticket management logic are correctly integrated.</li>
</ul>

<hr>
<p align="center"><em>This project is maintained by SunnyEljohn and Group 28. Version 1.4.2 focuses on professional role segregation and system-wide support.</em></p>
