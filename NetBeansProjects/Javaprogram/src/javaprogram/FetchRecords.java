/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaprogram;

import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class FetchRecords {
        
    public static void main(String args[])throws Exception{  
        
        Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssh","root","Shree@2001");


con.setAutoCommit(false);  
  
Statement stmt=con.createStatement();  
stmt.addBatch("insert into ssm values(131,'shru',40000)");  
stmt.addBatch("insert into ssm values(123,'swe',50000)");  
stmt.addBatch("insert into ssm values(145,'indhu',40000)");  
stmt.addBatch("insert into ssm values(331,'ishu',50000)");  
stmt.addBatch("insert into ssm values(108,'venkat',40000)");  
stmt.addBatch("insert into ssm values(231,'sonu',50000)");
stmt.addBatch("insert into ssm values(151,'naveen',40000)");  
stmt.addBatch("insert into ssm values(171,'afreen',50000)");  

  
stmt.executeBatch();//executing the batch  
  
con.commit();  
con.close();  
}
    
    
}
