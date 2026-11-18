import java.awt.*;
import java.awt.event.*;

class PracticalTwentyTwo extends Frame {
    PracticalTwentyTwo() {
        setLayout(new BorderLayout());

        Button b1 = new Button("Left");
        Button b2 = new Button("Right");
        Button b3 = new Button("Top");
        Button b4 = new Button("Bottom");

        add(b1, BorderLayout.WEST);
        add(b2, BorderLayout.EAST);
        add(b3, BorderLayout.NORTH);
        add(b4, BorderLayout.SOUTH);

        setTitle("Border Layout Example");
        setSize(400, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new PracticalTwentyTwo();
    }
}
