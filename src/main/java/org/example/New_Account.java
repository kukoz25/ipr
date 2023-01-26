package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class New_Account extends JFrame{
    private JPanel panel;
    private JTextField login;
    private JTextField imienazwisko;
    private JTextField mail;
    private JPasswordField haslo;
    private JButton zaloz;
    private JButton anulujButton;

    New_Account()
    {
        this.setContentPane(this.panel);
        this.setTitle("Załóż konto");
        this.setSize(270, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        zaloz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ListaUzytkownikow.dodajuzytkownia(imienazwisko.getText(),login.getText(),mail.getText(),new String(haslo.getPassword()));
                New_Account.super.setVisible(false);
            }
        });
    }
}
