package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ograniczeniaGUI extends JFrame{
    private JComboBox TypComboBox;
    private JTextField opisTextField;
    private JButton zapiszButton;
    private JButton cofnijButton;
    private JPanel panel;

    public ograniczeniaGUI(boolean isAdd, String nMk, String kMk, String typ, String opis) {
        this.setContentPane(this.panel);
        this.setTitle("Ograniczenia");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ograniczeniaGUI.super.dispose();
                EditMK editMK = new EditMK(false, nMk, kMk);
            }
        });
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Ograniczenie.czypoprawne(TypComboBox.getSelectedItem().toString()) && Ograniczenie.czypoprawne(opisTextField.getText())) {
                    if (!isAdd) {
                        ListaMiejsc.edytujograniczenie(nMk, kMk,typ,opis,TypComboBox.getSelectedItem().toString(), opisTextField.getText());
                    } else {
                      ListaMiejsc.dodajograniczenie(nMk, kMk,TypComboBox.getSelectedItem().toString(), opisTextField.getText());

                    }
                    ograniczeniaGUI.super.dispose();
                    //new Main_menu().zmienwyswietlana(1);
                    EditMK editMK = new EditMK(false, nMk, kMk);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Błędne dane");}
            }
        });
    }
}
