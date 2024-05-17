package ATM;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SUPER extends JFrame {
    SUPER (String title ) {
        super(title);
        setSize(700,700);
         setVisible(true);
         ImageIcon Icon= new ImageIcon("src\\ATM\\logo.jpg");
         setIconImage(Icon.getImage());
        setLocationRelativeTo(null) ;
        //setResizable(true);
        setLayout(null);       
    }

}