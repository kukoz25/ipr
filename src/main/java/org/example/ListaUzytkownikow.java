package org.example;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaUzytkownikow {
    private static List<Uzytkownik> lista;

    ListaUzytkownikow()
    {
        this.lista =new ArrayList<Uzytkownik>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("uzytkownicy.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] uzytkownik = line.split(splitBy);
                //System.out.println(uzytkownik[0]+' '+uzytkownik[1]+' '+uzytkownik[2]+' '+uzytkownik[3]+' '+uzytkownik[4]);
                this.lista.add(new Uzytkownik(uzytkownik[0],uzytkownik[1],uzytkownik[2],uzytkownik[3],uzytkownik[4]));
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean sprawdzdane(String dane)
    {
        new ListaUzytkownikow();
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getdata().equals(dane))
            {
                return true;
            }
        }
        return false;
    }

    static boolean CorrectData(String n)
    {
        if(n.isEmpty())
        {
            return false;
        }
        else
            return true;
    }
    public static void dodajuzytkownia(String in, String l, String e, String h) {
        new ListaUzytkownikow();
        if(CorrectData(in) && CorrectData(l) && CorrectData(e)&& CorrectData(h))
        {
            String []tmp=in.split(" ");
            lista.add(new Uzytkownik(tmp[0],tmp[1],l,e,h));
            try
            {
                FileWriter fileWriter = new FileWriter("uzytkownicy.csv",true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


                bufferedWriter.write("\n"+tmp[0]+','+tmp[1]+','+l+','+e+','+h);
                bufferedWriter.close();
                fileWriter.close();

            }
            catch(IOException ex) {
                System.out.println("Error writing to file '"+ "uzytkownicy.csv" + "'");}
            new Login();


        }
        else {
            JOptionPane.showMessageDialog(null, "Błędne dane");
            new Login();
        }
    }
}


