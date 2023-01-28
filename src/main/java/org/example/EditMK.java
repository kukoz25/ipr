package org.example;


import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EditMK extends JFrame{
    private JPanel panel;
    private JTable table1;
    private JTextField nazwaMK;
    private JRadioButton wizyRadioButton;
    private JRadioButton szczepionkiRadioButton;
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
                Main_menu main_menu = new Main_menu();
            }
        });
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(nazwaMK.getText().isBlank() | krajMK.getText().isBlank())) {
                    if (isAdd){
                        try {
                            String str = "\n"+nazwaMK.getText()+","+krajMK.getText();
                            BufferedWriter writer = new BufferedWriter(new FileWriter("miejsca.csv", true));
                            writer.append(str);
                            writer.close();
                        } catch(IOException ex) {
                            System.out.println("error przy dodawaniu mk");
                        }

                    } else {
                        try {
                            File inputFile = new File("miejsca.csv");
                            File tempFile = new File("myTempFile.csv");

                            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                            String lineToRemove = nMk+","+kMk;
                            String currentLine;

                            while((currentLine = reader.readLine()) != null) {
                                String trimmedLine = currentLine.trim();
                                if(trimmedLine.equals(lineToRemove)) continue;
                                writer.write(currentLine + System.getProperty("line.separator"));
                            }
                            writer.close();
                            reader.close();

                            boolean etap2 = inputFile.delete();
                            File dump = new File("miejsca.csv");
                            boolean etap4 = tempFile.renameTo(dump);

                            String str = nazwaMK.getText()+","+krajMK.getText();
                            BufferedWriter writer2 = new BufferedWriter(new FileWriter("miejsca.csv", true));
                            writer2.append(str);
                            writer2.close();
                        }
                        catch(IOException ex) {
                            System.out.println("error przy edytowaniu mk");
                        }
                    }
                    EditMK.super.setVisible(false);
                    Main_menu main_menu = new Main_menu();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Proszę podać nazwę i kraj!", "Brak danych", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
