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
    private JButton usuńMiesjceKluczoweButton;
    private JTable klienciTable;
    private JTextField SzukajField;
    private JButton SzukajButton;

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

        String k[] = {"Nazwa miesjca", "Kraj"};
        String n[]={"Imię", "Nazwisko", "Adres email", "numer telefonu","kraj pochodzenia"};

        DefaultTableModel dtm = new DefaultTableModel(ListaMiejsc.dane(), k);
        DefaultTableModel dtm1 = new DefaultTableModel(ListaKlientow.dane(), n);

        tabelamiejsc.setModel(dtm);
        tabelamiejsc.setDefaultEditor(Object.class, null);
        klienciTable.setModel(dtm1);
        klienciTable.setDefaultEditor(Object.class, null);
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

        klienciTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRow = klienciTable.rowAtPoint(evt.getPoint());
                tableColumn  = klienciTable.columnAtPoint(evt.getPoint());

                String[] rowData = new String[klienciTable.getColumnCount()];
                for (int i = 0; i < klienciTable.getColumnCount(); i++) {
                    rowData[i] = (String) klienciTable.getValueAt(tableRow, i);
                }

                System.out.println(rowData[2]);

                if (tableRow >= 0 && tableColumn >= 0) {
                    owned_discount o = new owned_discount(rowData[2]);
                }
            }
        });

    }


    private void createUIComponents() {
        kraj=new JComboBox<>(ListaMiejsc.kraje());
        kraj.setSelectedIndex(-1);
    }
}
