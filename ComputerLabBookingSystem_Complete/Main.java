import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        try {
            Database.initialize();
            EventQueue.invokeLater(() -> new Login().setVisible(true));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Could not initialize the database.");
        }
    }
}
