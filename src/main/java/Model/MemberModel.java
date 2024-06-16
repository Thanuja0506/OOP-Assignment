/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Project.ConnectionProvider;

public class MemberModel {
    
    public boolean checkMemberIdExistence(String memberId) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM member WHERE memberId = '" + memberId + "'");
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Member ID exists
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return false; 
    }
    
    public boolean insertMember(String memberId, String name, String email, String category, String faculty) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO member VALUES ('" + memberId + "', '" + name + "', '" + email + "', '" + category + "', '" + faculty + "')");
            return true; // Insert successful
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return false; // Insert failed
    }
    
    public DefaultTableModel getMembersTableModel() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Member ID", "Name", "Email", "Category", "Faculty"}, 0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM member");
            while (rs.next()) {
                String memberId = rs.getString("memberId");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String category = rs.getString("category");
                String faculty = rs.getString("faculty");
                model.addRow(new Object[]{memberId, name, email, category, faculty});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return model;
    }
    
    public DefaultTableModel searchMembers(String memberId) {
    DefaultTableModel model = new DefaultTableModel(new String[]{"Member ID", "Name", "Email", "Category", "Faculty"}, 0);
    try {
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM member WHERE memberId LIKE '%" + memberId + "%'");
        while (rs.next()) {
            String memberIdFound = rs.getString("memberId");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String category = rs.getString("category");
            String faculty = rs.getString("faculty");
            model.addRow(new Object[]{memberIdFound, name, email, category, faculty});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    return model;
}
    
    
    public boolean deleteMember(String memberId) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            int result = st.executeUpdate("DELETE FROM member WHERE memberId = '" + memberId + "'");
            if (result > 0) {
                return true; // Deletion successful
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return false; // Deletion failed
    }
    
}
