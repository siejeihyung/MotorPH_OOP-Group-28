<h1 align="center">MotorPH Payroll & HR System — NewGUI Version 1.5</h1>
<p align="center">
<strong>Description:</strong> Enterprise-grade update featuring Full RBAC Implementation, Multi-Role Dashboards, a Production-Ready IT Ticketing Engine, and Employee-Side Ticket Integration.
</p>

<hr>

<h2>📝 Description</h2>
<ul>
<li>Welcome to the official release of <b>MotorPH NewGUI (Version 1.5)</b>.</li>
<li>This milestone completes the <b>IT Specialist</b> workflow, integrating real-time ticket management with a modernized, Finance-aligned user interface.</li>
<li>The system now features full <b>Two-Way Data Persistence</b> for tickets, moving from static viewing to active CSV state management.</li>
<li>Version 1.5 extends the ticketing system to the <b>Employee</b> and <b>Admin</b> dashboards, enabling end-to-end ticket lifecycle management across all roles.</li>
</ul>

<h2>🚀 What's New in Version 1.5</h2>
<ul>
<li><b>Unified IT Ticketing Engine:</b>
<ul>
<li><b>Employee-Side Integration:</b> Submit tickets directly via the dashboard with category selection (Hardware, Software, Network, etc.). Includes a private <b>Ticket History</b> view filtered by the sender's full name.</li>
<li><b>Admin & IT Coordination:</b> The IT Support login is now synchronized with the Admin role. IT Specialists and Admins can view the master ticket list and manage the status lifecycle (Open, In Progress, Resolved, Closed).</li>
<li><b>Two-Way Persistence:</b> Integrated <code>TicketDAO</code> with auto-save capabilities; updates write directly to <code>tickets.csv</code> with a robust 6-column format.</li>
</ul>
</li>
<li><b>UI/UX Polishing & Branding:</b>
<ul>
<li><b>Button Iconography:</b> All dashboard buttons, including the Ticket and Leave modules, have been updated with <b>high-resolution, polished icons</b> for a professional look.</li>
<li><b>Enterprise Alignment:</b> The IT Specialist environment has been fully redesigned to match the <b>"MotorPH Blue"</b> corporate theme (<code>#1D458F</code>).</li>
<li><b>Summary Analytics:</b> Added top-level summary cards providing instant counts of Total, Open, and Resolved tickets.</li>
</ul>
</li>
<li><b>Architectural Fixes:</b>
<ul>
<li><b>Ticket.java:</b> Added a secondary constructor to handle the <code>status</code> parameter, ensuring existing tickets load their current state correctly from the CSV.</li>
<li><b>Live Filtering:</b> Added a <b>Real-Time Filter</b> bar for IT/Admin staff to sort tickets instantly by Sender, ID, or Category.</li>
</ul>
</li>
<li><b>Expanded RBAC:</b> Intelligent routing now supports 5 roles: <b>ADMIN, HR, FINANCE, EMPLOYEE, and IT SPECIALIST</b> via <code>credentials.csv</code>.</li>
</ul>

<h2>🛠 Technical Features (OOP Principles)</h2>
<ul>
<li><b>Encapsulation:</b> Ticket data is managed through <code>TicketDAO.java</code>, ensuring <b>CSV</b> data is accessed only through secure, controlled methods with proper regex-based comma handling.</li>
<li><b>Abstraction:</b> The UI interaction layer is decoupled from file storage via the <b>DAO (Data Access Object) pattern</b>, simplifying future database migrations.</li>
<li><b>Inheritance:</b> Custom UI components and action buttons leverage centralized factories and base layout classes to maintain design consistency.</li>
<li><b>Polymorphism:</b> Table row sorters and regex filters dynamically adapt to user input for optimized data searching.</li>
<li><b>Composition:</b> The <code>ITSupportDashboard</code> integrates <code>DefaultTableModel</code> and <code>TableRowSorter</code> to handle complex data presentation.</li>
</ul>

<h2>📋 System Roles & Access</h2>
<table border="1" style="width:100%; border-collapse: collapse; text-align: left;">
<tr style="background-color: #f2f2f2;">
<th>Role</th>
<th>Primary Access</th>
</tr>
<tr>
<td><b>ADMIN</b></td>
<td>Full system CRUD, global report viewing, and IT Ticket Status control.</td>
</tr>
<tr>
<td><b>IT SPECIALIST</b></td>
<td><b>Master Ticketing Management</b>, Troubleshooting Logs, and Admin-coordinated system oversight.</td>
</tr>
<tr>
<td><b>HR</b></td>
<td>Employee lifecycle management and leave auditing.</td>
</tr>
<tr>
<td><b>FINANCE</b></td>
<td>Salary computation, deduction auditing, and payslip generation.</td>
</tr>
<tr>
<td><b>EMPLOYEE</b></td>
<td>Profile management, Leave Filing, Attendance Clocking, and Ticket Submission/History.</td>
</tr>
</table>

<h2>⚠️ Current Known Issues & Roadmap</h2>
<ul>
<li><b>Notification System:</b> Developing real-time alerts for IT Specialists when a high-priority ticket is filed.</li>
<li><b>Export Feature:</b> Planning CSV/PDF export for Ticket History to assist in monthly performance audits.</li>
<li><b>Attachments:</b> Investigating support for screenshot/file attachments within the ticketing module.</li>
</ul>

<h2>⚙️ Development Setup</h2>
<ul>
<li><b>Clone Branch:</b> <code>git clone -b NewGUI_Version_1.5 https://github.com/siejeihyung/MotorPH_OOP-Group-28.git</code></li>
<li><b>CSV Integrity:</b> Ensure <code>tickets.csv</code> and <code>credentials.csv</code> are in the <code>src/data/</code> or project root directory.</li>
<li><b>Build:</b> Perform a <b>"Clean and Build"</b> to ensure the new icon assets and persistence logic are correctly compiled.</li>
<li><b>Run:</b> Start the application via <code>LoginPanel.java</code>.</li>
</ul>

<hr>
<p align="center"><em>This project is maintained by Group 28. Version 1.5 focuses on end-to-end ticket lifecycle management and role synchronization.</em></p>
