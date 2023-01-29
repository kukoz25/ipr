package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class discountEditingAdding extends JFrame{
    private JPanel panel;
    private JTextField nazwaZnizkiTextField;
    private JComboBox wielkoscZnizkiComboBox;
    private JButton nadajZnizkeButton;
    private JButton anulujButton;

    private String wybranyEmail;

    public discountEditingAdding(String wybranyEmail) {

        this.wybranyEmail = wybranyEmail;
        this.setContentPane(this.panel);
        this.setTitle("Dodawanie zniżek");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discountEditingAdding.super.dispose();
                new owned_discount(wybranyEmail);
            }
        });

        nadajZnizkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaKlientow.dodajZnizke(wybranyEmail,nazwaZnizkiTextField.getText(), wielkoscZnizkiComboBox.getSelectedItem().toString());
                try {
                    ListaKlientow.dopisDoCSV();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                discountEditingAdding.super.dispose();
                new owned_discount(wybranyEmail);
            }
        });
    }

    public discountEditingAdding(String wybranyEmail, String nazwaWybranejZnizki, String wartoscWybranejZnizki) {
        this.wybranyEmail = wybranyEmail;
        this.setContentPane(this.panel);
        this.setTitle("Edycja zniżek");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        nazwaZnizkiTextField.setText(nazwaWybranejZnizki);
        wielkoscZnizkiComboBox.setSelectedIndex(Integer.parseInt(wartoscWybranejZnizki)-1);

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discountEditingAdding.super.dispose();
                new owned_discount(wybranyEmail);

            }
        });

        nadajZnizkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaKlientow.usunZnizke(wybranyEmail,wartoscWybranejZnizki, nazwaWybranejZnizki);
                ListaKlientow.dodajZnizke(wybranyEmail, nazwaZnizkiTextField.getText(), wielkoscZnizkiComboBox.getSelectedItem().toString());
                try {
                    ListaKlientow.dopisDoCSV();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                discountEditingAdding.super.dispose();
                new owned_discount(wybranyEmail);
            }
        });

    }


    private void createUIComponents() {
    }
}
