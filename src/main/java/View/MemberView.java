/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.*;
import Project.ConnectionProvider;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener; 
import Model.MemberModel;

/**
 *
 * @author ASUS
 */
public class MemberView extends javax.swing.JFrame {

    /**
     * Creates new form Member
     */
    public MemberView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memberLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        namefield = new javax.swing.JTextField();
        memberIdfield = new javax.swing.JTextField();
        emailfield = new javax.swing.JTextField();
        categoryfield = new javax.swing.JComboBox<>();
        facultyfield = new javax.swing.JComboBox<>();
        create = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usersList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 150));
        setMinimumSize(new java.awt.Dimension(1001, 544));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        memberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        memberLabel.setText("Member ID");
        getContentPane().add(memberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 95, -1));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setText("Name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 95, -1));

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emailLabel.setText("email");
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 95, -1));

        categoryLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        categoryLabel.setText("Category");
        getContentPane().add(categoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 95, -1));

        facultyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        facultyLabel.setText("Faculty");
        getContentPane().add(facultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 95, -1));

        namefield.setPreferredSize(new java.awt.Dimension(100, 20));
        getContentPane().add(namefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 325, 39));

        memberIdfield.setPreferredSize(new java.awt.Dimension(100, 20));
        getContentPane().add(memberIdfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 325, 39));

        emailfield.setPreferredSize(new java.awt.Dimension(100, 20));
        getContentPane().add(emailfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 325, 39));

        categoryfield.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Undergraduate", "Lecturer-Academic Staff", "Non Academic Staff", "Labours" }));
        getContentPane().add(categoryfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 325, 40));

        facultyfield.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Faculty of Medicine", "Faculty of Engineer", "Faculty of Information Technology", "Faculty of Management", "Faculty of Science" }));
        getContentPane().add(facultyfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 325, 40));

        create.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        create.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        create.setText("Create");
        create.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        getContentPane().add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 125, 35));

        cancel.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancel.setText("Cancel");
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 135, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Create Members");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 270, -1));

        usersList.setText("Members List");
        usersList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersListActionPerformed(evt);
            }
        });
        getContentPane().add(usersList, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        // TODO add your handling code here:

        
    String memberId = getMemberId();
    String name = getName();
    String email = getEmail();
    String category = getCategory();
    String faculty = getFaculty();

    // Validate input (e.g., not empty fields)
    if (memberId.isEmpty() || name.isEmpty() || email.isEmpty()) {
        showMessage("Please fill all fields");
        return;
    }

    // Create instance of MemberModel
    MemberModel model = new MemberModel();

    // Check if member ID already exists
    if (model.checkMemberIdExistence(memberId)) {
        showMessage("Member ID already exists");
    } else {
        // Attempt to insert member
        if (model.insertMember(memberId, name, email, category, faculty)) {
            showMessage("Member created successfully");
            clearFields();
        } else {
            showMessage("Failed to create member");
        }
    }
    }//GEN-LAST:event_createActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
         setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void usersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersListActionPerformed
        // TODO add your handling code here:
        
        new MemberList().setVisible(true);
    }//GEN-LAST:event_usersListActionPerformed


    
     public String getMemberId() {
        return memberIdfield.getText();
    }
    
    public String getName() {
        return namefield.getText();
    }
    
    public String getEmail() {
        return emailfield.getText();
    }
    
    public String getCategory() {
        return (String) categoryfield.getSelectedItem();
    }
    
    public String getFaculty() {
        return (String) facultyfield.getSelectedItem();
    }
    
    
    
     
    public void addCreateButtonListener(ActionListener listener) {
        create.addActionListener(listener);
    }
    
    public void addCancelButtonListener(ActionListener listener) {
        cancel.addActionListener(listener);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public void clearFields() {
        memberIdfield.setText("");
        namefield.setText("");
        emailfield.setText("");
        categoryfield.setSelectedIndex(0);
        facultyfield.setSelectedIndex(0);
    }
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               new MemberView().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JComboBox<String> categoryfield;
    private javax.swing.JButton create;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailfield;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JComboBox<String> facultyfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField memberIdfield;
    private javax.swing.JLabel memberLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField namefield;
    private javax.swing.JButton usersList;
    // End of variables declaration//GEN-END:variables
}
