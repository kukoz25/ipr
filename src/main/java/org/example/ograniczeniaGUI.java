package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ograniczeniaGUI extends JFrame{
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton dodajButton;
    private JButton anulujButton;
    private JPanel panel;

    public ograniczeniaGUI(boolean isAdd, String nMk, String kMk) {
        this.setContentPane(this.panel);
        this.setTitle("Ograniczenia");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ograniczeniaGUI.super.dispose();
                EditMK editMK = new EditMK(isAdd, nMk, kMk);
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
