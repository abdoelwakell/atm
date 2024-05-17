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
import javax.swing.JTextField;


public class Balance  extends SUPER  implements ActionListener {
    public static JLabel l ;
        public static JTextField L_filed ;
        public static JButton confrim ;
        Connection con;
   
    Balance() {
        super("BALANCE");
        l= new JLabel("Your balance is :  ") ;
        l.setFont(new Font("Osward", Font.BOLD, 35));
        l.setForeground(Color.BLUE);
        l.setBounds(180, 80, 500, 50);
        add(l);
                L_filed = new JTextField() ;
        L_filed.setBounds(170, 200, 350, 40);
        L_filed.setColumns(30);
        L_filed.setEditable(false);
        add(L_filed);
        //
        confrim = new JButton("confrim") ;
        confrim.setBackground(Color.BLUE);
        confrim.setForeground(Color.WHITE);
        confrim.setFont(new Font("Arial", Font.BOLD, 17));
        confrim.setBounds(250, 320, 150, 30);
        confrim.addActionListener(this);
        add(confrim);

         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_inf", "root", "1112004");
            displayBalance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
         Balance x = new Balance() ;
         x.setVisible(true);
    } 
    public void displayBalance() {
        String id = LOG_IN1.cadField.getText();
        try {
            String sql = "SELECT balance FROM bank WHERE id=?";
            PreparedStatement selectStatement = con.prepareStatement(sql);
            selectStatement.setString(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int balance = resultSet.getInt("balance");
                L_filed.setText(String.valueOf(balance));
                L_filed.setFont(new Font("Osward", Font.BOLD, 25));
            } else {
                L_filed.setText("Balance not found");
            }

            resultSet.close();
            selectStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(confrim)) {
        Serivce x = new Serivce() ;
        x.setVisible(true);
        this.dispose(); 
    }
    }
}

