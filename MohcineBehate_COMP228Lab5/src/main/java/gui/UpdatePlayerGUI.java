package gui;

import exercise1.Player;
import exercise1.PlayerDAO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdatePlayerGUI extends JFrame {

    private JComboBox<Long> playerIdBox;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField ageField;

    private ArrayList<Player> players;

    public UpdatePlayerGUI() {
        setTitle("Update Player");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        players = PlayerDAO.getAllPlayers();

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        panel.add(new JLabel("Select Player ID:"));
        playerIdBox = new JComboBox<>();

        // Load IDs from player objects
        for (Player p : players) {
            playerIdBox.addItem(p.getPlayerId());
        }

        panel.add(playerIdBox);

        // Name field
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        // Email field
        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        // Age field
        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        // Update button
        JButton updateBtn = new JButton("Update Player");
        panel.add(updateBtn);

        add(panel);

        // Dropdown change event
        playerIdBox.addActionListener(e -> loadPlayerInfo());

        // Update button event
        updateBtn.addActionListener(e -> updatePlayer());

        // Auto-load the first player
        if (!players.isEmpty()) {
            playerIdBox.setSelectedIndex(0);
            loadPlayerInfo();
        }

        setVisible(true);
    }

    private void loadPlayerInfo() {
        long selectedId = (long) playerIdBox.getSelectedItem();

        for (Player p : players) {
            if (p.getPlayerId() == selectedId) {
                nameField.setText(p.getPlayerName());
                emailField.setText(p.getPlayerEmail());
                ageField.setText(String.valueOf(p.getPlayerAge()));
                break;
            }
        }
    }

    private void updatePlayer() {
        try {
            long id = (long) playerIdBox.getSelectedItem();
            String name = nameField.getText();
            String email = emailField.getText();
            int age = Integer.parseInt(ageField.getText());

            PlayerDAO.updatePlayer((int) id, name, email, age);

            JOptionPane.showMessageDialog(this, "Player updated!");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
