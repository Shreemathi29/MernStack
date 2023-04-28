
package javaprogram;

import java.sql.*;
import java.io.*;


public class Retrievefile {
    
    public static void main(String[] args) {  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shr","root","Shree@2001");
              
PreparedStatement ps=con.prepareStatement(  
"insert into shell values(?,?)");  
              
File f=new File("C:\\Users\\Lenovo\\Desktop\\newfolder\\tony6.txt"); 
FileReader fr=new FileReader(f);  
              
ps.setInt(1,101);  
ps.setCharacterStream(2,fr,(int)f.length());  
int i=ps.executeUpdate();  
System.out.println(i+" records affected");  
              
con.close();  
              
}catch (Exception e) {e.printStackTrace();}  
}  
    
    
    
}
