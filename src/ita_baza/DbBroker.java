
package ita_baza;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;


public class DbBroker {
  
    ////// DATABASE TEST, TABLE USERS - USER_ID, EMAIL, PASSWORD COLUMNS
   static Connection con = null;
   
   static void connect() throws SQLException{
       con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
   }
   static String getString(String stt) throws SQLException{
       connect();
       Statement st = con.createStatement();
       st.executeUpdate(stt);
       ResultSet rs = st.getResultSet();
       rs.next();
       String rez = rs.getString(1);
       close();
       return rez;
   }
   static int getInt(String stt) throws SQLException{
       connect();
       Statement st = con.createStatement();
       st.executeQuery(stt);
       ResultSet rs = st.getResultSet();
       rs.next();
       int rez = rs.getInt(1);
       close();
       return rez;
   }
   static boolean query(String q) throws SQLException{
       connect();
       Statement st = con.createStatement();
       boolean rez = st.execute(q);
       close();
       return rez;
   }
   static ArrayList<String[]> getArray(String stt) throws SQLException{
       connect();
       Statement st = con.createStatement();
       st.executeQuery(stt);
       
       ResultSet rs = st.getResultSet();
       int columnsNum = rs.getMetaData().getColumnCount();
       ArrayList<String[]> rez = new ArrayList<>();
       
       while(rs.next()){
           String[] rowArr = new String[columnsNum];
           for(int i=0; i<columnsNum; i++)
               rowArr[i] = rs.getString(i+1).toString();
           rez.add(rowArr);
       }
       close();
       return rez;
   }
   static void close() throws SQLException{
       con.close();
   }
}
