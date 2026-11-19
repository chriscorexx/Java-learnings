import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends Frame {
    private final TextField computerName = new TextField(18);
    private final TextField labName = new TextField(18);
    private final TextArea computerList = new TextArea("", 12, 70, TextArea.SCROLLBARS_VERTICAL_ONLY);

    public Admin() {
        setTitle("Admin Dashboard - Computer Lab Booking System");
        setSize(720, 560);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        Label heading = new Label("Admin Dashboard", Label.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 23));
        add(heading, BorderLayout.NORTH);

        Panel computerForm = new Panel(new GridLayout(3, 2, 8, 8));
        computerForm.add(new Label("Computer Name:"));
        computerForm.add(computerName);
        computerForm.add(new Label("Lab Name:"));
        computerForm.add(labName);

        Button addComputer = new Button("Add Computer");
        Button refreshComputers = new Button("Refresh Computers");
        computerForm.add(addComputer);
        computerForm.add(refreshComputers);

        Button createStudent = new Button("Create Student Account");
        Button viewBookings = new Button("View / Manage Booking Requests");
        Panel actions = new Panel(new GridLayout(1, 2, 8, 8));
        actions.add(createStudent);
        actions.add(viewBookings);

        Panel top = new Panel(new BorderLayout(5, 8));
        top.add(computerForm, BorderLayout.CENTER);
        top.add(actions, BorderLayout.SOUTH);

        Panel listPanel = new Panel(new BorderLayout());
        listPanel.add(new Label("REGISTERED COMPUTERS"), BorderLayout.NORTH);
        listPanel.add(computerList, BorderLayout.CENTER);

        Panel center = new Panel(new BorderLayout(5, 8));
        center.add(top, BorderLayout.NORTH);
        center.add(listPanel, BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);

        Button logout = new Button("Logout");
        add(logout, BorderLayout.SOUTH);

        addComputer.addActionListener(e -> addComputer());
        refreshComputers.addActionListener(e -> loadComputers());
        createStudent.addActionListener(e -> openCreateStudent());
        viewBookings.addActionListener(e -> new BookingManager(this).setVisible(true));
        logout.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        loadComputers();
    }

    private void addComputer() {
        String computer = computerName.getText().trim();
        String lab = labName.getText().trim();

        if (computer.isEmpty() || lab.isEmpty()) {
            showMessage("Please enter both computer name and lab name.");
            return;
        }

        String sql = "INSERT INTO computers(computer_name, lab_name) VALUES(?, ?)";
        try (Connection con = Database.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, computer);
            ps.setString(2, lab);
            ps.executeUpdate();

            computerName.setText("");
            labName.setText("");
            showMessage("Computer added successfully.");
            loadComputers();
        } catch (SQLException e) {
            showMessage("Could not add computer. Check that its name is unique.");
        }
    }

    private void loadComputers() {
        computerList.setText("");
        computerList.append("ID | COMPUTER | LAB | STATUS\n");
        computerList.append("-----------------------------------------------\n");

        String sql = "SELECT id, computer_name, lab_name, status FROM computers ORDER BY id";
        try (Connection con = Database.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                computerList.append(
                    rs.getInt("id") + " | " +
                    rs.getString("computer_name") + " | " +
                    rs.getString("lab_name") + " | " +
                    rs.getString("status") + "\n"
                );
            }
        } catch (SQLException e) {
            computerList.append("Database error: " + e.getMessage());
        }
    }

    private void openCreateStudent() {
        Frame frame = new Frame("Create Student Account");
        frame.setSize(430, 280);
        frame.setLocationRelativeTo(this);
        frame.setLayout(new BorderLayout(8, 8));

        Label heading = new Label("Create Student Account", Label.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 19));
        frame.add(heading, BorderLayout.NORTH);

        TextField name = new TextField();
        TextField username = new TextField();
        TextField password = new TextField();
        password.setEchoChar('*');

        Panel form = new Panel(new GridLayout(4, 2, 8, 8));
        form.add(new Label("Student Name:"));
        form.add(name);
        form.add(new Label("Username:"));
        form.add(username);
        form.add(new Label("Password:"));
        form.add(password);

        Button save = new Button("Create Account");
        Label status = new Label("Enter student details.", Label.CENTER);
        form.add(save);
        form.add(status);
        frame.add(form, BorderLayout.CENTER);

        save.addActionListener(e -> {
            if (name.getText().trim().isEmpty() ||
                username.getText().trim().isEmpty() ||
                password.getText().isEmpty()) {
                status.setText("Fill in all fields.");
                return;
            }

            String sql = "INSERT INTO users(name, username, password, role) VALUES(?, ?, ?, 'STUDENT')";
            try (Connection con = Database.connect();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name.getText().trim());
                ps.setString(2, username.getText().trim());
                ps.setString(3, password.getText());
                ps.executeUpdate();
                status.setText("Student account created.");
                name.setText("");
                username.setText("");
                password.setText("");
            } catch (SQLException ex) {
                status.setText("Username may already exist.");
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }

    public void refreshComputerList() {
        loadComputers();
    }

    private void showMessage(String text) {
        computerList.setText(text + "\n\n");
        loadComputers();
    }
}
