package gui;

import exercise1.PlayerGameDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ReportGUI extends JFrame {

    public ReportGUI() {
        setTitle("Player Report");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Column names
        String[] columns = {"Player ID", "Name", "Email", "Age", "Game"};

        // Table model
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        // Fetch report rows
        ArrayList<String[]> data = PlayerGameDAO.getPlayerReport();

        for (String[] row : data) {
            if (row[4] == null) row[4] = "—";  // player has no games yet
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
