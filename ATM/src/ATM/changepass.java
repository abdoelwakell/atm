package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class changepass extends SUPER implements ActionListener {
    public static JLabel pass, confpass, main;
    public static JPasswordField passField, conField;
    public static JButton conf;
    Connection con;

    changepass() {
        super("CHANGE PASSWORD");

        main = new JLabel("Change your password");
        main.setFont(new Font("Osward", Font.BOLD, 35));
        main.setForeground(Color.BLUE);
        main.setBounds(140, 80, 500, 50);
        add(main);

        pass = new JLabel("Password:");
        pass.setFont(new Font("Raleway", Font.BOLD, 18));
        pass.setBounds(180, 200, 100, 30);
        pass.setForeground(Color.BLUE);
        add(pass);

        passField = new JPasswordField();
        passField.setBounds(390, 200, 200, 30);
        passField.setColumns(30);
        add(passField);

        confpass = new JLabel("Confirm Password:");
        confpass.setFont(new Font("Raleway", Font.BOLD, 18));
        confpass.setBounds(180, 250, 200, 30);
        confpass.setForeground(Color.BLUE);
        add(confpass);

        conField = new JPasswordField();
        conField.setBounds(390, 250, 200, 30);
        conField.setColumns(30);
        add(conField);

        conf = new JButton("Confirm");
        conf.setBackground(Color.BLUE);
        conf.setForeground(Color.WHITE);
        conf.setFont(new Font("Arial", Font.BOLD, 14));
        conf.setBounds(320, 350, 100, 30);
        conf.addActionListener(this);
        add(conf);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_inf", "root", "1112004");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to the database.");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newPassword = new String(passField.getPassword());
        String confirmPassword = new String(conField.getPassword());
        String id = LOG_IN1.cadField.getText();

     
            if (newPassword.equals(confirmPassword)) {
                PreparedStatement statement;
                
                try {
                    String sql = "UPDATE bank SET password = ?, c_password = ? WHERE id = ?";
                    statement = con.prepareStatement(sql);
                    statement.setString(1, newPassword);
                    statement.setString(2, confirmPassword);
                    statement.setString(3, id);
                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        LOG_IN1 x = new LOG_IN1();
                        x.setVisible(true);
                        this.dispose();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Please fill in all field " 
                    );
                } 
                    
            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match.");
            }
        }
    
    
    public static void main(String[] args) {
        changepass x = new changepass();
        x.setVisible(true);
    }
}
