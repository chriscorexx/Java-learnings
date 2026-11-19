import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Student extends Frame {
    private final int studentId;
    private final String studentName;
    private final Choice computerChoice = new Choice();
    private final TextArea bookingList = new TextArea("", 14, 75, TextArea.SCROLLBARS_VERTICAL_ONLY);
    private final Label message = new Label("Select an available computer.", Label.CENTER);

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;

        setTitle("Student - Computer Lab Booking System");
        setSize(700, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        Label heading = new Label("Welcome, " + studentName, Label.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        add(heading, BorderLayout.NORTH);

        Panel selectPanel = new Panel(new GridLayout(3, 1, 5, 5));
        selectPanel.add(new Label("Available Computers:"));
        selectPanel.add(computerChoice);

        Panel buttons = new Panel(new FlowLayout());
        Button request = new Button("Request Booking");
        Button refresh = new Button("Refresh");
        buttons.add(request);
        buttons.add(refresh);
        selectPanel.add(buttons);

        Panel center = new Panel(new BorderLayout(5, 8));
        center.add(selectPanel, BorderLayout.NORTH);

        Panel history = new Panel(new BorderLayout());
        history.add(new Label("MY BOOKING REQUESTS"), BorderLayout.NORTH);
        history.add(bookingList, BorderLayout.CENTER);
        center.add(history, BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);

        Panel bottom = new Panel(new GridLayout(2, 1));
        bottom.add(message);
        Button logout = new Button("Logout");
        bottom.add(logout);
        add(bottom, BorderLayout.SOUTH);

        request.addActionListener(e -> requestBooking());
        refresh.addActionListener(e -> refreshData());
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

        refreshData();
    }

    private void refreshData() {
        loadComputers();
        loadBookings();
    }

    private void loadComputers() {
        computerChoice.removeAll();
        String sql = "SELECT id, computer_name, lab_name FROM computers " +
                     "WHERE status = 'AVAILABLE' ORDER BY id";

        try (Connection con = Database.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                computerChoice.add(rs.getInt("id") + " | " +
                    rs.getString("computer_name") + " | " + rs.getString("lab_name"));
            }
            if (computerChoice.getItemCount() == 0) {
                computerChoice.add("No computers available");
            }
        } catch (SQLException e) {
            message.setText("Could not load computers: " + e.getMessage());
        }
    }

    private void requestBooking() {
        String selected = computerChoice.getSelectedItem();
        if (selected == null || selected.equals("No computers available")) {
            message.setText("No computers are available right now.");
            return;
        }

        int computerId;
        try {
            computerId = Integer.parseInt(selected.split("\\|")[0].trim());
        } catch (NumberFormatException e) {
            message.setText("Please select a valid computer.");
            return;
        }

        String updateSql = "UPDATE computers SET status = 'BOOKED' " +
                           "WHERE id = ? AND status = 'AVAILABLE'";
        String insertSql = "INSERT INTO bookings(student_id, computer_id, status) " +
                           "VALUES(?, ?, 'PENDING')";

        try (Connection con = Database.connect()) {
            con.setAutoCommit(false);
            try {
                int updated;
                try (PreparedStatement update = con.prepareStatement(updateSql)) {
                    update.setInt(1, computerId);
                    updated = update.executeUpdate();
                }

                if (updated == 0) {
                    con.rollback();
                    message.setText("This computer is no longer available. Refresh the list.");
                    refreshData();
                    return;
                }

                try (PreparedStatement insert = con.prepareStatement(insertSql)) {
                    insert.setInt(1, studentId);
                    insert.setInt(2, computerId);
                    insert.executeUpdate();
                }

                con.commit();
                message.setText("Booking request submitted. Status: PENDING");
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            message.setText("Booking error: " + e.getMessage());
        }

        refreshData();
    }

    private void loadBookings() {
        bookingList.setText("Booking ID | Computer | Lab | Status\n");
        bookingList.append("------------------------------------------------\n");

        String sql = "SELECT b.id, c.computer_name, c.lab_name, b.status " +
                     "FROM bookings b JOIN computers c ON b.computer_id = c.id " +
                     "WHERE b.student_id = ? ORDER BY b.id DESC";

        try (Connection con = Database.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    bookingList.append(
                        rs.getInt("id") + " | " +
                        rs.getString("computer_name") + " | " +
                        rs.getString("lab_name") + " | " +
                        rs.getString("status") + "\n"
                    );
                }
            }
        } catch (SQLException e) {
            bookingList.append("Database error: " + e.getMessage());
        }
    }
}
