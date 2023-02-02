package org.example;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMK extends JFrame{
    private JPanel panel;
    private JTable ograniczeniaTabela;
    private JTextField nazwaMK;
    private JButton dodajOgraniczenieButton;
    private JButton usunOgraniczenieButton;
    private JButton zapiszButton;
    private JButton cofnijButton;
    private JButton edytujOgraniczenieButton;
    private JTextField krajMK;

    public EditMK(boolean isAdd, String nMk, String kMk) {
        this.setContentPane(this.panel);
        this.setTitle("Dodaj/edytuj miejsce kluczowe");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        String k[] = {"typ","opis"};
        DefaultTableModel dtm = new DefaultTableModel(ListaMiejsc.dajograniczenia(nMk,kMk), k);
        ograniczeniaTabela.setModel(dtm);
        ograniczeniaTabela.setDefaultEditor(Object.class, null);


        if(!isAdd){
            nazwaMK.setText(nMk);
            krajMK.setText(kMk);
        }
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main_menu().zmienwyswietlana(1);
                EditMK.super.dispose();

            }
        });
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ListaMiejsc.czypoprawne(nazwaMK.getText()) && ListaMiejsc.czypoprawne(krajMK.getText())) {
                    if (!isAdd) {
                        ListaMiejsc.zmienMK(nMk, kMk, nazwaMK.getText(), krajMK.getText());
                    } else {
                        ListaMiejsc.dodajMK(nazwaMK.getText(), krajMK.getText());

                    }
                    EditMK.super.setVisible(false);
                    new Main_menu().zmienwyswietlana(1);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Błędne dane");}
            }
        });
        dodajOgraniczenieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ograniczeniaGUI(true,nMk, kMk,"","");
            }
        });

        edytujOgraniczenieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = ograniczeniaTabela.getSelectedRow();
                if(row != -1){
                    String typ = ograniczeniaTabela.getModel().getValueAt(row, 0).toString();
                    String opis = ograniczeniaTabela.getModel().getValueAt(row, 1).toString();

                    new ograniczeniaGUI(false,nMk, kMk,typ, opis);
                }
            }
        });

        edytujOgraniczenieButton.setEnabled(false);
        usunOgraniczenieButton.setEnabled(false);
        ograniczeniaTabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if(ograniczeniaTabela.getSelectedRow()!=-1)
                {
                    edytujOgraniczenieButton.setEnabled(true);
                    usunOgraniczenieButton.setEnabled(true);
                }
            }
        });
    }

}
