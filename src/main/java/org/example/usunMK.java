package org.example;

import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class usunMK extends JFrame{
    private JPanel panel;
    private JTable tabelaUsun;
    private JButton usunMiejsceKluczoweRazemButton;
    private JButton anulujButton;

    public usunMK(String nazwa, String kraj) {
        this.setContentPane(this.panel);
        this.setTitle("Usuń miejsce kluczowe");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        String [][] tabelaContent = ListaMiejsc.zaladujOdcinki(nazwa);
        String head[] = {"Skąd", "Dokąd"};
        DefaultTableModel dtm = new DefaultTableModel(tabelaContent, head);;
        tabelaUsun.setModel(dtm);
        tabelaUsun.setDefaultEditor(Object.class, null);

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunMK.super.dispose();
                new Main_menu();
            }
        });
        usunMiejsceKluczoweRazemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMiejsc.usunMiejsce(nazwa, kraj);
                ListaOdcinkow.usunOdcinek(nazwa);
                usunMK.super.dispose();
                new Main_menu();
            }
        });
    }
}
