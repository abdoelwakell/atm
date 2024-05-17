package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Details extends SUPER implements ActionListener {
    public static JLabel name, phone, balance, main;
    public static JTextField name1, phone1, balance1;
    public static JButton conf;
    Connection con;

    Details() {
        super("Details");
        
        main = new JLabel("Details");
        main.setFont(new Font("Osward", Font.BOLD, 38));
        main.setForeground(Color.BLUE);
        main.setBounds(280, 80, 450, 40);
        add(main);

        name = new JLabel("User Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(210, 200, 150, 30);
        name.setForeground(Color.BLUE);
        add(name);
        
        name1 = new JTextField();
        name1.setBounds(330, 200, 200, 30);
        name1.setColumns(30);
        name1.setEditable(false);
        add(name1);

        phone = new JLabel("Phone:");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds(210, 250, 100, 30);
        phone.setForeground(Color.BLUE);
        add(phone);

        phone1 = new JTextField();
        phone1.setBounds(330, 250, 200, 30);
        phone1.setColumns(30);
        phone1.setEditable(false);
        add(phone1);

        balance = new JLabel("Balance:");
        balance.setFont(new Font("Raleway", Font.BOLD, 20));
        balance.setBounds(210, 300, 100, 30);
        balance.setForeground(Color.BLUE);
        add(balance);

        balance1 = new JTextField();
        balance1.setBounds(330, 300, 200, 30);
        balance1.setColumns(30);
        balance1.setEditable(false);
        balance1.setFont(new Font("Osward", Font.BOLD, 25));
        add(balance1);

        conf = new JButton("OK");
        conf.setBackground(Color.BLUE);
        conf.setForeground(Color.WHITE);
        conf.setFont(new Font("Arial", Font.BOLD, 14));
        conf.setBounds(380, 350, 100, 30);
        conf.addActionListener(this);
        add(conf);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_inf", "root", "1112004");
            display();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to the database.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Details del = new Details();
        del.setVisible(true);
    }

    public void display() {
        String id = LOG_IN1.cadField.getText();
        try {
            String sql = "SELECT balance, F_name, number FROM bank WHERE id=?";
            PreparedStatement selectStatement = con.prepareStatement(sql);
            selectStatement.setString(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int balance = resultSet.getInt("balance");
                String f_name = resultSet.getString("F_name");
                String phone = resultSet.getString("number");
                phone1.setText(phone);
                name1.setText(f_name);
                balance1.setText(String.valueOf(balance));
                name1.setFont(new Font("Osward", Font.BOLD, 20));
                phone1.setFont(new Font("Osward", Font.BOLD, 20));
                balance1.setFont(new Font("Osward", Font.BOLD, 20));
            } 

            resultSet.close();
            selectStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conf) {
            Serivce x = new Serivce() ;
            x.setVisible(true);
            this.dispose(); 
        }
    }
}
