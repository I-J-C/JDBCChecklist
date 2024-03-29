/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checklist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @authors Jessie Collado, Kaelei Lewis, Shiloh Martin-Adam
 */
public class ListInsertion extends javax.swing.JFrame implements ActionListener {

    private ResultSet rs;
    private final Statement stmt;
    String listtracker;

    /*public String getListtracker() {
        return listtracker;
    }

    public void setListtracker(String listtracker) {
        this.listtracker = listtracker;
    }
    */
    
    //to manage the combo box of list names, use an array:
    //Reference:  https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/
    ArrayList<String> dropbox = new ArrayList<>();

    /**
     * Creates new form ListInsertion
     */
    public ListInsertion(ResultSet rs, Statement stmt) {
        initComponents();
        btnCompleted.addActionListener(this);
        //btnDeleteList.addActionListener(this);
        btnDeleteTask.addActionListener(this);
        btnCreate.addActionListener(this);
        btnAdd.addActionListener(this);
        this.listtracker = Start.jTextField1.getText();  //keeps track of the task lists
        this.rs = rs;
        this.stmt = stmt;
        showResults();
    }
    
    public ListInsertion(ResultSet rs, Statement stmt, String listtracker) {
        initComponents();
        btnCompleted.addActionListener(this);
        //btnDeleteList.addActionListener(this);
        btnDeleteTask.addActionListener(this);
        btnCreate.addActionListener(this);
        btnAdd.addActionListener(this);
        this.listtracker = listtracker;  //keeps track of the task lists
        this.rs = rs;
        this.stmt = stmt;
        showResults();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtTask = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDeleteTask = new javax.swing.JButton();
        btnCompleted = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        lblList = new javax.swing.JLabel();

        setTitle("List Generator");

        btnCreate.setText("Open or Create New List");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter a Task:");

        jLabel2.setText("Enter a Due Date:");

        txtDate.setText("MM-DD-YYYY");

        btnAdd.setText("Add Task");

        btnDeleteTask.setText("Delete");

        btnCompleted.setText("Completed");

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(btnCreate)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                                .addComponent(btnCompleted)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTask)
                            .addComponent(txtDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lblList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDeleteTask)
                    .addComponent(btnCompleted))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblList))
        );

        setSize(new java.awt.Dimension(566, 287));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        openStart();
    }//GEN-LAST:event_btnCreateActionPerformed

    /**
     * @param args the command line arguments
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListInsertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListInsertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListInsertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListInsertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListInsertion().setVisible(true);
            }
        });
    }
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCompleted;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblList;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtTask;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == btnCompleted) {
            completedTask();
        } else if (source == btnAdd) {
            addTask();
        } else if (source == btnDeleteTask) {
            deleteTask();
        }

    }

    public void completedTask() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "Completed?", "", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                int rowtracker = tableData.getSelectedRow();
                //Reference:  move to next row of resultset:  https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
                rs.absolute(rowtracker + 1);
                rs.updateBoolean("completestatus", true);
                rs.updateRow();  //finish the row update
                rs = stmt.executeQuery("select * from todolist where checklistname = '" + listtracker + "'");
                showResults();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void addTask() {
        try {  //use updateString instead of SQL "UPDATE table SET column = newvalue WHERE...";
            rs.moveToInsertRow();  //for a table, start at the beginning of the row
            rs.updateBoolean("completestatus", false);  //start with an incomplete task
            rs.updateString("taskitem", txtTask.getText());  //grab the action item text entered by the user
            rs.updateString("checklistname", listtracker);  //grab the pre-existing list name
            rs.updateString("duedate", txtDate.getText());  //using string instead of date format, then user can use any date format
            rs.insertRow();  //insert the row you just made
            rs = stmt.executeQuery("select * from todolist where checklistname = '" + listtracker + "'");  //show every row on that todolist
            showResults();
            txtTask.setText(""); //reset the task text field to null
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    

    public void deleteTask() {
        try {  //ERROR:  Invalid cursor state, no current row!
            int check = JOptionPane.showConfirmDialog(this, "Delete task?", "", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                int rowtracker = tableData.getSelectedRow();
                //Reference:  move to next row of resultset:  https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
                rs.absolute(rowtracker + 1);
                rs.deleteRow();  //deletes the row with the selected task
                rs.close();  //close the cursor
                rs = stmt.executeQuery("select * from todolist where checklistname = '" + listtracker + "'");
                showResults();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void showResults() {
        try {
            tableData.setModel(new ResultSetTableModel(rs));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    public void openStart() {
        new Start().setVisible(true);
    }
}