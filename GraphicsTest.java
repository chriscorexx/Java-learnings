import javax.swing.*;
import java.awt.*;

public class GraphicsTest extends JFrame {

    public GraphicsTest() {
        setTitle("Java Graphics Diagnostic");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLUE);
                g.fillRect(50, 50, 200, 100);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 24));
                g.drawString("GRAPHICS WORKING", 50, 220);
            }
        };

        panel.setBackground(Color.YELLOW);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphicsTest::new);
    }
}
