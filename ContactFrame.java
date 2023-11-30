package DActividad6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactFrame extends JFrame {
    private JTextField nameField;
    private JTextField numberField;
    private JTextArea resultArea;

    public ContactFrame() {
        setLayout(new BorderLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Number:"));
        numberField = new JTextField();
        inputPanel.add(numberField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                long number = Long.parseLong(numberField.getText());
                AddFriend.add(name, number);
                resultArea.setText("Contact added.");
            }
        });
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                DeleteFriend.delete(name);
                resultArea.setText("Contact removed.");
            }
        });
        buttonPanel.add(removeButton);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                SearchFriend.search(name);
                resultArea.setText("Contact searched.");
            }
        });
        buttonPanel.add(searchButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldName = nameField.getText();
                String newName = JOptionPane.showInputDialog("Enter new name:");
                long newNumber = Long.parseLong(JOptionPane.showInputDialog("Enter new number:"));
                UpdateFriend.update(oldName, newName, newNumber);
                resultArea.setText("Contact updated.");
            }
        });
        buttonPanel.add(updateButton);

        add(buttonPanel, BorderLayout.CENTER);

        resultArea = new JTextArea();
        add(resultArea, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ContactFrame().setVisible(true);
    }
}
