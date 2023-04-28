
package javasql;
import java.sql.*;
import java.io.*;



public class insertimage {
     public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shreema","root","Shree@2001");
               PreparedStatement ps=con.prepareStatement("insert into imagetable VALUES(?,?)");
               ps.setString(1, "SShrima");
        
        FileInputStream fin=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\srs.png");
        ps.setBinaryStream(2, fin,fin.available());
        int i=ps.executeUpdate();
        System.out.println(i + "records affected");
        
        con.close();
        
        } catch (Exception e){
            e.printStackTrace();
        }
        
        }
    
}
