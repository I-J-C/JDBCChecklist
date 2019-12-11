/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checklist;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.apache.derby.jdbc.*;

/**
 *
 * @authors Jessie Collado, Kaelei Lewis, Shiloh Martin-Adam
 */
public final class Start extends javax.swing.JFrame {
    private Connection conn;  //first four lines are for the database
    private ResultSet rs;
    private Statement stmt;
    private final String dbConn = "jdbc:derby:contact;create=true";  //private final String
    ArrayList<String> dropbox = new ArrayList<>();
    String listtracker;


    /**
     * Creates new form Start
     */
    public Start() {
        initComponents();
        setDBDirectory();
        createTable();
        getResultSet();
        manageComboBox();
        
    }
    private void setDBDirectory() {
        //Decide on the database location
        String userHomeDir = System.getProperty("user.home", ".");
        String systemDir = userHomeDir + "/checklist";
        //set the db system property
        System.setProperty("derby.system.home", systemDir);
    }
    
        private void createTable() {
        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            conn = DriverManager.getConnection(dbConn);
            String sql = "create table todolist (completestatus boolean default false, taskitem varchar(200), checklistname varchar(50) not null, duedate varchar(20))";
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            if (e.getErrorCode() != 30000) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreateList = new javax.swing.JButton();
        btnEditList = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("List Manager");

        btnCreateList.setText("Create List");
        btnCreateList.setToolTipText("");
        btnCreateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateListActionPerformed(evt);
            }
        });

        btnEditList.setText("Edit List");
        btnEditList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditListActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pick a list to add to or edit"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete List");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("New List:");

        jLabel2.setText("Existing List:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(397, 397, 397))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditList)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete)
                    .addComponent(btnEditList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateList))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(575, 182));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditListActionPerformed
        try {
            listtracker = (String) jComboBox1.getSelectedItem();
            rs = stmt.executeQuery("select * from todolist where checklistname = '" + listtracker + "'");      
            new ListInsertion(rs, stmt, listtracker).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditListActionPerformed

    private void btnCreateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateListActionPerformed
        try {
            listtracker = jTextField1.getText();
            //new ListInsertion().setListtracker(listtracker);
            rs = stmt.executeQuery("select * from todolist where checklistname = '" + listtracker + "'");
            jComboBox1.addItem(listtracker);
            jComboBox1.setSelectedItem(listtracker);
            new ListInsertion(rs, stmt).setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnCreateListActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            listtracker = (String) jComboBox1.getSelectedItem();
            rs = stmt.executeQuery("select * from todolist where checklistname = '" + listtracker + "'");  //this is the SQL query
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int check = JOptionPane.showConfirmDialog(this, "Delete your list?", "", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                String listNow = (String) jComboBox1.getSelectedItem();
                rs = stmt.executeQuery("select * from todolist where checklistname = '" + listtracker + "'");  //the SQL query to get the list names
                rs.beforeFirst();  //start at the beginning (we're not inserting, so NOT using movetoinsertrow())
                while (rs.next()) {  //move the cursor forward
                    rs.deleteRow();  //delete the selected list
                }
                jComboBox1.removeItem(listNow);  //Reference:  https://www.w3schools.com/jsref/met_storage_removeitem.asp
                jComboBox1.setSelectedIndex(0);  //Reference:  https://stackoverflow.com/questions/12048864/resetting-the-value-of-a-jcombobox/17871043
                rs.close();  //Reference:  https://stackoverflow.com/questions/4507440/must-jdbc-resultsets-and-statements-be-closed-separately-although-the-connection
                rs = stmt.executeQuery("select * from todolist where checklistname = '" + listtracker + "'");  //query the updated list
                }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateList;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditList;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables



public void deleteList() {
        //Reference material:  https://www.mkyong.com/swing/java-swing-how-to-make-a-confirmation-dialog/
        try {
            int check = JOptionPane.showConfirmDialog(this, "Delete your list?", "", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                String listNow = (String) jComboBox1.getSelectedItem();
                rs = stmt.executeQuery("select * from todolist where checklistname = '" + listNow + "'");  //the SQL query to get the list names
                rs.beforeFirst();  //start at the beginning (we're not inserting, so NOT using movetoinsertrow())
                while (rs.next()) {  //move the cursor forward
                    rs.deleteRow();  //delete the selected list
                }
                jComboBox1.removeItem(listNow);  //Reference:  https://www.w3schools.com/jsref/met_storage_removeitem.asp
                jComboBox1.setSelectedIndex(0);  //Reference:  https://stackoverflow.com/questions/12048864/resetting-the-value-of-a-jcombobox/17871043
                rs.close();  //Reference:  https://stackoverflow.com/questions/4507440/must-jdbc-resultsets-and-statements-be-closed-separately-although-the-connection
                }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

public void getResultSet() {
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  //able to make changes
            rs = stmt.executeQuery("select * from todolist");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
}
    
//  Reference:  https://stackoverflow.com/questions/1291704/how-do-i-populate-a-jcombobox-with-an-arraylist
    private void manageComboBox() {  //since we're controlling jComboBox1 with a ArrayList, need to set combobox initial state
        try {
            //dropbox.add("Pick a list to edit");
            while (rs.next()) {  //while theres any more list names in the list...
                dropbox.add(rs.getString("checklistname"));  //get the next name on the list
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        //Reference for setmodel:  https://stackoverflow.com/questions/3926543/jcomboboxes-using-setmodel-to-access-objects-in-swing
        Set unique  = new HashSet(dropbox); //now unique
        jComboBox1.setModel(new DefaultComboBoxModel(unique.toArray()));
        //to have jComboBox show the list of list names, select jComboBox1, under properties select model, 
        //custom code, then new javax.swing.DefaultComboBoxModel
    }
}


  
