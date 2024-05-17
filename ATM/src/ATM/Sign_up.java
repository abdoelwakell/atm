package ATM;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sign_up extends SUPER implements ActionListener {
    public static JLabel L, First, last, pass, conf_pass, number, id , C;
    public static JTextField First_f, last_f, pass_f, conf_f, num_f, id_f;
    public static JButton sign_Button;
    Connection con;

    Sign_up() {
        super("SIGN UP");
        C = new JLabel("CREATE NEW ACCOUNT ") ;
        C.setFont(new Font("Osward", Font.BOLD, 20));
        C.setForeground(Color.BLUE);
        C.setBounds(210, 15, 500, 50);
        add(C);
        L = new JLabel("SIGN UP");
        L.setFont(new Font("Osward", Font.BOLD, 35));
        L.setForeground(Color.BLUE);
        L.setBounds(260, 90, 450, 40);
        add(L);
        First = new JLabel("first name ");
        First.setFont(new Font("Raleway", Font.BOLD, 16));
        First.setBounds(200, 160, 100, 30);
        First.setForeground(Color.BLUE);
        add(First);
        First_f = new JTextField(13);
        First_f.setBounds(330, 160, 200, 30);
        First_f.setColumns(30);
        add(First_f);
        last = new JLabel("last name");
        last.setFont(new Font("Raleway", Font.BOLD, 16));
        last.setBounds(200, 210, 100, 30);
        last.setForeground(Color.BLUE);
        add(last);
        last_f = new JTextField(13);
        last_f.setBounds(330, 210, 200, 30);
        last_f.setColumns(30);
        add(last_f);
        pass = new JLabel("password");
        pass.setFont(new Font("Raleway", Font.BOLD, 16));
        pass.setBounds(200, 260, 100, 30);
        pass.setForeground(Color.BLUE);
        add(pass);
        pass_f = new JPasswordField();
        pass_f.setBounds(330, 260, 200, 30);
        pass_f.setColumns(30);
        add(pass_f);
        conf_pass = new JLabel("confrim password ");
        conf_pass.setFont(new Font("Raleway", Font.BOLD, 15));
        conf_pass.setBounds(170, 310, 150, 30);
        conf_pass.setForeground(Color.BLUE);
        add(conf_pass);
        conf_f = new JPasswordField();
        conf_f.setBounds(330, 310, 200, 30);
        conf_f.setColumns(30);
        add(conf_f);

        number = new JLabel("phone");
        number.setFont(new Font("Raleway", Font.BOLD, 15));
        number.setBounds(190, 360, 150, 30);
        number.setForeground(Color.BLUE);
        add(number);

        num_f = new JTextField(13);
        num_f.setBounds(330, 360, 200, 30);
        num_f.setColumns(30);
        add(num_f);

        id = new JLabel("nantional id ");
        id.setFont(new Font("Raleway", Font.BOLD, 15));
        id.setBounds(190, 420, 150, 30);
        id.setForeground(Color.BLUE);
        add(id);

        id_f = new JTextField();
        id_f.setBounds(330, 420, 200, 30);
        id_f.setColumns(30);
        add(id_f);

        sign_Button = new JButton("SIGN UP");
        sign_Button.setBackground(Color.BLUE);
        sign_Button.setForeground(Color.WHITE);
        sign_Button.setFont(new Font("Arial", Font.BOLD, 14));
        sign_Button.setBounds(330, 500, 100, 30);
        sign_Button.addActionListener(this);
        add(sign_Button);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_inf", "root", "1112004");
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Sign_up sign_up = new Sign_up();
        sign_up.setVisible(true);
    }

   
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String First_f1 = First_f.getText();
        String Last_f1 = last_f.getText();
        String pass_f1 = pass_f.getText();
        String conf_f1 = conf_f.getText();
        String num_f1 = num_f.getText();
        String id_f1 = id_f.getText();
    
     
        if (First_f1.isEmpty() || Last_f1.isEmpty() || pass_f1.isEmpty() || conf_f1.isEmpty() || num_f1.isEmpty() || id_f1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        } 
    
       
     else if  (!pass_f1.equals(conf_f1)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.");
            return; 
        }
        try {
            String sql = "INSERT INTO bank(id,F_name,n_name, password ,c_password,number) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, id_f1);
            statement.setString(2, First_f1);
            statement.setString(3, Last_f1);
            statement.setString(4, pass_f1);
            statement.setString(5, conf_f1);
            statement.setString(6, num_f1);
            statement.executeUpdate();
            LOG_IN1 x = new LOG_IN1();
            x.setVisible(true);
            this.dispose();
            con.close();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error: Failed to insert data. Please enter valid data.");
        }
    }
}    