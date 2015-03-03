package ita_baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ITA_Baza {

    public static void main(String[] args) throws SQLException {

        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ita_baza", "nemanja", "nemanja123");) {

            /*
            
            Statement stInsert = conn.createStatement();

            stInsert.execute("insert into users (username,password) values ('myUserName','myPassword')");

            Statement stFetch = conn.createStatement();

            ResultSet rs = stFetch.executeQuery("select * from users");

            while (rs.next()) {

                System.out.println("User:");

                System.out.println("Username: " + rs.getString("username"));

                System.out.println("Password: " + rs.getString("password"));

                System.out.println("\n");

            } */

            ///// PreparedStatement ///////////////
            String sql = "insert into users(username,password) values(?,?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("username1", "password1");
                hm.put("username2", "password2");

                for (Entry<String, String> entry : hm.entrySet()) {
                    ps.setString(1, entry.getKey());
                    ps.setString(2, entry.getKey());
                    ps.executeUpdate();
                }
            }

            Statement stFetch = con.createStatement();
            String sqli = "select * from users";
            ResultSet rs = stFetch.executeQuery(sqli);
            while (rs.next()) {

                System.out.println("User: ");
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("\n");

            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
