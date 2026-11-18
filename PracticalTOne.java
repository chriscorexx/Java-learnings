import java.awt.*;
import java.awt.event.*;

class PracticalTwentyOne extends Frame {
    PracticalTwentyOne() {
        MenuBar mb = new MenuBar();

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        MenuItem newItem = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem exit = new MenuItem("Exit");

        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");

        MenuItem about = new MenuItem("About");

        Menu submenu = new Menu("More Options");
        submenu.add(new MenuItem("Print"));
        submenu.add(new MenuItem("Preview"));

        file.add(newItem);
        file.add(open);
        file.add(save);
        file.add(submenu);
        file.addSeparator();
        file.add(exit);

        edit.add(copy);
        edit.add(paste);

        help.add(about);

        mb.add(file);
        mb.add(edit);
        mb.add(help);

        setMenuBar(mb);

        setTitle("Menu Bar Example");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new PracticalTwentyOne();
    }
}
