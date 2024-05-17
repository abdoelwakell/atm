package ATM;

import java.awt. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends SUPER  implements ActionListener {
    public static JLabel l ;
    public static JTextField L_filed ;
    public static JButton with ;
    Connection con;
    


    
    Withdraw() {
        super("Withdraw");
        l = new JLabel("ENTER YOUE CASH") ;
        l.setFont(new Font("Osward", Font.BOLD, 35));
        l.setForeground(Color.BLUE);
        l.setBounds(180, 80, 500, 50);
        add(l);
        L_filed = new JTextField() ;
        L_filed.setBounds(200, 200, 300, 50);
        L_filed.setColumns(30);
        add(L_filed);
        //
        with = new JButton("Withdraw") ;
        with.setBackground(Color.BLUE);
        with.setForeground(Color.WHITE);
        with.setFont(new Font("Arial", Font.BOLD, 17));
        with.setBounds(280, 320, 150, 30);
     with.addActionListener(this);
        add(with);

         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_inf", "root", "1112004");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        Withdraw x = new Withdraw() ;
        x.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newBalance = L_filed.getText();
        String id = LOG_IN1.cadField.getText();
        if (e.getSource().equals(with) && L_filed.getText()==" " ) {
            JOptionPane.showMessageDialog(null, "ENTER CASH ");
        }

        try {
            
            String sql = "SELECT balance FROM bank WHERE id=?";
            PreparedStatement selectStatement = con.prepareStatement(sql);
            selectStatement.setString(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int existingBalance = resultSet.getInt("balance");

                // Calculate the new total balance
                int totalBalance = existingBalance-Integer.parseInt(newBalance);

                // Update the database with the new total balance
                String updateSql = "UPDATE bank SET balance = ? WHERE id=?";
                PreparedStatement updateStatement = con.prepareStatement(updateSql);
                updateStatement.setInt(1, totalBalance);
                updateStatement.setString(2, id);
                int rowsUpdated = updateStatement.executeUpdate();
                
                if (rowsUpdated > 0) {
                   Serivce x = new Serivce() ;
                   x.setVisible(true);
                   this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No rows updated.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ID not found.");
            }

            con.close(); // Close the connection

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(this, "Error: " + x.getMessage());
        }
    }
}

