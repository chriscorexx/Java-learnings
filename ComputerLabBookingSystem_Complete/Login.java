import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends Frame {
    private final TextField usernameField = new TextField(20);
    private final TextField passwordField = new TextField(20);
    private final Label message = new Label("Enter your login details.", Label.CENTER);

    public Login() {
        setTitle("Computer Lab Booking System - Login");
        setSize(430, 260);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        Label heading = new Label("Computer Lab Booking System", Label.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading, BorderLayout.NORTH);

        Panel form = new Panel(new GridLayout(3, 2, 10, 12));
        form.add(new Label("Username:"));
        form.add(usernameField);
        form.add(new Label("Password:"));
        passwordField.setEchoChar('*');
        form.add(passwordField);

        Button loginButton = new Button("Login");
        Button clearButton = new Button("Clear");
        form.add(loginButton);
        form.add(clearButton);
        add(form, BorderLayout.CENTER);
        add(message, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> authenticate());
        passwordField.addActionListener(e -> authenticate());
        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
            message.setText("Enter your login details.");
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    private void authenticate() {
        String sql = "SELECT id, name, role FROM users WHERE username = ? AND password = ?";
        try (Connection con = Database.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usernameField.getText().trim());
            ps.setString(2, passwordField.getText());

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    message.setText("Invalid username or password.");
                    return;
                }

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role = rs.getString("role");

                dispose();
                if ("ADMIN".equalsIgnoreCase(role)) {
                    new Admin().setVisible(true);
                } else if ("STUDENT".equalsIgnoreCase(role)) {
                    new Student(id, name).setVisible(true);
                } else {
                    new Login().setVisible(true);
                }
            }
        } catch (SQLException e) {
            message.setText("Login error: " + e.getMessage());
        }
    }
}
