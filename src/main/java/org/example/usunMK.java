package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class usunMK extends JFrame{
    private JPanel panel;
    private JTable table1;
    private JButton usuńMiejsceKluczoweRazemButton;
    private JButton anulujButton;

    public usunMK() {
        this.setContentPane(this.panel);
        this.setTitle("Usuń miejsce kluczowe");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunMK.super.dispose();
                Main_menu mainmenu = new Main_menu();
            }
        });
        usuńMiejsceKluczoweRazemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
