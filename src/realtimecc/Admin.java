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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static realtimecc.Datenbank.loescheDatensatz;
import static realtimecc.Datenbank.zeigeDatensaetze;

/**
 *
 * @author dserazin
 */
public class Admin {
    
    public static void Admin()
    {
    // Erstelle Frame um Mitarbeiter anzulegen
        JFrame jf = new JFrame();
            jf.setTitle("IHKPrüfung_Auswertung");
            jf.setLayout(null);
            jf.setSize(new Dimension(700, 700));
            jf.getContentPane().setBackground(Color.DARK_GRAY);
            
         jf.setVisible(true);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
 //___________ID zum Anzeigen / Löschen des Datensatzes________________

       JLabel jl0 = new JLabel();
            jl0.setText("ID");
            jl0.setBounds(450, 30, 60, 30);
            jl0.setForeground(Color.red);
            jl0.setFont(new Font("areal",0,30));
            jf.add(jl0);     
            
       JTextField jtf0 = new JTextField();
            jtf0.setBounds(500, 30, 60, 30);
            jtf0.setBackground(Color.LIGHT_GRAY);
            jf.add(jtf0);  
            
            
//__________ Erste Reihe : Eingabe Name / Textfeld________________________
       JLabel jl1 = new JLabel();
            jl1.setText("Name");
            jl1.setBounds(30, 30, 160, 30);
            jl1.setForeground(Color.red);
            jl1.setFont(new Font("areal",0,20));
            jf.add(jl1);     
            
       JTextField jtf1 = new JTextField();
            jtf1.setBounds(230, 30, 200, 30);
            jtf1.setBackground(Color.LIGHT_GRAY);
            jf.add(jtf1);
            
            
//__________ Zweite Reihe : Eingabe Fachrichtung / Textfeld______________
       JLabel jl2 = new JLabel();
            jl2.setText("Nachname");
            jl2.setBounds(30, 63, 160, 30);
            jl2.setForeground(Color.red);
            jl2.setFont(new Font("areal",0,20));
            jf.add(jl2);  
            
       JTextField jtf2 = new JTextField();
            jtf2.setBounds(230, 63, 200, 30); //X-Hor. ,Y-Senk. ,L ,B
            jtf2.setBackground(Color.LIGHT_GRAY);
            jf.add(jtf2);
           
//________ Dritte Reihe : Eingabe Theorie / Textfeld____________             
       JLabel jl3 = new JLabel();
            jl3.setText("Position");
            jl3.setBounds(30, 162, 180, 30);
            jl3.setForeground(Color.red);
            jl3.setFont(new Font("areal",0,20));
            jf.add(jl3);  
            
            
            //Array für Auswahl der Position
            String position[] = {"Dotzent","Schüler","Admin"};
        JComboBox cb1 = new JComboBox(position);
            cb1.setBounds(230, 162, 200, 30);   // X(Pos.r/l), Y(Höhe/Tiefe), L(Länge), B(Breite)
            cb1.setBackground(Color.LIGHT_GRAY);
            jf.add(cb1);
            cb1.setSelectedIndex(-1);
            
           
//_________ Vierte Reihe : Eingabe Theorie / Textfeld______________
       JLabel jl4 = new JLabel();
            jl4.setText("Standort");
            jl4.setBounds(30, 195, 180, 30);
            jl4.setForeground(Color.red);
            jl4.setFont(new Font("areal",0,20));
            jf.add(jl4);  
            
            
            //Array zur Auswahl der Position          
       String standort[] = {"Baden-Württemberg", "Bayern",
            "Berlin", "Brandenburg", "Bremen",
            "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
            "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
            "Saarland", "Sachsen", "Sachsen-Anhalt",
            "Schleswig-Holstein", "Thüringen"};
        JComboBox cb2 = new JComboBox(standort);
            cb2.setBounds(230, 195, 200, 30);
            cb2.setBackground(Color.LIGHT_GRAY);
            jf.add(cb2);
            cb2.setSelectedIndex(-1);
            
//__________ Fünfte Reihe : Eingabe Theorie / Textfeld ______________
       JLabel jl5 = new JLabel();
            jl5.setText("E-Mail");
            jl5.setBounds(30, 96, 180, 30);//30, 162, 180, 30
            jl5.setForeground(Color.red);
            jl5.setFont(new Font("areal",0,20));
            jf.add(jl5);  
            
       JTextField jtf5 = new JTextField();
            jtf5.setBounds(230, 96, 200, 30);//200, 162, 160, 30
            jtf5.setBackground(Color.LIGHT_GRAY);
            jf.add(jtf5);  
       
//__________ Sechste Reihe : Eingabe Theorie / Textfeld________________ 
       JLabel jl6 = new JLabel();
            jl6.setText("Tel.-Nummer");
            jl6.setBounds(30, 129, 180, 30);//30, 195, 180, 30
            jl6.setForeground(Color.red);
            jl6.setFont(new Font("areal",0,20));
            jf.add(jl6);  
            
       JTextField jtf6 = new JTextField();
            jtf6.setBounds(230, 129, 200, 30);//200, 195, 160, 30
            jtf6.setBackground(Color.LIGHT_GRAY);
            jf.add(jtf6);  
            
        
            
//___________ Schaltflächen Anzeige / Mitarbeiter anlegen / Löschen______________________________________
       
       JButton jcb3 = new JButton("Anzeigen", null);
            jcb3.setForeground(Color.blue);
            jcb3.setBackground(Color.red);
            jcb3.setBounds(30, 263, 180, 40);
            jf.add(jcb3);
            
       JButton jcb1 = new JButton("Mitarbeiter anlegen", null);
            jcb1.setForeground(Color.blue);
            jcb1.setBackground(Color.red);
            jcb1.setBounds(240, 263, 180, 40);
            jf.add(jcb1);
            
       JButton jcb2 = new JButton("Löschen", null);
            jcb2.setForeground(Color.blue);
            jcb2.setBackground(Color.red);
            jcb2.setBounds(450, 263, 180, 40);
            jf.add(jcb2);
            
               // ListenerButton Ausgabe Berechnung / Textfeld 
        JTextArea jta = new JTextArea();           
            jta.setBounds(150, 350, 360, 300);
            jta.setOpaque(true);
            jta.setBackground(Color.LIGHT_GRAY);
            
            jta.setFont(new Font("areal",255,10));
            jf.add(jta);  
            
         
            
//____________________ActionListener für JButton Mitarbeiter anlegen __________________________________
         jcb1.addActionListener((ActionEvent e) -> 
   {
            
            String text  = jtf1.getText();
            String text0 = jtf2.getText();
            String text1 = jtf5.getText();
            String text2 = jtf6.getText();  
            String text3 = (String) cb1.getSelectedItem();
            String text4 = (String) cb2.getSelectedItem();
            
        // Textfeld wird bereinigt______
             
             jtf1.setText(null);
             jtf2.setText(null);
             jtf5.setText(null);
             jtf6.setText(null);
             cb1.setSelectedItem(null);
             cb2.setSelectedItem(null);
             
             String[] psw = pswGenerieren(text, text0);
                System.out.println(psw);
                
            try {
         
                erstelleDatensatz(text,text0,text1,text2,text3,text4,psw);
                // Text wird in JTextArea ausgegeben 
                jta.setText(" Daten werden gespeichert... \r\n Vorgang abgeschlossen.\r\n "+psw);
            } catch (Exception ex) {
                Logger.getLogger(RealTimeCC.class.getName()).log(Level.SEVERE, null, ex);
            }
      
           //get.text ComboBox = Position/Standort______________                 
                
            cb1.addItemListener(new ItemListener()
        {
            //Methode, wenn sich der Status des Items in der JCombobox ändert
            public void itemStateChanged(ItemEvent ie)
            {                
                //Textfeldausgabe wird gesetzt mit einem Text --> Text wird erzeugt aus
                //dem angeklickten Eintrag der comcobox --> Umwandlung in String, damit
                //textfeldausgabe es übernehmen und anzeigen kann
                 jta.setText((String) cb1.getSelectedItem()); 
                 System.out.println(jta);
            } 
         
            
       });       
        
            
 });

//____________________________________________________________________
 
 
         

//____________________ActionListener für JButton Anzeigen ___________
          jcb3.addActionListener((ActionEvent e) -> 
          {    
               
            try {
                String Datensatz = zeigeDatensaetze();
                jta.setText(Datensatz);
            } catch (Exception ex) {
                Logger.getLogger(RealTimeCC.class.getName()).log(Level.SEVERE, null, ex);
            }
            
 });
 
//___________________ActionListener für den JButton zum Löschen_____________  
        jcb2.addActionListener((ActionEvent e)-> 
        {
                 String id = jtf0.getText();
                 jtf0.setText(null);
            try {
                loescheDatensatz(id);
            } catch (Exception ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                 
//_________Methodenaufruf für d. Datenbank __________________________
       

//erstelleVerbindung();
//zeigeDatensatz();
//erstelleDatensatz();
//aendereDatensatz();
//loescheDatensatz();
//setText(JTextField jtf1)


        jf.repaint();
        jf.setVisible(true);
        
       
    }
    

    private static void pswGenerieren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static String[] pswGenerieren(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void erstelleDatensatz(String text, String text0, String text1, String text2, String text3, String text4, String[] pwb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
