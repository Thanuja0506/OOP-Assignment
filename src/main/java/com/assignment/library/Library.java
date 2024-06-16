/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.assignment.library;

import View.Login;

/**
 *
 * @author ASUS
 */
public class Library {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }
}
