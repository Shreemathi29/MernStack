
package javaapplication1;
import java.sql.*;


public class JavaApplication1 {
    
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shr","root","Shree@2001");
        Statement st=con.createStatement();
        st.executeUpdate("INSERT INTO ishu VALUES ('shree','shree@gmail.com','2319')");
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        
        
        
        
    }
    
}
