
package javasql;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class read {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shr","root","Shree@2001");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("SELECT * FROM ishu");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getString( 2)+" "+rs.getString(3));
            }
    
       }
        catch(Exception e)
        {
            System.out.println();
        }
    }
    
    
}
