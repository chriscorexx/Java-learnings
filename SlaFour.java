

import java.sql.*;
import java.util.Scanner;

class SlaFour {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/employee_db",
                "javauser",
                "java123"
            );

            int choice;

            while (true) {
                System.out.println("\n================================");
                System.out.println("    EMPLOYEE MANAGEMENT SYSTEM");
                System.out.println("================================");
                System.out.println("1. Insert Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. Search Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                if (choice == 1) {

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, dept);
                    ps.setString(4, designation);
                    ps.setDouble(5, salary);
                    ps.setString(6, phone);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Employee inserted successfully!");
                    }

                    ps.close();

                } else if (choice == 2) {

                    System.out.print("Enter Employee ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter New Designation: ");
                    String designation = sc.nextLine();

                    System.out.print("Enter New Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter New Phone Number: ");
                    String phone = sc.nextLine();

                    String sql = "UPDATE employee SET emp_name=?, department=?, designation=?, salary=?, phone=? WHERE emp_id=?";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, name);
                    ps.setString(2, dept);
                    ps.setString(3, designation);
                    ps.setDouble(4, salary);
                    ps.setString(5, phone);
                    ps.setInt(6, id);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Employee updated successfully!");
                    } else {
                        System.out.println("Employee not found!");
                    }

                    ps.close();

                } else if (choice == 3) {

                    System.out.print("Enter Employee ID to delete: ");
                    int id = sc.nextInt();

                    String sql = "DELETE FROM employee WHERE emp_id=?";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, id);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Employee deleted successfully!");
                    } else {
                        System.out.println("Employee not found!");
                    }

                    ps.close();

                } else if (choice == 4) {

                    System.out.print("Enter Employee ID to search: ");
                    int id = sc.nextInt();

                    String sql = "SELECT * FROM employee WHERE emp_id=?";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, id);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        System.out.println("\n------ EMPLOYEE DETAILS ------");
                        System.out.println("Employee ID : " + rs.getInt("emp_id"));
                        System.out.println("Name        : " + rs.getString("emp_name"));
                        System.out.println("Department  : " + rs.getString("department"));
                        System.out.println("Designation : " + rs.getString("designation"));
                        System.out.println("Salary      : " + rs.getDouble("salary"));
                        System.out.println("Phone       : " + rs.getString("phone"));
                    } else {
                        System.out.println("Employee not found!");
                    }

                    rs.close();
                    ps.close();

                } else if (choice == 5) {

                    System.out.println("Exiting Employee Management System...");
                    break;

                } else {
                    System.out.println("Invalid choice! Please try again.");
                }
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}
