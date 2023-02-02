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
                //System.out.println(miejsce.length);
                if(miejsce.length==3)
                {
                    this.lista.add(new MiejscaKluczowe(miejsce[0],miejsce[1],miejsce[2]));
                    //System.out.println(miejsce[2]);
                }
                else
                    this.lista.add(new MiejscaKluczowe(miejsce[0],miejsce[1],""));
                //System.out.println(uzytkownik[0]+' '+uzytkownik[1]+' '+uzytkownik[2]+' '+uzytkownik[3]+' '+uzytkownik[4]);

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

    public static List<MiejscaKluczowe> szukaj(String nazwa)
    {
        List<MiejscaKluczowe> list = new ArrayList<MiejscaKluczowe>();
        new ListaMiejsc();
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).dajnazwe().equals(nazwa))
            {
                list.add(lista.get(i));
            }
        }
        return list;
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

    public static String[][] dajograniczenia(String nazwa,String kraj){
        new ListaMiejsc();
        //System.out.println(lista.size());
        for(int i=0; i<lista.size();i++)
        {
            if(lista.get(i).dajnazwe().equals(nazwa)&&lista.get(i).dajkraj().equals(kraj))
            {
                //System.out.println(lista.get(i).dajograniczenia().);
                return lista.get(i).dajograniczenia();
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
                if(trimmedLine.contains(lineToRemove)) continue;
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
        try {
            File inputFile = new File("miejsca.csv");
            File tempFile = new File("myTempFile.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = n_s+","+k_s;
            String currentLine;
            String tmp="";
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                tmp=trimmedLine;
                if(trimmedLine.contains(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            boolean etap2 = inputFile.delete();
            File dump = new File("miejsca.csv");
            boolean etap4 = tempFile.renameTo(dump);
            String str="";
            //System.out.println(tmp);
            if(!tmp.equals(""))
            {
                String tmp2[]=tmp.split(",");
                if(tmp2.length>2) {
                     str = n_n + "," + k_n +","+ tmp2[2];
                }
                else {
                     str = n_n + "," + k_n;
                }
            }
            else {
                 str = n_n + "," + k_n;
            }
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("miejsca.csv", true));
            writer2.append(str);
            writer2.close();

            ListaOdcinkow.zmianaMK(n_s,n_n);
        }
        catch (IOException ex) {
            System.out.println("error przy edytowaniu mk");
        }
        new ListaMiejsc();
    }

    public static void dodajMK(String n, String k)
    {
            try {
                String str = n + "," + k+ ","+"\n";
                BufferedWriter writer = new BufferedWriter(new FileWriter("miejsca.csv", true));
                writer.append(str);
                writer.close();
            } catch (IOException ex) {
                System.out.println("error przy dodawaniu mk");
            }
            new ListaMiejsc();
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

    public static void dodajograniczenie(String nazwa, String kraj, String typ, String opis)
    {
        try {
            File inputFile = new File("miejsca.csv");
            File tempFile = new File("myTempFile.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String tmp="";
            String lineToRemove = nazwa+","+kraj;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                tmp=trimmedLine;
                if(trimmedLine.contains(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            boolean etap2 = inputFile.delete();
            File dump = new File("miejsca.csv");
            boolean etap4 = tempFile.renameTo(dump);
                String tmp2[]=tmp.split(",");
                String str="";
                if(tmp2.length>2) {
                     str = nazwa + "," + kraj +","+ tmp2[2]+typ+"-"+opis+";";
                }
                else {
                    str = nazwa + "," + kraj +","+typ+"-"+opis+";";
                }
            //System.out.println(str);
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("miejsca.csv", true));
            writer2.append(str);
            writer2.close();
            new ListaMiejsc();
        }
        catch (IOException ex) {
            System.out.println("error przy edytowaniu mk");
        }
        new ListaMiejsc();
    }


    public static void edytujograniczenie(String nazwa, String kraj, String typ_s, String opis_s, String typ_n, String opis_n)
    {
        try {
            File inputFile = new File("miejsca.csv");
            File tempFile = new File("myTempFile.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String tmp="";
            String lineToRemove1 = nazwa+","+kraj;
            String lineToRemove2 = typ_s+"-"+opis_s;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                tmp=trimmedLine;
                if(trimmedLine.contains(lineToRemove1) && trimmedLine.contains(lineToRemove2)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            boolean etap2 = inputFile.delete();
            File dump = new File("miejsca.csv");
            boolean etap4 = tempFile.renameTo(dump);
            String tmp2[]=tmp.split(",");
            String str="";
            str=nazwa+","+kraj+",";
            String tmp3[]=tmp2[2].split(";");
            for(int i=0;i<tmp3.length;i++)
            {
                //System.out.println(tmp3[i]);
                if(tmp3[i].equals(lineToRemove2))
                {
                    str+=typ_n+"-"+opis_n+";";
                }
                else str+=tmp3[i]+";";

            }
            //System.out.println(str);
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("miejsca.csv", true));
            writer2.append(str);
            writer2.close();
            new ListaMiejsc();
        }
        catch (IOException ex) {
            System.out.println("error przy edytowaniu mk");
        }
        new ListaMiejsc();
    }


    public static void usunograniczenie(String nazwa, String kraj, String typ_s, String opis_s)
    {
        try {
            File inputFile = new File("miejsca.csv");
            File tempFile = new File("myTempFile.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String tmp="";
            String lineToRemove1 = nazwa+","+kraj;
            String lineToRemove2 = typ_s+"-"+opis_s;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                tmp=trimmedLine;
                if(trimmedLine.contains(lineToRemove1) && trimmedLine.contains(lineToRemove2)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            boolean etap2 = inputFile.delete();
            File dump = new File("miejsca.csv");
            boolean etap4 = tempFile.renameTo(dump);
            System.out.println(tmp);
            String tmp2[]=tmp.split(",");
            String str="";
            str=nazwa+","+kraj+",";
            String tmp3[]=tmp2[2].split(";");
            for(int i=0;i<tmp3.length;i++)
            {
                //System.out.println(tmp3[i]);
                if(tmp3[i].equals(lineToRemove2))
                {
                }
                else str+=tmp3[i]+";";

            }
            //System.out.println(str);
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("miejsca.csv", true));
            writer2.append(str);
            writer2.close();
            new ListaMiejsc();
        }
        catch (IOException ex) {
            System.out.println("error przy edytowaniu mk");
        }
        new ListaMiejsc();
    }

}
