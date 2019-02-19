/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimecc;

import static java.awt.SystemColor.text;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author dserazin
 */
public class Datenbank 
{
    static Connection verbindung = null;
    static Statement befehl = null;
    static ResultSet ausgabe = null;
        
    
   
       
    
    //Methode zum erstellen einer Verbindung zur DB
    public static Connection erstelleVerbindung() throws Exception
    {
        try
        {
            //Einbinden einer externen config-file um den Treiber für eine Datenbanknutzung brauchbar zu machen
            //Stringvariable mit Verweis
            String treiber = "com.mysql.cj.jdbc.Driver";
            //Aufruf des Treibers innerhalb der Klasse
            Class.forName(treiber);
            //Instanz einer Verbindung über den Treibermanager und Funktion getConnection() mit Vorgabe des DB-Pfades
            Connection verbindung = DriverManager.getConnection("jdbc:mysql://localhost:3306/realtimecc?useSSL=false&serverTimezone=UTC", "root", "");
            //Optionale Ausgabe
            System.out.println("Verbindung zur Datenbank realtimecc erstellt");
            //Verbindung wird geöffnet
            return verbindung; 
            
        }        
        catch(Exception abbruch)
        {
            abbruch.printStackTrace();
        } 
        return null;
    } 
   
    //Methode zum Abrufen der Datensätze aus der DB
    public static String zeigeDatensaetze() throws Exception
    {
        String ausgabe2 = null;
        try
        {  
            
            
            //Erzeugen eines Objektes verbindung aus der Klasse Connection mit Zuweisung der Methode
            //erstelleVerbindung();
            Connection verbindung = erstelleVerbindung();
            
            //Klasseninstanz befehl bekommt Zuweisung des Objektes verbindung und ruft die Funktion
            //createStatement auf --> wird benötigt, um im Folgenden den SQL-Befehl auszuführen
            befehl = verbindung.createStatement();
            
            //Klasseninstanz ausgabe bekommt Zuweisung des Objektes befehl und ruft die Funktion
            //executeQuery auf --> enthält den SQL-Syntax für SELECT FROM aus der Datenbanktabelle
            //mitarbeiter
            ausgabe = befehl.executeQuery("SELECT * FROM mitarbeiter");
            
            //Pro ausgelesenem Datensatz wird eine Zeile erzeugt
            while(ausgabe.next())            
            {   //Ausgabe der gefundenen Datensätze mit Zuordnung der Funktion getInt()/getString() fuehr 
                //die Spalte RealTimeCCID (Datentyp integer)
                //die Spalte RealTimeCCName (Datentyp String)
                ausgabe2 = ausgabe2 + (ausgabe.getInt("ID") + "  " + ausgabe.getString("Name")
                        + " " + ausgabe.getString("Nachname"))+"\r\n";
                
            }
          
            System.out.println("\n" + "\n" + "Datenabfrage erfolgreich abgeschlossen");
            
            //Nachdem alle Datensätze abgerufen wurden, wird die Verbindung zur DB geschlossen
            verbindung.close();
        }
        catch(Exception abbruch)
        {
            //System.out.println(abbruch.getMessage());
            abbruch.printStackTrace();
        }
        
        return ausgabe2;
    } 
    
    
   //Methode um nur einen bestimmten Datensatz anzeigen zu lassen 
     public static String zeigeDatensatz(String jtf1, String jtf2) throws Exception
    {
        String ausgabe2 = null;
        try
        {  
            
            
            //Erzeugen eines Objektes verbindung aus der Klasse Connection mit Zuweisung der Methode
            //erstelleVerbindung();
            Connection verbindung = erstelleVerbindung();
            
            //Klasseninstanz befehl bekommt Zuweisung des Objektes verbindung und ruft die Funktion
            //createStatement auf --> wird benötigt, um im Folgenden den SQL-Befehl auszuführen
            befehl = verbindung.createStatement();
            
            //Klasseninstanz ausgabe bekommt Zuweisung des Objektes befehl und ruft die Funktion
            //executeQuery auf --> enthält den SQL-Syntax für SELECT FROM aus der Datenbanktabelle
            //mitarbeiter
            ausgabe = befehl.executeQuery("SELECT * FROM mitarbeiter");
            
            //Pro ausgelesenem Datensatz wird eine Zeile erzeugt
            while(ausgabe.next())            
            {   //Ausgabe der gefundenen Datensätze mit Zuordnung der Funktion getInt()/getString() fuehr 
                //die Spalte RealTimeCCID (Datentyp integer)
                //die Spalte RealTimeCCName (Datentyp String)
                ausgabe2 = ausgabe2 + (ausgabe.getInt("ID") + "  " + ausgabe.getString("Name")
                        + " " + ausgabe.getString("Nachname"))+"\r\n";
                
            }
          
            System.out.println("\n" + "\n" + "Datenabfrage erfolgreich abgeschlossen");
            
            //Nachdem alle Datensätze abgerufen wurden, wird die Verbindung zur DB geschlossen
            verbindung.close();
        }
        catch(Exception abbruch)
        {
            //System.out.println(abbruch.getMessage());
            abbruch.printStackTrace();
        }
        
        return ausgabe2;
    } 
    
    //Methode zum Erstellen neuer Datensätze in der DB
    public static void erstelleDatensatz(String text,String text0,String text1,
            String text2,String text3, String text4, String benutzername,String pass) throws Exception
    {
     
        
        try
        {   //Erzeugen eines Objektes verbindung aus der Klasse Connection mit Zuweisung der Methode        
            Connection verbindung = erstelleVerbindung();
            
            //Erzeugen eines Objektes erstelleEintrag --> bekommt Zuweisung des Objektes verbindung und ruft die Funktion
            //prepareStatement auf --> wird benötigt, um im Folgenden den SQL-Befehl auszufuehren           
            befehl = verbindung.createStatement();
            
            String sql_insert = "INSERT INTO mitarbeiter(Name,Nachname,Email,Telefonnummer,"
                    + "Position,Standort,Username,Passwort) "
                    + "VALUES('"+text+"','"+text0+"','"+text1+"','"+text2+"','"+text3+"','"+text4+"','"+benutzername+"','"+pass+"')";
            //Objektes erstelleEintrag ruft die Funktion
            //executeUpdate auf --> enthält den SQL-Syntax für INSERT INTO in die Datenbanktabelle
            //RealTimeCCMitarbeiter
            befehl.executeUpdate(sql_insert);
            
            System.out.println("Neuer Datensatz erfolgreich erstellt.");
            
            //Nachdem alle Datensätze abgerufen wurden, wird die Verbindung zur DB geschlossen
            verbindung.close();   
        }
        catch (Exception abbruch)
        {
            abbruch.printStackTrace();
        }
       
    }
    
   
    //Methode zum Löschen vorhandener Datensätze in der DB
    public static void loescheDatensatz(String id) throws Exception
    {
     
        try
        {
            Connection verbindung = erstelleVerbindung();
            befehl = verbindung.createStatement();
            String sql_delete = "DELETE FROM Mitarbeiter WHERE ID = ('"+id+"')";
            befehl.executeUpdate(sql_delete);
            System.out.println("Datensatz mit der ID " +id + " erfolgreich gelöscht.");           
        }
        catch (Exception abbruch)
        {
            abbruch.printStackTrace();
        }
    } 

    static void erstelleDatensatz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}