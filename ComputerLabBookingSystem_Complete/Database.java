import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:computer_lab_booking.db";

    public static Connection connect() throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        try (Statement st = con.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return con;
    }

    public static void initialize() throws SQLException {
        try (Connection con = connect(); Statement st = con.createStatement()) {
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, username TEXT NOT NULL UNIQUE, " +
                "password TEXT NOT NULL, role TEXT NOT NULL)"
            );

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS computers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "computer_name TEXT NOT NULL UNIQUE, lab_name TEXT NOT NULL, " +
                "status TEXT NOT NULL DEFAULT 'AVAILABLE')"
            );

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS bookings (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "student_id INTEGER NOT NULL, computer_id INTEGER NOT NULL, " +
                "status TEXT NOT NULL DEFAULT 'PENDING', " +
                "FOREIGN KEY(student_id) REFERENCES users(id), " +
                "FOREIGN KEY(computer_id) REFERENCES computers(id))"
            );

            st.executeUpdate(
                "INSERT OR IGNORE INTO users(name, username, password, role) " +
                "VALUES('Administrator', 'admin', 'admin123', 'ADMIN')"
            );
        }
    }
}
