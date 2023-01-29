package org.example;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ListaMiejsc {
    private static List<MiejscaKluczowe> lista;

    ListaMiejsc()
    {
        this.lista =new ArrayList<MiejscaKluczowe>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("miejsca.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] miejsce = line.split(splitBy);
                //System.out.println(uzytkownik[0]+' '+uzytkownik[1]+' '+uzytkownik[2]+' '+uzytkownik[3]+' '+uzytkownik[4]);
                this.lista.add(new MiejscaKluczowe(miejsce[0],miejsce[1]));
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String[][] dane()
    {
        new ListaMiejsc();
        String [][] dane= new String[lista.size()][2];
        for(int i=0;i<lista.size();i++)
        {
                dane[i][0]=lista.get(i).dajnazwe();
                dane[i][1]=lista.get(i).dajkraj();

        }
        return dane;
    }

    public static String[] kraje()
    {
        new ListaMiejsc();
        Set<String> k = new HashSet<>();
        for(int i=0;i<lista.size();i++)
        {
            //System.out.println(lista.get(i).dajkraj());
            k.add(lista.get(i).dajkraj());
        }

        String[] kraje=k.toArray(new String[k.size()]);
        //System.out.println(kraje[1]);
        return kraje;

    }

    public static MiejscaKluczowe dajmiejsce(String nazwa)
    {
        new ListaMiejsc();
        //System.out.println(lista.size());
        for(int i=0; i<lista.size();i++)
        {
            if(lista.get(i).dajnazwe().equals(nazwa))
            {
                //System.out.println(lista.get(i));
                return lista.get(i);
            }
        }
        return null;
    }

    public static boolean czypoprawne(String n)
    {
        if(n.isEmpty())
        {
            return false;
        }
        else return true;
    }

    public static void usunMiejsce(String nazwa, String kraj){
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
            new ListaMiejsc();

        }
        catch(IOException ex) {
            System.out.println("error przy usuwaniu mk");
        }
    }
    public static String[][] zaladujOdcinki(String nazwa){
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
        return tabelaContent;
    }
    public static void zmienMK(String n_s, String k_s, String n_n, String k_n)
    {
        if(czypoprawne(n_n)&& czypoprawne(k_n))
        {
        try {
            File inputFile = new File("miejsca.csv");
            File tempFile = new File("myTempFile.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = n_s+","+k_s;
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

            String str = n_n+","+k_n;
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("miejsca.csv", true));
            writer2.append(str);
            writer2.close();

            ListaOdcinkow.zmianaMK(n_s,n_n);
        }
        catch (IOException ex) {
            System.out.println("error przy edytowaniu mk");
        }
        new ListaMiejsc();}
        else {
            JOptionPane.showMessageDialog(null, "Błędne dane");
        }
    }

    public static void dodajMK(String n, String k)
    {
        if(czypoprawne(n)&& czypoprawne(k)) {
            try {
                String str = n + "," + k+"\n";
                BufferedWriter writer = new BufferedWriter(new FileWriter("miejsca.csv", true));
                writer.append(str);
                writer.close();
            } catch (IOException ex) {
                System.out.println("error przy dodawaniu mk");
            }
            new ListaMiejsc();
        }
        else {
            JOptionPane.showMessageDialog(null, "Błędne dane");
        }
    }

    public static String[] miasta()
    {
        new ListaMiejsc();
        Set<String> k = new HashSet<>();
        for(int i=0;i<lista.size();i++)
        {
            //System.out.println(lista.get(i).dajkraj());
            k.add(lista.get(i).dajnazwe());
        }

        String[] miasta=k.toArray(new String[k.size()]);
        //System.out.println(kraje[1]);
        return miasta;

    }


}
