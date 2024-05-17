
package ATM;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class A4 implements ActionListener  {
    public static JLabel L1 ;
    public static JButton p1 , p2 ;
    public static JFrame frame ;
    public static ImageIcon icon ;
    public static void main(String[] args) {
   frame =new JFrame(" CHOOSE LANGUAGE ");
    L1 = new JLabel("WELCOME TO ATM SYSTEM ") ;
    icon= new ImageIcon("src\\ATM\\logo.jpg");
    frame.setIconImage(icon.getImage());
       L1.setBounds(130, 100 , 500 , 150);
    L1.setForeground(Color.blue) ;
    L1.setFont(new Font("Arial", Font.BOLD, 30));
        p1=new JButton( " English");
        p1.addActionListener(new A4() ) ;
        p2=new JButton( " عربي");
        p2.addActionListener(new A4() ) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null) ;
        frame.setResizable(true);
        frame.setLayout(null);       
        frame.add(p1);
        frame.add(p2);
        frame.add(L1) ;
        p1.setBounds(500,500,150,40);
        p2.setBounds(500,550,150,40);
        p1.setBackground(Color.blue );
        p1.setForeground(Color.white);
        p2.setBackground(Color.blue );
        p2.setForeground(Color.white);
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == p1  ) {
            L_S X = new L_S() ;
            X.setVisible(true);
            frame.dispose() ;
            frame.setVisible(false);
       }     
       else if (e.getSource() == p2  ) {
        L_S X = new L_S() ;
        X.setVisible(true);
       L_S.frame.dispose();
   }  
    }
 
}