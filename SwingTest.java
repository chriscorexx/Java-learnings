import javax.swing.*;
import java.awt.*;

public class SwingTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing Test");

            JLabel label = new JLabel(
                "JAVA GUI IS WORKING!",
                SwingConstants.CENTER
            );

            label.setFont(new Font("Arial", Font.BOLD, 24));

            JButton button = new JButton("Click Me");
            button.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Button works!")
            );

            frame.setLayout(new BorderLayout());
            frame.add(label, BorderLayout.CENTER);
            frame.add(button, BorderLayout.SOUTH);

            frame.setSize(500, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
