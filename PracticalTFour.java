import java.sql.*;

class PracticalTwentyFour {
    public static void main(String[] args) {
        try {
            // Load JDBC Driver
           Class.forName("org.mariadb.jdbc.Driver");

           Connection con = DriverManager.getConnection(
           "jdbc:mariadb://localhost:3306/college",
           "javauser",
           "java123"
           );

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute SELECT Query
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM student_info"
            );

            // Display Records
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("roll_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Marks: " + rs.getDouble("marks"));
                System.out.println("------------------");
            }

            // Close Resources
            rs.close();
            stmt.close();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
