/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javamysql_conn;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;



/**
 *
 * @author Lenovo
 */
public class javamysql_conn extends javax.swing.JFrame {

    private static final String username = "root";
    private static final String password = "Shree@2001";
    private static final String dataConn = "jdbc:mysql://localhost:3306/shree";
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    
    public javamysql_conn() {
        initComponents();
    }

  
    
    public void upDateDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("select * from sum");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
                    RecordTable.setRowCount(0);
                    
                    while(rs.next()){
                        Vector columnData = new Vector();
                        
                        for(i = 1; i <= q; i++)
                        {
                            columnData.add(rs.getShort("NAME"));
                            columnData.add(rs.getShort("CITY"));
                            
                            columnData.add(rs.getShort("JOB"));
                            columnData.add(rs.getShort("PASSION"));
                            columnData.add(rs.getShort("ACHIEVEMENTS"));
                            columnData.add(rs.getShort("MOBILE NO"));
                            columnData.add(rs.getShort("EMAIL"));
                            columnData.add(rs.getShort("VISION ON INDIA"));
                            columnData.add(rs.getShort("FEEDBACK"));
                        }
                        RecordTable.addRow(columnData);
                        
                    }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtPASSION = new javax.swing.JTextField();
        jtxtNAME = new javax.swing.JTextField();
        jtxtCITY = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtVISIONONINDIA = new javax.swing.JTextField();
        jtxtJOB = new javax.swing.JTextField();
        jtxtMOBILENO = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtFEEDBACK = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtACHIEVEMENTS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtEMAIL = new javax.swing.JTextField();
        jbtnADDNEW = new javax.swing.JButton();
        jbtnRESET = new javax.swing.JButton();
        jbtnEXIT = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 153), 12, true));
        jPanel1.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255), 10));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel2.setText("VISION ON INDIA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 30));

        jLabel3.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel3.setText("NAME");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 110, 30));

        jtxtPASSION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPASSIONActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtPASSION, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 570, 30));

        jtxtNAME.setText("shree");
        jtxtNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNAMEActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 570, 30));

        jtxtCITY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCITYActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtCITY, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 570, 30));

        jLabel4.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel4.setText("CITY");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 90, 30));

        jLabel5.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel5.setText("JOB");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, 30));

        jLabel6.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel6.setText("PASSION");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, 30));

        jLabel7.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel7.setText("MOBILE NO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 110, 30));
        jPanel2.add(jtxtVISIONONINDIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 570, 30));
        jPanel2.add(jtxtJOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 570, 30));

        jtxtMOBILENO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMOBILENOActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtMOBILENO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 570, 30));

        jLabel8.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel8.setText("FEEDBACK");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 110, 30));
        jPanel2.add(jtxtFEEDBACK, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 570, 50));

        jLabel9.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel9.setText("ACHIEVEMENTS");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));
        jPanel2.add(jtxtACHIEVEMENTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 570, 30));

        jLabel10.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jLabel10.setText("EMAIL");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 110, 40));
        jPanel2.add(jtxtEMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 570, 30));

        jbtnADDNEW.setBackground(new java.awt.Color(255, 102, 102));
        jbtnADDNEW.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jbtnADDNEW.setForeground(new java.awt.Color(51, 51, 51));
        jbtnADDNEW.setText("ADD NEW");
        jbtnADDNEW.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jbtnADDNEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnADDNEWActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnADDNEW, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 230, 40));

        jbtnRESET.setBackground(new java.awt.Color(255, 102, 102));
        jbtnRESET.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jbtnRESET.setForeground(new java.awt.Color(51, 51, 51));
        jbtnRESET.setText("RESET");
        jbtnRESET.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jbtnRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRESETActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnRESET, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 230, 40));

        jbtnEXIT.setBackground(new java.awt.Color(255, 102, 102));
        jbtnEXIT.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jbtnEXIT.setForeground(new java.awt.Color(51, 51, 51));
        jbtnEXIT.setText("EXIT");
        jbtnEXIT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jbtnEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEXITActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnEXIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 180, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 930, 570));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setForeground(new java.awt.Color(204, 51, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 910, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 910, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 900, -1));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 890, -1));

        jPanel9.setBackground(new java.awt.Color(0, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setBackground(new java.awt.Color(102, 204, 255));
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("SURVEY FORM");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 910, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -40, 970, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private JFrame frame;
    private void jbtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEXITActionPerformed
        // TODO add your handling code here:
        frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "MySQL Connector",
              JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            System.exit(0);
            
        }
    }//GEN-LAST:event_jbtnEXITActionPerformed

    private void jbtnRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRESETActionPerformed
       jtxtNAME.setText("");
       jtxtCITY.setText("");
       
       
       jtxtJOB.setText("");
        jtxtPASSION.setText("");
          jtxtACHIEVEMENTS.setText("");
          jtxtMOBILENO.setText("");
           jtxtEMAIL.setText("");
            jtxtVISIONONINDIA.setText("");
             jtxtFEEDBACK.setText("");
    }//GEN-LAST:event_jbtnRESETActionPerformed

    private void jtxtCITYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCITYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCITYActionPerformed

    private void jtxtPASSIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPASSIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPASSIONActionPerformed

    private void jtxtMOBILENOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMOBILENOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMOBILENOActionPerformed

    private void jbtnADDNEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnADDNEWActionPerformed
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("insert into sum values(?,?,?,?,?,?,?,?,?)"); 
            
            pst.setString(1, jtxtNAME.getText());
            pst.setString(2, jtxtCITY.getText());
            
            pst.setString(3, jtxtJOB.getText());
            pst.setString(4, jtxtPASSION.getText());
            pst.setString(5, jtxtACHIEVEMENTS.getText());
            pst.setString(6, jtxtMOBILENO.getText());
            pst.setString(7, jtxtEMAIL.getText());
            pst.setString(8, jtxtVISIONONINDIA.getText());
            pst.setString(9, jtxtFEEDBACK.getText());
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added");
            upDateDB();
        }        
       
        catch (ClassNotFoundException ex){
            
            java.util.logging.Logger.getLogger(javamysql_conn.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(javamysql_conn.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        
        
    }//GEN-LAST:event_jbtnADDNEWActionPerformed

    private void jtxtNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNAMEActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(javamysql_conn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(javamysql_conn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(javamysql_conn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(javamysql_conn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new javamysql_conn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbtnADDNEW;
    private javax.swing.JButton jbtnEXIT;
    private javax.swing.JButton jbtnRESET;
    private javax.swing.JTextField jtxtACHIEVEMENTS;
    private javax.swing.JTextField jtxtCITY;
    private javax.swing.JTextField jtxtEMAIL;
    private javax.swing.JTextField jtxtFEEDBACK;
    private javax.swing.JTextField jtxtJOB;
    private javax.swing.JTextField jtxtMOBILENO;
    private javax.swing.JTextField jtxtNAME;
    private javax.swing.JTextField jtxtPASSION;
    private javax.swing.JTextField jtxtVISIONONINDIA;
    // End of variables declaration//GEN-END:variables
}
