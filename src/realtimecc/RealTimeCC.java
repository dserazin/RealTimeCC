/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimecc;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import static realtimecc.Admin.Admin;
import static realtimecc.Login.Login;

/**
 *
 * @author dserazin
 */
public class RealTimeCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
         // Erstelle Frame um zwischen Login und Admin zu wählen
        JFrame jf = new JFrame();
            jf.setTitle("Login Portal");
            jf.setLayout(null);
            jf.setSize(new Dimension(600, 300));
            jf.getContentPane().setBackground(Color.DARK_GRAY);
            
         jf.setVisible(true);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     JButton jcb1 = new JButton("Login", null);
            jcb1.setForeground(Color.blue);
            jcb1.setBackground(Color.red);
            jcb1.setBounds(60, 60, 180, 100);
            jf.add(jcb1);
            
            JButton jcb2 = new JButton("Admin", null);
            jcb2.setForeground(Color.blue);
            jcb2.setBackground(Color.red);
            jcb2.setBounds(330, 60, 180, 100);
            jf.add(jcb2);
            
            jcb1.addActionListener((ActionEvent e) -> {
               Login(); 
                Date date = new Date();
              System.out.println(date.toString());
             
            });     
            jcb2.addActionListener((ActionEvent e) -> {
                
                    Admin();
            });
                            
                  
                  
        jf.repaint();
        jf.setVisible(true);
            }   
            
    }
