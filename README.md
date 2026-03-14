<h1 align="center">MotorPH Payroll Bravo Version</h1>
<p align="center">
<strong>Description:</strong> Enterprise-grade update featuring full Architectural Decoupling, DAO Pattern Implementation, and Advanced Object-Oriented Refactoring.
</p>

<hr>

<h2>📝 Description</h2>
<ul>
<li>Welcome to the official release of <b>MotorPH NewGUI (Bravo Version)</b>.</li>
<li>This milestone marks a significant shift from simple file management to a professional <b>Data Access Object (DAO)</b> architecture.</li>
<li>By eliminating "data leaks" and separating business logic from file I/O, Version 1.6 ensures the system is production-ready, scalable, and prepared for future database integration.</li>
</ul>

<h2>🚀 Key Architectural Improvements</h2>
<ul>
<li><b>Introduction of CredentialsDAO:</b> Structural decoupling is now complete. The <code>EmployeeService</code> no longer manually parses <code>credentials.csv</code>. All authentication data is handled by the <b>CredentialsDAO</b>.</li>
<li><b>Rich Object Modeling:</b> Moved away from "Raw Strings" and <code>String[]</code> arrays. The system now passes <b>Employee</b> and <b>RegularEmployee</b> objects throughout the application, significantly reducing "Index Out of Bounds" errors.</li>
<li><b>Plugging "Data Leaks":</b> <code>EmployeeService</code> has been "cleaned"—it no longer contains references to <code>BufferedReader</code> or CSV delimiters, enforcing a clean <b>Separation of Concerns</b>.</li>
<li><b>Unified IT Ticketing Engine:</b> Complete end-to-end lifecycle management for IT support, featuring a 6-column CSV persistence format and role-specific filtering.</li>
<li><b>Benefits Model (Composition):</b> Encapsulates non-monetary allowances into a "Smart Object," centralizing calculation logic and eliminating "God Objects."</li>
</ul>

<h2>🛠 Technical Features (OOP Principles)</h2>

<ul>
<li><b>Encapsulation:</b> Data logic is strictly encapsulated within <b>DAO classes</b> and the <b>Benefits model</b>.</li>
<li><b>Abstraction (DAO Pattern):</b> By using the Data Access Object pattern, we have created a boundary. The GUI and Service layers are now abstracted away from the file system, making it possible to switch to a MySQL database without rewriting UI logic.</li>
<li><b>Inheritance:</b> <code>RegularEmployee</code> continues to extend the <code>Employee</code> base class, now utilizing the full power of object-passing.</li>
<li><b>Polymorphism:</b> Method overriding is used to handle specific authentication behaviors and calculation logic across different specialized dashboards.</li>
<li><b>Composition:</b> We implemented Composition within the <code>Employee</code> parent class, creating a clear, maintainable link between an employee and their assigned benefits.</li>
</ul>

<h2>📋 System Roles & Access</h2>
<p>The system utilizes a 5-role RBAC structure via <code>credentials.csv</code>. Use the following credentials to access the system:</p>

<table border="1" style="width:100%; border-collapse: collapse; text-align: left;">
<tr style="background-color: #f2f2f2;">
<th>Role</th>
<th>Username</th>
<th>Password</th>
<th>Primary Duties</th>
</tr>
<tr>
<td><b>ADMIN</b></td>
<td>admin</td>
<td>1234</td>
<td>Full CRUD, global report viewing, leave control, attendance tracking, and ticket submission to IT.</td>
</tr>
<tr>
<td><b>IT SPECIALIST</b></td>
<td>it_support</td>
<td>support123</td>
<td>Master ticket management and troubleshooting; coordinates directly with Admin.</td>
</tr>
<tr>
<td><b>HR</b></td>
<td>hr</td>
<td>hr123</td>
<td>Employee lifecycle management (Add/Edit/Delete/Update records).</td>
</tr>
<tr>
<td><b>FINANCE</b></td>
<td>finance</td>
<td>finance123</td>
<td>Payroll computation, deduction auditing, and payslip generation.</td>
</tr>
<tr>
<td><b>EMPLOYEE</b></td>
<td>[ID]</td>
<td>[Surname]</td>
<td>Profile management, leave filing, attendance clocking, and payslip access.</td>
</tr>
</table>

<h2>⚙️ Development Setup</h2>
<ul>
<li><b>Clone Branch:</b> <code>git clone -b MotorPH_Payroll-Bravo-Version https://github.com/siejeihyung/MotorPH_OOP-Group-28.git</code></li>
<li><b>CSV Integrity:</b> Ensure all data files are located in <code>src/data/</code>. DAOs are now configured to detect these paths automatically.</li>
<li><b>Build:</b> Perform a <b>"Clean and Build"</b> to ensure the new DAO architecture and object-based service logic are correctly compiled.</li>
</ul>

<hr>
<p align="center"><em>This project is maintained by Group 28. Version 1.6 focuses on clean architecture, professional data patterns, and the elimination of logic leaks.</em></p>
