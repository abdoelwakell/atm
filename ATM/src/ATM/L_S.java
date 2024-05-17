package ATM;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class L_S extends SUPER implements ActionListener {
    public static JButton LOG , SIGN  ;
    public  static JLabel L;
     
    L_S() {
        super("CHOOSE");
      
        L= new JLabel("WELCOME TO ATM SYSTEM ") ;
        L.setBounds(130, 100 , 500 , 150);
        L.setForeground(Color.blue) ;
        L.setFont(new Font("Arial", Font.BOLD, 30));
        LOG = new JButton("LOG IN ") ;
        SIGN = new JButton("SIGN UP ") ;
        LOG.setBackground(Color.blue );
        LOG.setForeground(Color.white); 
        SIGN.setBackground(Color.blue );
        SIGN.setForeground(Color.white);  
          add(LOG) ;
          add(SIGN) ;
          add(L) ;
         SIGN.setBounds(220, 340 , 100,30) ;
         LOG.setBounds(400, 340 , 100,30) ;
         LOG.addActionListener(this);
         SIGN.addActionListener(this);
    }
    public static  L_S  frame;
  
    public static void main(String[] args) {
      JFrame frame = new L_S () ;
      frame.setVisible(true);
     // x = new L_S() ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == LOG ) {
        LOG_IN1 x = new LOG_IN1() ;
        x.setVisible(true);
        this.dispose();  
      }
          else if (e.getSource() == SIGN ) {
        Sign_up x =new Sign_up() ;
        x.setVisible(true);
        this.dispose(); 
      }
     }
    }

