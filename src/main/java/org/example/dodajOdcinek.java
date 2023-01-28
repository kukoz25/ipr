package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dodajOdcinek extends JFrame{
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton autobusRadioButton;
    private JRadioButton promRadioButton;
    private JRadioButton samochodRadioButton;
    private JRadioButton tukTukRadioButton;
    private JRadioButton wykluczenieZeZnizekRadioButton;
    private JRadioButton samolotRadioButton;
    private JButton anulujButton;
    private JButton zatwierdzButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JPanel panel;

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

            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajOdcinek.super.dispose();
                Main_menu mainmenu = new Main_menu();
            }
        });
    }
}
