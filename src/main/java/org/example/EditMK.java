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
        if(!isAdd){
            nazwaMK.setText(nMk);
            krajMK.setText(kMk);
        }
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMK.super.setVisible(false);
                new Main_menu();
            }
        });
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isAdd){
                if(ListaMiejsc.czypoprawne(nazwaMK.getText())&&ListaMiejsc.czypoprawne(krajMK.getText()))
                {
                    ListaMiejsc.zmienMK(nMk,kMk,nazwaMK.getText(),krajMK.getText());
                }
                else
                    JOptionPane.showMessageDialog(null, "Błędne dane");
                }
                else
                {
                    if(ListaMiejsc.czypoprawne(nazwaMK.getText())&&ListaMiejsc.czypoprawne(krajMK.getText()))
                    {
                        ListaMiejsc.dodajMK(nazwaMK.getText(),krajMK.getText());

                    }
                    else JOptionPane.showMessageDialog(null, "Błędne dane");
                }
                EditMK.super.setVisible(false);
                new Main_menu();
            }
        });
        dodajOgraniczenieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
