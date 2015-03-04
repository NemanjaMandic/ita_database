

package ita_baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbBrokerMain {
    
    public static void main(String[] args){
        try{
            ArrayList<String[]> allUsers = DbBroker.getArray("select * from users");
            for(String[] usr : allUsers)
                System.out.println("User ID: " + usr[0] + " Email: " + usr[1] + " Password: " + usr[2]);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    }

