package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private JButton usunMiejsceKluczoweButton;
    private JTable klienci;
    private JTextField nazwaMKtextField;
    private JButton szukajButton;
    private JTable odcinkiTable;
    private JTextField skadTextField;
    private JTextField nazwaprzewoznika;
    private JButton szukajButton1;
    private JTextField dokadTextField;
    private JButton dodajOdcinekButton;
    private JButton usuńMiesjceKluczoweButton;
    private JTable klienciTable;
    private JTextField SzukajField;
    private JButton SzukajButton;
    private JButton edytujOdcinekButton;
    private JButton usuńButton;

    private int tableRow;

    private int tableColumn;



    public Main_menu() {
        this.tableColumn = tableColumn;
        this.tableRow = tableRow;
        this.nazwa_konta.setText("Analityk");
        this.setContentPane(this.panel);
        this.setTitle("Menu główne");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        String k[] = {"Nazwa miejsca", "Kraj"};
        String n[]={"Imię", "Nazwisko", "Adres email", "numer telefonu","kraj pochodzenia"};
        String o[]={"Skąd","Dokąd","Przewoznik","Samolot","Autobus","Prom","Samochód","Tuk-Tuk","Wykluczenie zniżek"};

        DefaultTableModel dtm = new DefaultTableModel(ListaMiejsc.dane(), k);
        DefaultTableModel dtm1 = new DefaultTableModel(ListaKlientow.dane(), n);
        DefaultTableModel dtm2 = new DefaultTableModel(ListaOdcinkow.dane(), o);;
;
        tabelamiejsc.setModel(dtm);
        tabelamiejsc.setDefaultEditor(Object.class, null);

        klienciTable.setModel(dtm1);
        klienciTable.setDefaultEditor(Object.class, null);


        odcinkiTable.setModel(dtm2);
        odcinkiTable.setDefaultEditor(Object.class, null);

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
                EditMK editMK = new EditMK(true, "","");
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
        usunMiejsceKluczoweButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabelamiejsc.getSelectedRow();
                if(row != -1){
                    String nazwa = tabelamiejsc.getModel().getValueAt(row, 0).toString();
                    String kraj = tabelamiejsc.getModel().getValueAt(row, 1).toString();

                    Main_menu.super.dispose();
                    new usunMK(nazwa, kraj);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Proszę wybrać pozycję w tabeli!", "Brak danych", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        dodajPrzewoznikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaPrzewoznikow.dodajdoListy(nazwaprzewoznika.getText());
                nazwaprzewoznika.setText("");
            }
        });
        dodajOdcinekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_menu.super.dispose();
                new dodajOdcinek();

            }
        });

        klienciTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRow = klienciTable.rowAtPoint(evt.getPoint());
                tableColumn  = klienciTable.columnAtPoint(evt.getPoint());

                String[] rowData = new String[klienciTable.getColumnCount()];
                for (int i = 0; i < klienciTable.getColumnCount(); i++) {
                    rowData[i] = (String) klienciTable.getValueAt(tableRow, i);
                }

                //System.out.println(rowData[2]);

                if (tableRow >= 0 && tableColumn >= 0) {
                    Main_menu.super.dispose();
                    new owned_discount(rowData[2]);
                }
            }
        });

        szukajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!nazwaMKtextField.getText().isBlank()){
                    List<MiejscaKluczowe> miejsca = ListaMiejsc.szukaj(nazwaMKtextField.getText());
                    if(!miejsca.isEmpty()) {
                         String[][] daneSzukaj= new String[miejsca.size()][2];
                        for(int i=0;i<miejsca.size();i++)
                        {
                            daneSzukaj[i][0]=miejsca.get(i).dajnazwe();
                            daneSzukaj[i][1]=miejsca.get(i).dajkraj();
                        }
                        DefaultTableModel dtmSzukaj = new DefaultTableModel(daneSzukaj, k);
                        tabelamiejsc.setModel(dtmSzukaj);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Nie ma takiego miejsca!", "Error", JOptionPane.INFORMATION_MESSAGE);
                        nazwaMKtextField.setText("");
                    }
                }
                else{
                    tabelamiejsc.setModel(dtm);
                }
            }
        });
    }


    private void createUIComponents() {
        kraj=new JComboBox<>(ListaMiejsc.kraje());
        kraj.setSelectedIndex(-1);

    }


    void zmienwyswietlana(int x)
    {
        tabbedPane1.setSelectedIndex(x);
    }
}
