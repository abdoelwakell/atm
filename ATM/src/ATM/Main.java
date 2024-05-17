package ATM;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
public class Main extends SUPER implements ActionListener {
    public static JButton Deposit ,  withdraw , b_1,b_2, b_3, balanace , b4 , del;
    public static JLabel l ;
    Main() {
        super("MAIN ATM ");
        l = new JLabel("choose service you want ") ;
        l.setFont(new Font("Osward", Font.BOLD, 25));
        l.setForeground(Color.BLUE);
        l.setBounds(200,70,450,40);
        add(l) ;
        Deposit= new JButton("Deposit") ;
        Deposit.setBackground(Color.BLUE);
        Deposit.setForeground(Color.WHITE);
        Deposit.setFont(new Font("Arial", Font.BOLD, 25));
        Deposit.setBounds(30,200,200,50);
        Deposit.addActionListener(this);
        add(Deposit) ;
        withdraw = new JButton("withdraw") ;
        withdraw.setBackground(Color.BLUE);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("Arial", Font.BOLD, 25));
        withdraw.setBounds(400,200,200,50);
        withdraw.addActionListener(this);
        add(withdraw) ;
        b_1 = new JButton("change password") ;
        b_1.setBackground(Color.BLUE);
        b_1.setForeground(Color.WHITE);
        b_1.setFont(new Font("Arial", Font.BOLD, 20));
        b_1.setBounds(25,300,220,50);
        b_1.addActionListener(this);
        add(b_1) ;
        b_2 = new JButton("Delete account") ;
        b_2.setBackground(Color.BLUE);
        b_2.setForeground(Color.WHITE);
        b_2.setFont(new Font("Arial", Font.BOLD, 20));
        b_2.setBounds(400,300,220,50);
        b_2.addActionListener(this);
        add(b_2) ;
        b_3 = new JButton("400") ;
        b_3.setBackground(Color.BLUE);
        b_3.setForeground(Color.WHITE);
        b_3.setFont(new Font("Arial", Font.BOLD, 25));
        b_3.setBounds(30,400,200,50);
        add(b_3) ;
        b4 = new JButton("1000") ;
        b4.setBackground(Color.BLUE);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Arial", Font.BOLD, 25));
        b4.setBounds(400,400,200,50);
        add(b4) ;
        balanace = new JButton("balanace") ;
        balanace.setBackground(Color.BLUE);
        balanace.setForeground(Color.WHITE);
        balanace.setFont(new Font("Arial", Font.BOLD, 25));
        balanace.setBounds(30,500,200,50);
        balanace.addActionListener(this) ;
        add(balanace) ;
        del = new JButton("DETAILS") ;
        del.setBackground(Color.BLUE);
        del.setForeground(Color.WHITE);
        del.setFont(new Font("Arial", Font.BOLD, 25));
        del.setBounds(400,500,200,50);
        del.addActionListener(this);
        add(del) ;

    }
    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(Deposit)){
        Deposit x = new Deposit() ;
        x.setVisible(true);
        this.dispose(); 
    } 
     else if (e.getSource().equals(withdraw)){
        Withdraw x = new Withdraw() ;
        x.setVisible(true);
        this.dispose(); 
    }  else if (e.getSource().equals(balanace)){
        Balance x = new Balance() ;
        x.setVisible(true);
        this.dispose(); 
    } 
    else if (e.getSource().equals(del)) 
{
    Details x = new Details() ;
    x.setVisible(true);
    this.dispose(); 
} else if (e.getSource().equals(b_1)) {
    changepass x = new changepass() ;
    x.setVisible(true);
    this.dispose(); 
} else if (e.getSource().equals(b_2)) {
delete x = new delete() ;
x.setVisible(true);
this.dispose();
}
}}
