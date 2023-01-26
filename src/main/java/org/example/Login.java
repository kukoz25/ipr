package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel panel;
    private JTextField loginField1;
    private JPasswordField passwordField1;
    private JButton niePamietamHaslaButton;
    private JButton zalozKontoButton;
    private JButton zalogujButton;

    public Login() {
        this.setContentPane(this.panel);
        this.setTitle("Logowanie");
        this.setSize(270, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        zalogujButton.addActionListener(new ActionListener() {
            @Override
public void actionPerformed(ActionEvent e) {
                Login.super.setVisible(false);
Weryfikuj.werifikuj(loginField1.getText()+';'+new String(passwordField1.getPassword()));
            }
        });
        niePamietamHaslaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password_change p= new password_change();
            }
        });
        zalozKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.super.setVisible(false);
                new New_Account();

            }
        });
    }
}


