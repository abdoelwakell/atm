package ATM;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

public class Serivce extends SUPER implements  ActionListener {
    public static JLabel l ;
    public static JButton b1, b2 ;
   public static JTextField L_filed ;
    public static JButton with ;
    Connection con;

    Serivce() {
        super("serivce");
        l= new JLabel("Are you want other services") ;
        l.setFont(new Font("Osward", Font.BOLD, 30));
        l.setForeground(Color.BLUE);
        l.setBounds(140,80,550,40);
        add(l) ;
        b1= new JButton("YES") ;
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(370,340,100,30);
       b1.addActionListener(this);
        add(b1) ;
        b2= new JButton("NO") ;
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(180,340,100,30);
        b2.addActionListener(this);
        add(b2) ;
    }
    public static void main(String[] args) {
        Serivce S = new Serivce() ;
        S.setVisible(true) ;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(b1)) {
        Main x= new Main() ;
        x.setVisible(true) ;
        this.dispose(); 
       } else if (e.getSource().equals(b2)) {
        this.dispose(); 
       }
    }
}
