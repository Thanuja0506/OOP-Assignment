/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */


import Project.ConnectionProvider; // Update the import to the correct package
import Model.IssueBookModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class IssueBookController {

    public boolean issueBook(int memberId, int bookId, Date issueDate, Date dueDate) {
        IssueBookModel issue = new IssueBookModel(memberId, bookId, issueDate, dueDate);
        return issue.saveIssue();
    }

    public boolean checkMemberExists(int memberId) {
        try (Connection con = ConnectionProvider.getCon()) {
            String sql = "SELECT * FROM member WHERE memberID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, memberId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error checking member: " + e.getMessage());
            return false;
        }
    }

    public boolean checkBookExists(int bookId) {
        try (Connection con = ConnectionProvider.getCon()) {
            String sql = "SELECT * FROM books WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error checking book: " + e.getMessage());
            return false;
        }
    }
}
