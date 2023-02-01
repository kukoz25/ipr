package org.example;


import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMK extends JFrame{
    private JPanel panel;
    private JTable table1;
    private JTextField nazwaMK;
    private JRadioButton wizyRadioButton;
    private JRadioButton szczepieniaRadioButton;
    private JRadioButton zagrozeniaRadioButton;
    private JButton dodajOgraniczenieButton;
    private JButton usunOgraniczenieButton;
    private JButton zatwierdzButton;
    private JButton anulujButton;
    private JButton edytujOgraniczenieButton;
    private JTextField krajMK;

    public EditMK(boolean isAdd, String nMk, String kMk) {
        this.setContentPane(this.panel);
        this.setTitle("Dodaj/edytuj miejsce kluczowe");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        String k[] = {"ograniczenie","co"};

        if(!isAdd){
            nazwaMK.setText(nMk);
            krajMK.setText(kMk);
        }
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMK.super.setVisible(false);
                new Main_menu().zmienwyswietlana(1);

            }
        });
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isAdd){
                    ListaMiejsc.zmienMK(nMk,kMk,nazwaMK.getText(),krajMK.getText());
                }
                else
                {
                        ListaMiejsc.dodajMK(nazwaMK.getText(),krajMK.getText());

                }
                EditMK.super.setVisible(false);
                new Main_menu().zmienwyswietlana(1);

            }
        });
        dodajOgraniczenieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ograniczeniaGUI(false,"es", "es");
            }
        });
        szczepieniaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(szczepieniaRadioButton.isSelected())
                {
                    zagrozeniaRadioButton.setEnabled(false);
                    wizyRadioButton.setEnabled(false);
                }
                else {
                    szczepieniaRadioButton.setEnabled(true);
                    zagrozeniaRadioButton.setEnabled(true);
                    wizyRadioButton.setEnabled(true);

                }

            }
        });
        zagrozeniaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(zagrozeniaRadioButton.isSelected())
                {
                    szczepieniaRadioButton.setEnabled(false);
                    wizyRadioButton.setEnabled(false);
                }
                else {
                    szczepieniaRadioButton.setEnabled(true);
                    zagrozeniaRadioButton.setEnabled(true);
                    wizyRadioButton.setEnabled(true);

                }
            }
        });
        wizyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(wizyRadioButton.isSelected())
                {
                    szczepieniaRadioButton.setEnabled(false);
                    zagrozeniaRadioButton.setEnabled(false);
                }
                else {
                    szczepieniaRadioButton.setEnabled(true);
                    zagrozeniaRadioButton.setEnabled(true);
                    wizyRadioButton.setEnabled(true);

                }
            }
        });
    }

    private void createUIComponents() {
        szczepieniaRadioButton = new JRadioButton();
        zagrozeniaRadioButton = new JRadioButton();
        wizyRadioButton = new JRadioButton();
        // TODO: place custom component creation code here
    }
}
