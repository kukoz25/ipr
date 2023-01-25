package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class password_change extends JFrame {
    private JButton wyslijButton;
    private JPanel panel;
    private JLabel label;

    public password_change() {
        this.setContentPane(this.panel);
        this.setTitle("Zmiana hasła");
        this.setSize(240, 130);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        label.setText("<html>Formularz zmiany hasła <br>zostanie wysłany na e-mail <br>przypisany do konta</html>");
        wyslijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password_change.super.setVisible(false);
                Main_menu m = new Main_menu();

            }
        });
    }
}
