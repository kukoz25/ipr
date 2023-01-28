package org.example;

import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class usunMK extends JFrame{
    private JPanel panel;
    private JTable tabelaUsun;
    private JButton usunMiejsceKluczoweRazemButton;
    private JButton anulujButton;

    public usunMK(String nazwa, String kraj) {
        this.setContentPane(this.panel);
        this.setTitle("Usuń miejsce kluczowe");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        HashMap<String,String> map = new HashMap<>();

        try{
            File inputFile = new File("odcinki.csv");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String wordToFind = nazwa;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(trimmedLine.contains(wordToFind)){
                    String[] temp = trimmedLine.split(",");
                    map.put(temp[0], temp[1]);
                }
            }
            reader.close();
        }
        catch (Exception ex){
            System.out.println("error while usun mk occured");
        }

        String [][] tabelaContent = new String[map.size()][2];
        int iter = 0;

        for(Map.Entry<String,String> entry : map.entrySet()){
            tabelaContent[iter][0] = entry.getKey();
            tabelaContent[iter][1] = entry.getValue();
            iter++;
        }

        String head[] = {"Skąd", "Dokąd"};
        DefaultTableModel dtm = new DefaultTableModel(tabelaContent, head);;
        tabelaUsun.setModel(dtm);
        tabelaUsun.setDefaultEditor(Object.class, null);

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunMK.super.dispose();
                Main_menu mainmenu = new Main_menu();
            }
        });
        usunMiejsceKluczoweRazemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File inputFile = new File("miejsca.csv");
                    File tempFile = new File("myTempFile.csv");

                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                    String lineToRemove = nazwa+","+kraj;
                    String currentLine;

                    while((currentLine = reader.readLine()) != null) {
                        String trimmedLine = currentLine.trim();
                        if(trimmedLine.equals(lineToRemove)) continue;
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                    writer.close();
                    reader.close();

                    inputFile.delete();
                    File dump = new File("miejsca.csv");
                    tempFile.renameTo(dump);


                    File inputFile1 = new File("odcinki.csv");
                    File tempFile1 = new File("myTempFile.csv");

                    BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
                    BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1));

                    String wordToRemove = nazwa;
                    String currentLine1;

                    while((currentLine1 = reader1.readLine()) != null) {
                        String trimmedLine = currentLine1.trim();
                        if(trimmedLine.contains(wordToRemove)) continue;
                        writer1.write(currentLine1 + System.getProperty("line.separator"));
                    }
                    writer1.close();
                    reader1.close();

                    inputFile1.delete();
                    File dump1 = new File("odcinki.csv");
                    tempFile1.renameTo(dump1);
                }
                catch(IOException ex) {
                    System.out.println("error przy usuwaniu mk");
                }
                usunMK.super.dispose();
                Main_menu main_menu = new Main_menu();
            }
        });
    }
}
