/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */

import Model.MemberModel;
import View.MemberView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberController {
    
    private MemberView view;
    private MemberModel model;
    
    public MemberController(MemberView view, MemberModel model) {
        this.view = view;
        this.model = model;
        
        // Attach action listeners to view components
        this.view.addCreateButtonListener(new CreateButtonListener());
        this.view.addCancelButtonListener(new CancelButtonListener());
    }
    
    class CreateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String memberId = view.getMemberId();
            String name = view.getName();
            String email = view.getEmail();
            String category = view.getCategory();
            String faculty = view.getFaculty();
            
            if (model.checkMemberIdExistence(memberId)) {
                view.showMessage("Member ID already exists");
            } else {
                if (model.insertMember(memberId, name, email, category, faculty)) {
                    view.showMessage("Member created successfully");
                    view.setVisible(false);
                    view.clearFields();
                } else {
                    view.showMessage("Error creating member");
                }
            }
        }
    }
    
    class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
        }
    }
}
