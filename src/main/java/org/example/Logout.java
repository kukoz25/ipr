package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logout extends JFrame {
    private JButton wylogujButton;
    private JButton anulujButton;
    private JPanel panel;

    public Logout() {
        this.setContentPane(this.panel);
        this.setTitle("Potwierdź wylogowanie");
        this.setSize(240, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
Logout.super.setVisible(false);
Login l=new Login();
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logout.super.setVisible(false);
                Main_menu m = new Main_menu();
            }
        });
    }
}
