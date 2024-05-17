package ATM;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Deposit  extends SUPER implements ActionListener {
    public static JLabel L ;
    public static JTextField T ;
    public static JButton dep ;
    Connection con;

  //ايداع
    Deposit() {
        super("Deposit");
        L = new JLabel("ENTER YOUE CASH") ;
        L.setFont(new Font("Osward", Font.BOLD, 35));
        L.setForeground(Color.BLUE);
        L.setBounds(180, 80, 500, 50);
        add(L);
        

        T = new JTextField() ;
        T.setBounds(200, 200, 300, 50);
        T.setColumns(30);
        add(T);

        dep = new JButton("Deposit") ;
        dep.setBackground(Color.BLUE);
        dep.setForeground(Color.WHITE);
        dep.setFont(new Font("Arial", Font.BOLD, 17));
        dep.setBounds(280, 320, 100, 30);
        dep.addActionListener(this);
        add(dep);


         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_inf", "root", "1112004");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Deposit x = new Deposit() ;
        x.setVisible(true) ;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String newBalance = T.getText();
        String id = LOG_IN1.cadField.getText();
        if (e.getSource().equals(dep) && T.getText()==" " ) {
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
                int totalBalance = existingBalance + Integer.parseInt(newBalance);

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

