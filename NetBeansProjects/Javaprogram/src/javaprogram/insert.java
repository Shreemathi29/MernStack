/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaprogram;
import java.io.*;
import java.sql.*;


/**
 *
 * @author Lenovo
 */
public class insert {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shreema","root","Shree@2001");
             
             PreparedStatement ps=con.prepareStatement("select * from imagetable");
             ResultSet rs=ps.executeQuery();
             if(rs.next()){
                 
                 Blob b=rs.getBlob(2);
                 byte barr[]=b.getBytes(1,(int)b.length());                                                     
              
FileOutputStream fout=new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\s1.png"); 
fout.write(barr);  
              
fout.close();  
             }
             System.out.println("ok");  
              
con.close();  
        }
        
        catch (Exception e) {
                e.printStackTrace();
                }  
    }
    
}
