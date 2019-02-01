/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimecc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author dserazin
 */
public class Login 
{
    public static void Login()
    {
    
        JFrame jf = new JFrame();
            jf.setTitle("RealTimeCC");
            jf.setLayout(null);
            jf.setSize(new Dimension(590, 700));
      //      jf.setMinimumSize(new Dimension(300,300));
      //      jf.setMaximumSize(new Dimension(600,600));
           
       //     jf.setLocationRelativeTo(jf);
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
            
            
            // Zweite Reihe : Eingabe Fachrichtung / Textfeld                   
       JLabel jl2 = new JLabel();
            jl2.setText("Kennwort");
            jl2.setBounds(30, 63, 160, 30);
            jl2.setForeground(Color.red);
            jl2.setFont(new Font("areal",0,20));
            jf.add(jl2);  
            
       JTextField jtf2 = new JTextField();
            jtf2.setBounds(200, 63, 200, 30); //X-Hor. ,Y-Senk. ,L ,B
            jtf2.setBackground(Color.LIGHT_GRAY);
            jf.add(jtf2);
            
            // Schaltfläche Berechnung
       JButton jcb1 = new JButton("Senden", null);
            jcb1.setForeground(Color.blue);
            jcb1.setBackground(Color.red);
            jcb1.setBounds(225, 120, 100, 30);
            jf.add(jcb1);
            
//_______________________________________________________________________            
            jf.repaint();
       jf.setVisible(true);
    }
}
