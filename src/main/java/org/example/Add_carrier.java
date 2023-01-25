package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_carrier extends JFrame{
    private JPanel panel;
    private JTextField textField1;
    private JButton dodajButton;
    private JButton anulujButton;

    public Add_carrier() {
        this.setContentPane(this.panel);
        this.setTitle("Dodaj przewoźnika");
        this.setSize(250, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_carrier.super.setVisible(false);
                Main_menu m= new Main_menu();
            }
        });
    }
}
