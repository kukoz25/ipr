package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class dodajOdcinek extends JFrame{
    private JComboBox przewoznik;
    private JRadioButton autobusRadioButton;
    private JRadioButton promRadioButton;
    private JRadioButton samochodRadioButton;
    private JRadioButton tukTukRadioButton;
    private JRadioButton wykluczenieZeZnizekRadioButton;
    private JRadioButton samolotRadioButton;
    private JButton anulujButton;
    private JButton zatwierdzButton;
    private JTextField texttuktuk;
    private JTextField textsamochod;
    private JTextField textprom;
    private JTextField textautobus;
    private JTextField textsamolot;
    private JPanel panel;
    private JComboBox skad;
    private JComboBox dokad;

    public dodajOdcinek() {
        this.setContentPane(this.panel);
        this.setTitle("dodaj odcinek");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
    ListaOdcinkow.dodajodcinek(przewoznik.getSelectedIndex(),skad.getSelectedIndex(),dokad.getSelectedIndex(),textsamolot.getText(),textautobus.getText(),textprom.getText(), textsamochod.getText(), texttuktuk.getText(), wykluczenieZeZnizekRadioButton.isSelected());
                dodajOdcinek.super.dispose();
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajOdcinek.super.dispose();
                Main_menu mainmenu = new Main_menu();
            }
        });
        samolotRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samolotRadioButton.isSelected())
                {
                    textsamolot.setEnabled(true);
                }
                else textsamolot.setEnabled(false);

            }
        });
        autobusRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(autobusRadioButton.isSelected())
                {
                    textautobus.setEnabled(true);
                }
                else textautobus.setEnabled(false);

            }
        });
        promRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(promRadioButton.isSelected())
                {
                    textprom.setEnabled(true);
                }
                else textprom.setEnabled(false);
            }
        });

        samochodRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochodRadioButton.isSelected())
                {
                    textsamochod.setEnabled(true);
                }
                else textsamochod.setEnabled(false);

            }
        });
        tukTukRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tukTukRadioButton.isSelected())
                {
                    texttuktuk.setEnabled(true);
                }
                else texttuktuk.setEnabled(false);

            }
        });
    }

    private void createUIComponents() {
        skad=new JComboBox<>(ListaMiejsc.miasta());
        skad.setSelectedIndex(-1);
        dokad=new JComboBox<>(ListaMiejsc.miasta());
        dokad.setSelectedIndex(-1);
        przewoznik=new JComboBox<>(ListaPrzewoznikow.przewoznik());
        przewoznik.setSelectedIndex(-1);
        textsamochod=new JTextField();
        textsamochod.setEnabled(false);
        textautobus=new JTextField();
        textautobus.setEnabled(false);
        textprom=new JTextField();
        textprom.setEnabled(false);
        textsamolot= new JTextField();
        textsamolot.setEnabled(false);
        texttuktuk=new JTextField();
        texttuktuk.setEnabled(false);
    }
}
