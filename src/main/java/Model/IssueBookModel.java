package Model;

import Project.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class IssueBookModel {
    private int memberId;
    private int bookId;
    private Date issueDate;
    private Date dueDate;

    public IssueBookModel(int memberId, int bookId, Date issueDate, Date dueDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public boolean saveIssue() {
        try (Connection con = ConnectionProvider.getCon()) {
            String sql = "INSERT INTO issue (member_id, book_id, issue_date, due_date) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, memberId);
            pstmt.setInt(2, bookId);
            pstmt.setDate(3, new java.sql.Date(issueDate.getTime()));
            pstmt.setDate(4, new java.sql.Date(dueDate.getTime()));
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error saving issue: " + e.getMessage());
            return false;
        }
    }
}
