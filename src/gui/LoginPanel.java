package gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

// ── NEW: Import Service and DAO layers ────────────────────────────────────────
import service.EmployeeService;
import dao.EmployeeDAO;

/**
 * LoginPanel — Entry point for MotorPH.
 * Uses EmployeeService for authentication.
 * Routes to AdminDashboard or EmployeeDashboardPanel based on role (RBAC).
 */
public class LoginPanel extends JFrame {

    private final JTextField     usernameField;
    private final JPasswordField passwordField;
    private final JCheckBox      showPassword;
    private final JButton        loginButton;
    private final JLabel         feedbackLabel;

    private int   attempts = 0;
    private Timer lockoutTimer;

    private final Color     originalButtonColor = new Color(29, 69, 143);
    private final ImageIcon backgroundImage     =
            new ImageIcon(getClass().getResource("/assets/loginpanel_bg.png"));

    // ── NEW: Service handles authentication ───────────────────────────────────
    private final EmployeeService employeeService = new EmployeeService(new EmployeeDAO());

    public LoginPanel() {
        setTitle("MotorPH Payroll System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // Background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());
        setContentPane(backgroundPanel);

        // Login card
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(360, 360));
        card.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 2, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        // Title
        JLabel titleLabel = new JLabel("Sign In", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.DARK_GRAY);
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 20, 10, 20);
        card.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        // ── NEW: Role hint label ──────────────────────────────────────────────
        JLabel hintLabel = new JLabel(
            "<html><center><font color='gray' size='2'>" +
            "Admin: username + password &nbsp;|&nbsp; " +
            "Employee: ID + Last Name</font></center></html>",
            SwingConstants.CENTER);
        gbc.gridy++;
        gbc.insets = new Insets(0, 10, 8, 10);
        card.add(hintLabel, gbc);

        // Username
        gbc.gridy++;
        gbc.insets = new Insets(5, 20, 2, 20);
        JLabel userLabel = new JLabel("Username / Employee ID");
        userLabel.setForeground(Color.GRAY);
        card.add(userLabel, gbc);

        gbc.gridy++;
        usernameField = new JTextField();
        usernameField.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        usernameField.setOpaque(false);
        usernameField.setPreferredSize(new Dimension(200, 28));
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        card.add(usernameField, gbc);

        // Password
        gbc.gridy++;
        JLabel passLabel = new JLabel("Password / Last Name");
        passLabel.setForeground(Color.GRAY);
        card.add(passLabel, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField();
        passwordField.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        passwordField.setOpaque(false);
        passwordField.setPreferredSize(new Dimension(200, 28));
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        card.add(passwordField, gbc);

        // Enter key listener
        KeyAdapter enterKey = new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) checkLogin();
            }
        };
        usernameField.addKeyListener(enterKey);
        passwordField.addKeyListener(enterKey);

        // Show password checkbox
        gbc.gridy++;
        showPassword = new JCheckBox("Show Password");
        showPassword.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        showPassword.setForeground(Color.DARK_GRAY);
        showPassword.setOpaque(false);
        showPassword.setFocusPainted(false);
        showPassword.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        showPassword.addActionListener(e ->
            passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '•'));
        card.add(showPassword, gbc);

        // Login button
        gbc.gridy++;
        gbc.insets = new Insets(10, 20, 10, 20);
        loginButton = new JButton("Login") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(!isEnabled() ? Color.GRAY
                        : getModel().isRollover() ? new Color(30, 144, 255)
                        : originalButtonColor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.dispose();
                super.paintComponent(g);
            }
            @Override protected void paintBorder(Graphics g) {}
        };
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        loginButton.setContentAreaFilled(false);
        loginButton.setOpaque(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(e -> checkLogin());
        card.add(loginButton, gbc);

        // Feedback label
        gbc.gridy++;
        feedbackLabel = new JLabel(" ", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        feedbackLabel.setForeground(Color.RED);
        card.add(feedbackLabel, gbc);

        backgroundPanel.add(card);
        setVisible(true);
    }

    // ════════════════════════════════════════════════════════════════════════
    //  Login logic — now uses EmployeeService for auth + RBAC routing
    // ════════════════════════════════════════════════════════════════════════
    private void checkLogin() {
        String user = usernameField.getText().trim();
        String pass = new String(passwordField.getPassword()).trim();

        // ── NEW: authenticate returns role ("ADMIN", "EMPLOYEE", or null) ─────
        String role = employeeService.authenticate(user, pass);

        if (role != null) {
            // Successful login
            feedbackLabel.setForeground(new Color(34, 139, 34));
            feedbackLabel.setText("Login Successful!");

            Timer successTimer = new Timer(1000, e -> {
                dispose();
                SwingUtilities.invokeLater(() -> {
                    try {
                        System.out.println("Login OK — Role: " + role + " | User: " + user);

                        if (EmployeeService.ROLE_ADMIN.equals(role)) {
                            // ── ADMIN: full access dashboard ─────────────────
                            new AdminDashboard(user);

                        } else {
                            // ── EMPLOYEE: limited personal dashboard ──────────
                            new EmployeeDashboardPanel(user);
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(LoginPanel.class.getName())
                              .log(Level.SEVERE, "Dashboard Load Error", ex);
                        JOptionPane.showMessageDialog(null,
                            "Error opening dashboard: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
            });
            successTimer.setRepeats(false);
            successTimer.start();

        } else {
            // Failed login
            attempts++;
            feedbackLabel.setForeground(Color.RED);

            if (attempts >= 3) {
                feedbackLabel.setText("Too many attempts. Wait 1 minute.");
                loginButton.setEnabled(false);
                lockoutTimer = new Timer(60000, e -> {
                    loginButton.setEnabled(true);
                    feedbackLabel.setText(" ");
                    attempts = 0;
                    ((Timer) e.getSource()).stop();
                });
                lockoutTimer.setRepeats(false);
                lockoutTimer.start();
            } else {
                feedbackLabel.setText("<html><center>Incorrect credentials.<br>Attempt "
                        + attempts + " of 3.</center></html>");
                usernameField.setText("");
                passwordField.setText("");
                usernameField.requestFocus();
            }
        }
    }
}