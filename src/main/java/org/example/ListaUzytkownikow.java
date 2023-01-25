package org.example;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] uzytkownik = line.split(splitBy);    // use comma as separator
                //System.out.println(uzytkownik[0]+' '+uzytkownik[1]+' '+uzytkownik[2]+' '+uzytkownik[3]+' '+uzytkownik[4]);
                this.lista.add(new Uzytkownik(uzytkownik[0],uzytkownik[1],uzytkownik[2],uzytkownik[3]));
            }
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
            if(lista.get(i).getdata()==dane)
            {
                return true;
            }
        }
        return false;
    }
}


