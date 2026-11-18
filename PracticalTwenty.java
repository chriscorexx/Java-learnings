import java.awt.*;
import java.awt.event.*;

class PracticalTwenty extends Frame implements ActionListener {
    Label l;
    TextField t;
    Button b;

    PracticalTwenty() {
        l = new Label("Enter your name:");
        t = new TextField(20);
        b = new Button("Submit");

        setLayout(new FlowLayout());

        add(l);
        add(t);
        add(b);

        b.addActionListener(this);

        setTitle("Greeting Window");
        setSize(300, 150);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String name = t.getText();
        l.setText("Welcome " + name);
    }

    public static void main(String[] args) {
        new PracticalTwenty();
    }
}
