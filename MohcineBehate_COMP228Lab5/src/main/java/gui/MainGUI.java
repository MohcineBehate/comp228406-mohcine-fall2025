package gui;

import exercise1.PlayerDAO;
import exercise1.GameDAO;
import exercise1.PlayerGameDAO;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    public MainGUI() {

        setTitle("COMP228 Lab5 - Game App");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 5, 5));

        JButton addPlayerBtn = new JButton("Add Player");
        JButton addGameBtn = new JButton("Add Game");
        JButton linkBtn = new JButton("Link Player to Game");
        JButton updatePlayerBtn = new JButton("Update Player Info");
        JButton showReportBtn = new JButton("Show Player Report");
        JButton exitBtn = new JButton("Exit");

        panel.add(addPlayerBtn);
        panel.add(addGameBtn);
        panel.add(linkBtn);
        panel.add(updatePlayerBtn);
        panel.add(showReportBtn);
        panel.add(exitBtn);

        add(panel);

        // --- ACTION LISTENERS -
        addPlayerBtn.addActionListener(e -> addPlayer());
        addGameBtn.addActionListener(e -> addGame());
        linkBtn.addActionListener(e -> linkPlayerGame());

        updatePlayerBtn.addActionListener(e -> new UpdatePlayerGUI());
        showReportBtn.addActionListener(e -> new ReportGUI());

        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    // --- ADD PLAYER ----
    private void addPlayer() {
        String name = JOptionPane.showInputDialog("Enter player name:");
        String email = JOptionPane.showInputDialog("Enter email:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:"));
        PlayerDAO.insertPlayer(name, email, age);
    }

    // --- ADD GAME ---
    private void addGame() {
        String title = JOptionPane.showInputDialog("Enter game title:");
        GameDAO.insertGame(title);
    }

    // --- LINK PLAYER + GAME ---
    private void linkPlayerGame() {
        int playerId = Integer.parseInt(JOptionPane.showInputDialog("Enter Player ID:"));
        int gameId = Integer.parseInt(JOptionPane.showInputDialog("Enter Game ID:"));
        PlayerGameDAO.insertPlayerGame(playerId, gameId);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
