/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimecc;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author dserazin
 */
public class Logout 
{
    public static void Logout()
    {
     JFrame jf = new JFrame();
            jf.setTitle("RealTimeCC");
            jf.setLayout(null);
            jf.setSize(new Dimension(590, 700));
      //      jf.setMinimumSize(new Dimension(300,300));
      //      jf.setMaximumSize(new Dimension(600,600));
          // jf.setLocation(50, 50);
            jf.setLocationRelativeTo(jf);
            jf.getContentPane().setBackground(Color.DARK_GRAY);
     //       jf.getContentPane().setBackground(Color.green);
       
         jf.setVisible(true);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
             
//____________________________________________________________________         
          // Erste Reihe : Eingabe Name / Textfel             
       JLabel jl1 = new JLabel();
            jl1.setText("Benutzername");
            jl1.setBounds(30, 30, 160, 30);
            jl1.setForeground(Color.red);
            jl1.setFont(new Font("areal",0,20));
            jf.add(jl1);     
            
       JTextField jtf1 = new JTextField();
            jtf1.setBounds(200, 30, 200, 30);
            jtf1.setBackground(Color.LIGHT_GRAY);
            jf.add(jtf1);
         
         // DateTime________________
            
       JLabel jl0 = new JLabel();
            jl0.setText("Logout Time");
            jl0.setBounds(100, 350, 400, 30);
            jl0.setForeground(Color.red);
            jl0.setFont(new Font("areal",0,20));
            jf.add(jl0);
            
            // Zweite Reihe : Eingabe Fachrichtung / Textfeld                   
       JLabel jl2 = new JLabel();
            jl2.setText("Kennwort");
            jl2.setBounds(30, 63, 160, 30);
            jl2.setForeground(Color.RED);
            jl2.setFont(new Font("areal",0,20));
            jf.add(jl2);  
            
       JTextField jtf2 = new JTextField();
            jtf2.setBounds(200, 63, 200, 30); //X-Hor. ,Y-Senk. ,L ,B
            jtf2.setBackground(Color.LIGHT_GRAY);
            jf.add(jtf2);
            
            // Schaltfläche Berechnung
       JButton jcb1 = new JButton("SignOut", null);
            jcb1.setForeground(Color.blue);
            jcb1.setBackground(Color.red);
            jcb1.setBounds(245, 120, 100, 30);
            jf.add(jcb1);
            
            jcb1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             Date date = new Date();
             jl0.setText("Logout Time "+date.toString());
         }
     });
//_______________________________________________________________________            
            jf.repaint();
       jf.setVisible(true);
    }
}