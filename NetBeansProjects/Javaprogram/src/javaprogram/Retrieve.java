
package javaprogram;
import java.sql.*;
import java.io.*;

public class Retrieve {
 
    
   public static void main(String[] args) {  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","Shree@2001");

  
              
PreparedStatement ps=con.prepareStatement("select * from okk");  
ResultSet rs=ps.executeQuery();  
rs.next(); 
              
Clob c=rs.getClob(2);  
Reader r=c.getCharacterStream();              
              
FileWriter fw=new FileWriter("C:\\Users\\Lenovo\\Desktop\\newfile.txt"); 
              
int i;  
while((i=r.read())!=-1)  
fw.write((char)i);  
              
fw.close();  
con.close();  
              
System.out.println("success");  
}catch (Exception e) {e.printStackTrace();  }  
}  
 
    
}
