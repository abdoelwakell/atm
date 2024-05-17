package ATM;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LOG_IN1 extends SUPER implements ActionListener {
    public static JLabel card_id, l , password , L0 ;
    public static JTextField cadField ,pass;
    public static JButton LOG , SIGN_UP;
    Connection con ;
    LOG_IN1() {
        super("LOG IN ");
        l= new JLabel("LOG IN ") ;
        l.setFont(new Font("Osward", Font.BOLD, 38));
        l.setForeground(Color.BLUE);
        l.setBounds(280,80,450,40);
        add(l) ;
         card_id = new JLabel("CARD ID : ") ;
        card_id.setFont(new Font("Raleway", Font.BOLD, 16));
        card_id.setBounds(200 , 200 , 80 , 30);
        card_id.setForeground(Color.BLUE);
        add(card_id) ;
        cadField = new JTextField() ;
        cadField.setBounds(300, 200, 200, 30);
        cadField.setColumns(30); 
        add(cadField) ;
        
        password = new JLabel("password : " ) ;
        password.setFont(new Font("Raleway", Font.BOLD, 16));
        password.setForeground(Color.BLUE);
        password.setBounds(200,250,450,40);
        add(password) ;
        pass = new JPasswordField() ;
        pass.setBounds(300, 250, 200, 30);
        pass.setColumns(30); 
        add(pass) ;
        
        LOG= new JButton("Log in") ;
        LOG.setBackground(Color.BLUE);
        LOG.setForeground(Color.WHITE);
        LOG.setFont(new Font("Arial", Font.BOLD, 14));
        LOG.setBounds(340,340,100,30);
        LOG.addActionListener(this);
        add(LOG) ;
        L0 = new JLabel() ;
        L0 = new JLabel("I DONT'T HAVE ACCOUNT " ) ;
        L0.setFont(new Font("Raleway", Font.BOLD, 16));
        L0.setForeground(Color.BLUE);
        L0.setBounds(180 ,430,450,40);
        add(L0) ;
        SIGN_UP= new JButton("SIGN UP") ;
        SIGN_UP.setBackground(Color.BLUE);
        SIGN_UP.setForeground(Color.WHITE);
        SIGN_UP.setFont(new Font("Arial", Font.BOLD, 14));
        SIGN_UP.setBounds(420,430,100,30);
        SIGN_UP.addActionListener(this);
        add(SIGN_UP) ;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_inf", "root", "1112004");
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
        LOG_IN1 LOG_IN1= new LOG_IN1();
        LOG_IN1.setVisible(true);
    }
/* */
    @Override
    public void actionPerformed(ActionEvent e) {
          String id_id = cadField.getText() ;
         if (e.getSource() == LOG) {
            try {
                String sql = "select * from bank where id = ? AND password = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, id_id );
                ps.setString(2, pass.getText());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Main x = new Main() ;
                    x.setVisible(true);
                    this.dispose(); 
                   
                } else {
                    JOptionPane.showMessageDialog(null, "LOGIN FAILED");
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource().equals(SIGN_UP)) {
            Sign_up x =new Sign_up() ;
            x.setVisible(true);
            this.dispose(); 
        }
     
    }   
} 
