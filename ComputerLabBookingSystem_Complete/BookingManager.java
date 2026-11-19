import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookingManager extends Frame {
    private final TextArea bookingList = new TextArea("", 16, 80, TextArea.SCROLLBARS_VERTICAL_ONLY);
    private final TextField bookingIdField = new TextField(8);
    private final Admin parent;

    public BookingManager(Admin parent) {
        this.parent = parent;
        setTitle("Manage Booking Requests");
        setSize(760, 470);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(8, 8));

        Label heading = new Label("Booking Requests", Label.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 21));
        add(heading, BorderLayout.NORTH);

        add(bookingList, BorderLayout.CENTER);

        Panel controls = new Panel(new FlowLayout());
        controls.add(new Label("Booking ID:"));
        controls.add(bookingIdField);

        Button approve = new Button("Approve");
        Button reject = new Button("Reject");
        Button refresh = new Button("Refresh");
        controls.add(approve);
        controls.add(reject);
        controls.add(refresh);
        add(controls, BorderLayout.SOUTH);

        approve.addActionListener(e -> updateBooking("APPROVED"));
        reject.addActionListener(e -> updateBooking("REJECTED"));
        refresh.addActionListener(e -> loadBookings());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        loadBookings();
    }

    private void loadBookings() {
        bookingList.setText("ID | STUDENT | COMPUTER | LAB | STATUS\n");
        bookingList.append("---------------------------------------------------------------\n");

        String sql = "SELECT b.id, u.name, c.computer_name, c.lab_name, b.status " +
                     "FROM bookings b JOIN users u ON b.student_id = u.id " +
                     "JOIN computers c ON b.computer_id = c.id ORDER BY b.id DESC";

        try (Connection con = Database.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                bookingList.append(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("computer_name") + " | " +
                    rs.getString("lab_name") + " | " +
                    rs.getString("status") + "\n"
                );
            }
        } catch (SQLException e) {
            bookingList.append("Database error: " + e.getMessage());
        }
    }

    private void updateBooking(String newStatus) {
        int bookingId;
        try {
            bookingId = Integer.parseInt(bookingIdField.getText().trim());
        } catch (NumberFormatException e) {
            bookingList.append("\nEnter a valid Booking ID.\n");
            return;
        }

        String findSql = "SELECT computer_id FROM bookings WHERE id = ? AND status = 'PENDING'";
        String updateSql = "UPDATE bookings SET status = ? WHERE id = ? AND status = 'PENDING'";
        String releaseSql = "UPDATE computers SET status = 'AVAILABLE' WHERE id = ?";

        try (Connection con = Database.connect()) {
            con.setAutoCommit(false);
            try {
                int computerId;
                try (PreparedStatement find = con.prepareStatement(findSql)) {
                    find.setInt(1, bookingId);
                    try (ResultSet rs = find.executeQuery()) {
                        if (!rs.next()) {
                            con.rollback();
                            bookingList.append("\nBooking ID not found or is not pending.\n");
                            return;
                        }
                        computerId = rs.getInt("computer_id");
                    }
                }

                try (PreparedStatement update = con.prepareStatement(updateSql)) {
                    update.setString(1, newStatus);
                    update.setInt(2, bookingId);
                    update.executeUpdate();
                }

                if ("REJECTED".equals(newStatus)) {
                    try (PreparedStatement release = con.prepareStatement(releaseSql)) {
                        release.setInt(1, computerId);
                        release.executeUpdate();
                    }
                }

                con.commit();
                bookingIdField.setText("");
                loadBookings();
                parent.refreshComputerList();
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            bookingList.append("\nCould not update booking: " + e.getMessage() + "\n");
        }
    }
}
