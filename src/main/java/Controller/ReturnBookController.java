/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */


import Project.ConnectionProvider;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Controller for handling the return book logic
 */
public class ReturnBookController {

    /**
     * Method to retrieve issue date and due date of a book issued to a member
     *
     * @param memberId the member ID
     * @param bookId   the book ID
     * @return an array of Dates containing issue date and due date, or null if not found
     */
    public Object[] getIssueDueAndReturnStatus(String memberId, String bookId) {
    try (Connection con = ConnectionProvider.getCon();
         PreparedStatement pst = con.prepareStatement("SELECT issue_date, due_date, returnStatus FROM issue WHERE member_id = ? AND book_id = ?")) {
        pst.setString(1, memberId);
        pst.setString(2, bookId);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                Date issueDate = rs.getDate("issue_date");
                Date dueDate = rs.getDate("due_date");
                String returnStatus = rs.getString("returnStatus");
                return new Object[]{issueDate, dueDate, returnStatus};
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    return null;
}


    /**
     * Method to handle returning a book by updating return status and return date
     *
     * @param memberId     the member ID
     * @param bookId       the book ID
     * @param returnStatus the return status
     * @return true if the book return was successful, false otherwise
     */
   public boolean returnBook(String memberId, String bookId) {
    try (Connection con = ConnectionProvider.getCon();
         PreparedStatement pst = con.prepareStatement("UPDATE issue SET returnStatus = ?, return_date = ? WHERE member_id = ? AND book_id = ?")) {
        pst.setString(1, "1"); // Set return status to "Returned"
        pst.setDate(2, new java.sql.Date(new Date().getTime())); // Set return date
        pst.setString(3, memberId);
        pst.setString(4, bookId);
        int affectedRows = pst.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    return false;
}

}
