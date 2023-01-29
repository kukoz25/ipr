package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaOdcinkow {
    private static List<Odcinek> lista;

    ListaOdcinkow() {
        this.lista = new ArrayList<Odcinek>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("odcinki.csv"));
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] odcinek = line.split(splitBy);
                String[] kwoty = odcinek[3].split(";");
                //System.out.println(klient[0]+klient[1]+klient[2]+klient[3]+klient[4]);
                this.lista.add(new Odcinek(odcinek[0], odcinek[1], odcinek[2], kwoty, odcinek[4]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[][] dane() {
        new ListaOdcinkow();
        String[][] dane = new String[lista.size()][9];
        for (int i = 0; i < lista.size(); i++) {
            dane[i][0] = lista.get(i).start();
            dane[i][1] = lista.get(i).koniec();
            dane[i][2] = lista.get(i).przewoznik();
            dane[i][3] = lista.get(i).samolot();
            dane[i][4] = lista.get(i).autobus();
            dane[i][5] = lista.get(i).prom();
            dane[i][6] = lista.get(i).samochod();
            dane[i][7] = lista.get(i).tuktuk();
            dane[i][8] = lista.get(i).wykluczenie();

        }
        return dane;
    }

    public static void usunOdcinek(String nazwa) {
        try {
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
        catch (Exception ex) {
            System.out.println("error przy usuwaniu odc");
        }

    }
    public static void zmianaMK(String stare, String nowe) {
        try {
            File inputFile1 = new File("odcinki.csv");
            File tempFile1 = new File("myTempFile.csv");

            BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1));

            String wordToRemove = stare;
            String currentLine1;

            while ((currentLine1 = reader1.readLine()) != null) {
                String trimmedLine = currentLine1.trim();
                if (trimmedLine.contains(wordToRemove)) {
                    currentLine1 = currentLine1.replace(wordToRemove, nowe);
                    writer1.write(currentLine1 + System.getProperty("line.separator"));
                }
                writer1.write(currentLine1 + System.getProperty("line.separator"));
            }
            writer1.close();
            reader1.close();

            inputFile1.delete();
            File dump1 = new File("odcinki.csv");
            tempFile1.renameTo(dump1);
        }
        catch (IOException ex) {
            System.out.println("error przy edytowaniu mk");
        }
        new ListaOdcinkow();
    }
}
