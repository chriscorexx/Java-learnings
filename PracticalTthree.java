import java.awt.*;
import java.awt.event.*;

class PracticalTwentyThree extends Frame implements ActionListener {
    TextField tf;
    double num1, num2, result;
    String operator = "";

    PracticalTwentyThree() {
        tf = new TextField();
        add(tf, BorderLayout.NORTH);

        Panel p = new Panel();
        p.setLayout(new GridLayout(4, 4, 5, 5));

        String buttons[] = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String s : buttons) {
            Button b = new Button(s);
            p.add(b);
            b.addActionListener(this);
        }

        add(p, BorderLayout.CENTER);

        setTitle("Calculator");
        setSize(300, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("C")) {
            tf.setText("");
            operator = "";
        }
        else if (s.equals("+") || s.equals("-")
              || s.equals("*") || s.equals("/")) {
            num1 = Double.parseDouble(tf.getText());
            operator = s;
            tf.setText("");
        }
        else if (s.equals("=")) {
            num2 = Double.parseDouble(tf.getText());

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        tf.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            tf.setText(String.valueOf(result));
        }
        else {
            tf.setText(tf.getText() + s);
        }
    }

    public static void main(String[] args) {
        new PracticalTwentyThree();
    }
}
