package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class owned_discount extends JFrame{
    private JTable znizkiTable;
    private JButton dodajButton;
    private JButton usunButton;
    private JButton edytujButton;
    private JButton anulujButton;
    private JPanel panel;

    private int tableRow;

    private int tableColumn;

    private String wybranyEmail;

    private String wartoscWybranejZnizki = "";

    private String nazwaWybranejZnizki = "";


    public owned_discount(String tableEmail) {
        this.wybranyEmail = tableEmail;
        this.tableColumn = -1;
        this.tableRow = -1;
        this.setContentPane(this.panel);
        this.setTitle("Posiadane zniżki");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        String k[] = {"E-mail", "Nazwa zniżki", "Wielkośc zniżki"};

        DefaultTableModel dtm = new DefaultTableModel(ListaKlientow.daneZnizki(tableEmail), k);;

        znizkiTable.setModel(dtm);
        znizkiTable.setDefaultEditor(Object.class, null);


        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owned_discount.super.setVisible(false);
                new Main_menu();
            }
        });

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owned_discount.super.dispose();
                new discountEditingAdding(wybranyEmail);
            }
        });


        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!nazwaWybranejZnizki.equals("") && !wartoscWybranejZnizki.equals("")){
                    ListaKlientow.usunZnizke(tableEmail,wartoscWybranejZnizki, nazwaWybranejZnizki);
                    try {
                        ListaKlientow.dopisDoCSV();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    owned_discount.super.dispose();
                    new owned_discount(tableEmail);
                }
            }
        });


        edytujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableRow != -1 && tableColumn != -1){
                    owned_discount.super.dispose();
                    new discountEditingAdding(wybranyEmail, nazwaWybranejZnizki, wartoscWybranejZnizki);
                }
            }
        });


        znizkiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                tableRow = znizkiTable.rowAtPoint(evt.getPoint());
                tableColumn  = znizkiTable.columnAtPoint(evt.getPoint());

                String[] rowData = new String[znizkiTable.getColumnCount()];
                for (int i = 0; i < znizkiTable.getColumnCount(); i++) {
                    rowData[i] = (String) znizkiTable.getValueAt(tableRow, i);
                }

                nazwaWybranejZnizki = rowData[1];
                wartoscWybranejZnizki = rowData[2].substring(0, rowData[2].length() - 2);
            }
        });

    }


    private void createUIComponents() {
    }
}
