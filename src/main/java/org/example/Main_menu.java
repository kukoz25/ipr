package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_menu extends JFrame {
    private JLabel nazwa_konta;
    private JButton zmienHasloButton;
    private JButton wylogujButton;
    private JButton dodajPrzewoznikaButton;
    private JButton miejscaKluczoweButton;
    private JButton zniżkiButton;
    private JButton zarządzanieOdcinkamiButton;
    private JPanel panel;


    public Main_menu() {
        this.nazwa_konta.setText("Analityk");
        this.setContentPane(this.panel);
        this.setTitle("Menu główne");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_menu.super.setVisible(false);
                Logout g = new Logout();
            }
        });
        zmienHasloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_menu.super.setVisible(false);
                password_change p = new password_change();
            }
        });
        dodajPrzewoznikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_menu.super.setVisible(false);
                Add_carrier c = new Add_carrier();
            }
        });
    }


}
