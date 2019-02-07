/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimecc;

import java.security.SecureRandom;
import javafx.beans.binding.Bindings;

/**
 *
 * @author dserazin
 */
public class PasswortCreate 
{
   
    
    final String allowedChars = null;
    SecureRandom random = new SecureRandom();
    StringBuilder pass;
    private int length;

    public PasswortCreate(String jtf1, String jtf2) 
    {
        this.pass = new StringBuilder(length);
        for (int i = 0; i < length; i++) 
        {
            pass.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
            System.out.println(pass);
        }
  
    }
}