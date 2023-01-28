package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_menu extends JFrame {
    private JLabel nazwa_konta;
    private JButton zmienHasloButton;
    private JButton wylogujButton;
    private JButton dodajPrzewoznikaButton;
    private JButton miejscaKluczoweButton;
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JTable tabelamiejsc;
    private JComboBox kraj;
    private JButton edytujMiejsceKluczoweButton;
    private JButton dodajMiejsceKluczoweButton;
    private JButton usunMiesjceKluczoweButton;
    private JTable klienci;
    private JTextField textField1;
    private JButton szukajButton;


    public Main_menu() {
        this.nazwa_konta.setText("Analityk");
        this.setContentPane(this.panel);
        this.setTitle("Menu główne");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        String k[] = {"Nazwa miesjca", "Kraj"};
        String n[]={"Imię", "Nazwisko", "Adres email", "numer telefonu","kraj pochodzenia"};
        DefaultTableModel dtm = new DefaultTableModel(ListaMiejsc.dane(), k);;
        DefaultTableModel dtm1 = new DefaultTableModel(ListaKlientow.dane(), n);;
        tabelamiejsc.setModel(dtm);
        tabelamiejsc.setDefaultEditor(Object.class, null);
        klienci.setModel(dtm1);
        klienci.setDefaultEditor(Object.class, null);
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

        dodajMiejsceKluczoweButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_menu.super.dispose();
                EditMK editMK = new EditMK(true, "null","null");
            }
        });
        edytujMiejsceKluczoweButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabelamiejsc.getSelectedRow();
                if(row != -1){
                    String nazwa = tabelamiejsc.getModel().getValueAt(row, 0).toString();
                    String kraj = tabelamiejsc.getModel().getValueAt(row, 1).toString();

                    Main_menu.super.dispose();
                    EditMK editMK = new EditMK(false, nazwa, kraj);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Proszę wybrać pozycję w tabeli!", "Brak danych", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        usunMiesjceKluczoweButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_menu.super.dispose();
                usunMK guiusun = new usunMK();
            }
        });
    }


    private void createUIComponents() {
        kraj=new JComboBox<>(ListaMiejsc.kraje());
        kraj.setSelectedIndex(-1);

    }
}
