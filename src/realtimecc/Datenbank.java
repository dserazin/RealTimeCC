/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimecc;

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
    public static void zeigeDatensatz() throws Exception
    {
        try
        {   //Erzeugen eines Objektes verbindung aus der Klasse Connection mit Zuweisung der Methode
            //erstelleVerbindung();
            Connection verbindung = erstelleVerbindung();
            
            //Klasseninstanz befehl bekommt Zuweisung des Objektes verbindung und ruft die Funktion
            //createStatement auf --> wird benötigt, um im Folgenden den SQL-Befehl auszuführen
            befehl = verbindung.createStatement();
            
            //Klasseninstanz ausgabe bekommt Zuweisung des Objektes befehl und ruft die Funktion
            //executeQuery auf --> enthält den SQL-Syntax für SELECT FROM aus der Datenbanktabelle
            //imperiummitglied
            ausgabe = befehl.executeQuery("SELECT * FROM imperiummitglied");
            
            //Pro ausgelesenem Datensatz wird eine Zeile erzeugt
            while(ausgabe.next())            
            {   //Ausgabe der gefundenen Datensätze mit Zuordnung der Funktion getInt()/getString() fÃ¼r 
                //die Spalte ImperiumID (Datentyp integer)
                //die Spalte ImperiumName (Datentyp String)
                System.out.println("\n" + ausgabe.getInt("ImperiumID") + "  " + ausgabe.getString("ImperiumName"));
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
    } 
    
    //Methode zum Erstellen neuer Datensätze in der DB
    public static void erstelleDatensatz(String text,String text0,String text1,String text2,String text3, String text4) throws Exception
    {
     
        
        try
        {   //Erzeugen eines Objektes verbindung aus der Klasse Connection mit Zuweisung der Methode        
            Connection verbindung = erstelleVerbindung();
            
            //Erzeugen eines Objektes erstelleEintrag --> bekommt Zuweisung des Objektes verbindung und ruft die Funktion
            //prepareStatement auf --> wird benötigt, um im Folgenden den SQL-Befehl auszufÃ¼hren           
            befehl = verbindung.createStatement();
            
            String sql_insert = "INSERT INTO mitarbeiter(Name,Nachname,Email,Telefonnummer,"
                    + "Position,Standort) "
                    + "VALUES('"+text+"','"+text0+"','"+text1+"','"+text2+"','"+text3+"','"+text4+"')";
            //Objektes erstelleEintrag ruft die Funktion
            //executeUpdate auf --> enthält den SQL-Syntax für INSERT INTO in die Datenbanktabelle
            //imperiummitglied
            befehl.executeUpdate(sql_insert);
            
            System.out.println("neuer Datensatz erfolgreich erstellt.");
            
            //Nachdem alle Datensätze abgerufen wurden, wird die Verbindung zur DB geschlossen
            verbindung.close();   
        }
        catch (Exception abbruch)
        {
            abbruch.printStackTrace();
        }
        
    }
    
    //Methode zum Anpassen vorhandener Datensätze in der DB
    public static void aendereDatensatz() throws Exception
    {
        final String nameneu = JOptionPane.showInputDialog("Geben Sie für den bestehenden Datensatz den neuen Wert für Name ein");
        final String id = JOptionPane.showInputDialog("Geben Sie die ImperiumID des zu ändernden Datensatzes ein");
        
        try
        {
            Connection verbindung = erstelleVerbindung();
            befehl = verbindung.createStatement();
            String sql_change = "UPDATE imperiummitglied SET ImperiumName =  ('" +nameneu+ "') WHERE  ImperiumID = ('"+id+"')";          
            befehl.executeUpdate(sql_change);
            System.out.println("Datensatz mit der ImperiumID " + id + " erfolgreich geändert.");
           
        }
        catch (Exception abbruch)
        {
            abbruch.printStackTrace();
        }
    }   
    
    //Methode zum Löschen vorhandener Datensätze in der DB
    public static void loescheDatensatz() throws Exception
    {
        //final String ID = JOptionPane.showInputDialog("Geben Sie die ID des Datensatzes ein, der gelöscht werden soll");
        final String id = JOptionPane.showInputDialog("Geben Sie die ImperiumID des zu löschenden Datensatzes ein");
        
        try
        {
            Connection verbindung = erstelleVerbindung();
            befehl = verbindung.createStatement();
            String sql_delete = "DELETE FROM imperiummitglied WHERE ImperiumID = ('"+id+"')";
            befehl.executeUpdate(sql_delete);
            System.out.println("Datensatz mit der ImperiumID " +id + " erfolgreich gelöscht.");           
        }
        catch (Exception abbruch)
        {
            abbruch.printStackTrace();
        }
    } 
    
    public static void erstelleTabelle() throws Exception
    {
        final String tblname = JOptionPane.showInputDialog("Geben Sie den Namen für die neue Datenbanktabelle ein");
        final String ID = JOptionPane.showInputDialog("Geben Sie den Namen für die erste Spalte(ID) ein");
        final String spaltenname = JOptionPane.showInputDialog("Geben Sie den Namen für die erste Spalte(ID) ein");
        try
        {
            String sql = "CREATE TABLE " + tblname +
                   "( " + ID + " INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY (" +  ID  + " ))"; 
            Connection verbindung = erstelleVerbindung();          
            PreparedStatement erstelleTabelle = verbindung.prepareStatement(sql);
            erstelleTabelle.executeUpdate();
            System.out.println("neue Datenbanktabelle erfolgreich erstellt.");                                  
        }
        catch (Exception abbruch)
        {
            System.out.println(abbruch.getMessage());
        }
    }   

    
}