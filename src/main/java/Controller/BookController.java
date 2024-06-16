/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */

import View.BookView;
import Model.BookModel;
import Project.ConnectionProvider;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookController {
    private BookView view;

    public BookController(BookView view) {
        this.view = view;
        addListeners();
        loadTableData();
    }

    private void addListeners() {
        view.addCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createBook();
            }
        });

        view.addUpdateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBook();
            }
        });

        view.addDeleteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });

        view.addSearchListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });
    }

    private void createBook() {
        String id = view.getBookIdField().getText();
        String name = view.getBookNameField().getText();
        String author = view.getAuthorField().getText();
        String category = (String) view.getCategoryField().getSelectedItem();
        int quantity = Integer.parseInt(view.getQuantityField().getText());
        double price = Double.parseDouble(view.getPriceField().getText());

        try (Connection con = ConnectionProvider.getCon();
             PreparedStatement pst = con.prepareStatement("INSERT INTO books (id, name, author, category, quantity, price) VALUES (?, ?, ?, ?, ?, ?)")) {
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, author);
            pst.setString(4, category);
            pst.setInt(5, quantity);
            pst.setDouble(6, price);
            pst.executeUpdate();
            view.showMessage("Book added successfully");
            loadTableData();
        } catch (SQLException ex) {
            view.showMessage("Error: " + ex.getMessage());
        }
    }

    private void updateBook() {
        String id = view.getBookIdField().getText();
        String name = view.getBookNameField().getText();
        String author = view.getAuthorField().getText();
        String category = (String) view.getCategoryField().getSelectedItem();
        int quantity = Integer.parseInt(view.getQuantityField().getText());
        double price = Double.parseDouble(view.getPriceField().getText());

        try (Connection con = ConnectionProvider.getCon();
             PreparedStatement pst = con.prepareStatement("UPDATE books SET name=?, author=?, category=?, quantity=?, price=? WHERE id=?")) {
            pst.setString(1, name);
            pst.setString(2, author);
            pst.setString(3, category);
            pst.setInt(4, quantity);
            pst.setDouble(5, price);
            pst.setString(6, id);
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                view.showMessage("Book updated successfully");
                loadTableData();
            } else {
                view.showMessage("Book ID not found");
            }
        } catch (SQLException ex) {
            view.showMessage("Error: " + ex.getMessage());
        }
    }

    private void deleteBook() {
        String id = view.getBookIdField().getText();

        try (Connection con = ConnectionProvider.getCon();
             PreparedStatement pst = con.prepareStatement("DELETE FROM books WHERE id=?")) {
            pst.setString(1, id);
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                view.showMessage("Book deleted successfully");
                loadTableData();
            } else {
                view.showMessage("Book ID not found");
            }
        } catch (SQLException ex) {
            view.showMessage("Error: " + ex.getMessage());
        }
    }

    private void searchBook() {
        String id = view.getSearchField().getText();

        try (Connection con = ConnectionProvider.getCon();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM books WHERE id=?")) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Book ID");
                model.addColumn("Book Name");
                model.addColumn("Author");
                model.addColumn("Category");
                model.addColumn("Quantity");
                model.addColumn("Price");

                if (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("author"),
                            rs.getString("category"),
                            rs.getInt("quantity"),
                            rs.getDouble("price")
                    });
                    view.setTableData(model);
                } else {
                    view.showMessage("Book ID not found");
                }
            }
        } catch (SQLException e) {
        view.showMessage("Error: " + e.getMessage());
    }
}
    
    
    public void loadTableData() {
    try (Connection con = ConnectionProvider.getCon();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Book ID");
        model.addColumn("Book Name");
        model.addColumn("Author");
        model.addColumn("Category");
        model.addColumn("Quantity");
        model.addColumn("Price");

        while (rs.next()) {
            model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("author"),
                    rs.getString("category"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
            });
        }

        // Assuming `view` is an instance of BookView
        view.setTableData(model);

    } catch (SQLException ex) {
        ex.printStackTrace(); // Handle exception appropriately
    }
}

}

