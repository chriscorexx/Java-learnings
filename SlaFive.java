import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SlaFive extends JFrame {

    JTextField regField, nameField, courseField, yearField, phoneField;
    JTable studentTable;
    DefaultTableModel tableModel;

    ArrayList<String[]> students = new ArrayList<>();

    public SlaFive() {

        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formPanel = createFormPanel();
        add(formPanel, BorderLayout.NORTH);

        JPanel tablePanel = createTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Student Details"
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        regField = new JTextField(15);
        nameField = new JTextField(15);
        courseField = new JTextField(15);
        yearField = new JTextField(15);
        phoneField = new JTextField(15);

        addFormRow(panel, gbc, 1, "Registration Number:", regField);
        addFormRow(panel, gbc, 2, "Student Name:", nameField);
        addFormRow(panel, gbc, 3, "Course:", courseField);
        addFormRow(panel, gbc, 4, "Year:", yearField);
        addFormRow(panel, gbc, 5, "Phone Number:", phoneField);

        return panel;
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 1.0;
        panel.add(field, gbc);
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Student Records"
        ));

        String[] columns = {"Registration Number", "Name", "Course", "Year", "Phone"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        studentTable = new JTable(tableModel);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.getTableHeader().setReorderingAllowed(false);
        studentTable.setFont(new Font("Arial", Font.PLAIN, 14));
        studentTable.setRowHeight(25);

        studentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow >= 0) {
                    populateFormFromTable(selectedRow);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setPreferredSize(new Dimension(750, 300));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton insertBtn = new JButton("Insert");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton searchBtn = new JButton("Search");
        JButton clearBtn = new JButton("Clear");
        JButton exitBtn = new JButton("Exit");

        insertBtn.addActionListener(e -> insertStudent());
        updateBtn.addActionListener(e -> updateStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
        searchBtn.addActionListener(e -> searchStudent());
        clearBtn.addActionListener(e -> clearFields());
        exitBtn.addActionListener(e -> System.exit(0));

        panel.add(insertBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);
        panel.add(searchBtn);
        panel.add(clearBtn);
        panel.add(exitBtn);

        return panel;
    }

    void insertStudent() {

        String reg = regField.getText().trim();

        if (reg.isEmpty() || nameField.getText().trim().isEmpty()
                || courseField.getText().trim().isEmpty()
                || yearField.getText().trim().isEmpty()
                || phoneField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        if (!isValidYear(yearField.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Year must be a valid number (e.g., 1-5).");
            return;
        }

        if (!isValidPhone(phoneField.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Phone must contain only digits (10-15 digits).");
            return;
        }

        if (findStudent(reg) != -1) {
            JOptionPane.showMessageDialog(this, "Student already exists.");
            return;
        }

        students.add(new String[]{
            reg,
            nameField.getText().trim(),
            courseField.getText().trim(),
            yearField.getText().trim(),
            phoneField.getText().trim()
        });

        refreshTable();
        JOptionPane.showMessageDialog(this, "Student inserted successfully!");
        clearFields();
    }

    void updateStudent() {

        String reg = regField.getText().trim();
        int index = findStudent(reg);

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }

        if (!nameField.getText().trim().isEmpty() && !courseField.getText().trim().isEmpty()
                && !yearField.getText().trim().isEmpty() && !phoneField.getText().trim().isEmpty()) {

            if (!isValidYear(yearField.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Year must be a valid number (e.g., 1-5).");
                return;
            }

            if (!isValidPhone(phoneField.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Phone must contain only digits (10-15 digits).");
                return;
            }
        }

        String[] student = students.get(index);

        if (!nameField.getText().trim().isEmpty())
            student[1] = nameField.getText().trim();

        if (!courseField.getText().trim().isEmpty())
            student[2] = courseField.getText().trim();

        if (!yearField.getText().trim().isEmpty())
            student[3] = yearField.getText().trim();

        if (!phoneField.getText().trim().isEmpty())
            student[4] = phoneField.getText().trim();

        refreshTable();
        JOptionPane.showMessageDialog(this, "Student updated successfully!");
        clearFields();
    }

    void deleteStudent() {

        String reg = regField.getText().trim();
        int index = findStudent(reg);

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this student?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            students.remove(index);
            refreshTable();
            JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            clearFields();
        }
    }

    void searchStudent() {

        String reg = regField.getText().trim();

        if (reg.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Registration Number to search.");
            return;
        }

        int index = findStudent(reg);

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }

        String[] student = students.get(index);

        nameField.setText(student[1]);
        courseField.setText(student[2]);
        yearField.setText(student[3]);
        phoneField.setText(student[4]);

        studentTable.setRowSelectionInterval(index, index);
        studentTable.scrollRectToVisible(studentTable.getCellRect(index, 0, true));

        JOptionPane.showMessageDialog(this, "Student found!");
    }

    void populateFormFromTable(int row) {
        regField.setText(tableModel.getValueAt(row, 0).toString());
        nameField.setText(tableModel.getValueAt(row, 1).toString());
        courseField.setText(tableModel.getValueAt(row, 2).toString());
        yearField.setText(tableModel.getValueAt(row, 3).toString());
        phoneField.setText(tableModel.getValueAt(row, 4).toString());
    }

    int findStudent(String reg) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i)[0].equals(reg)) {
                return i;
            }
        }

        return -1;
    }

    void clearFields() {
        regField.setText("");
        nameField.setText("");
        courseField.setText("");
        yearField.setText("");
        phoneField.setText("");
        studentTable.clearSelection();
    }

    void refreshTable() {
        tableModel.setRowCount(0);
        for (String[] student : students) {
            tableModel.addRow(student);
        }
    }

    boolean isValidYear(String year) {
        try {
            int y = Integer.parseInt(year);
            return y >= 1 && y <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean isValidPhone(String phone) {
        return phone.matches("\\d{10,15}");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new SlaFive());
    }
}