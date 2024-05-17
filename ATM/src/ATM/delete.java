package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class delete extends SUPER implements ActionListener {
    public static JLabel main;
    public static JButton yes, no;
    Connection con;

    delete() {
        super("Delete Account");
        
        main = new JLabel("Are you sure you want to delete your account?");
        main.setFont(new Font("Osward", Font.BOLD, 25));
        main.setForeground(Color.BLUE);
        main.setBounds(80, 80, 600, 40);
        add(main);
        
        yes = new JButton("YES");
        yes.setBackground(Color.BLUE);
        yes.setForeground(Color.WHITE);
        yes.setFont(new Font("Arial", Font.BOLD, 14));
        yes.setBounds(370, 340, 100, 30);
        yes.addActionListener(this);
        add(yes);
        
        no = new JButton("NO");
        no.setBackground(Color.BLUE);
        no.setForeground(Color.WHITE);
        no.setFont(new Font("Arial", Font.BOLD, 14));
        no.setBounds(180, 340, 100, 30);
        no.addActionListener(this);
        add(no);
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_inf", "root", "1112004");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to the database.");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = LOG_IN1.cadField.getText();
        
        if (e.getSource().equals(yes)) {
            String sql = "DELETE FROM bank WHERE id = ?";
            
            try {
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, id);
                int rowsDeleted = statement.executeUpdate();
                
                if (rowsDeleted > 0) {
                   Sign_up x = new Sign_up() ;
                   x.setVisible(true);
                    con.close();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No account found with the provided ID.");
                }
                
                statement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else if (e.getSource().equals(no)) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        delete del = new delete();
        del.setVisible(true);
    }
}
