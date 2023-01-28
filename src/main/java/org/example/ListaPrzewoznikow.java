package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaPrzewoznikow {
    private static List<Przewoznik> lista;

    ListaPrzewoznikow()
    {
        this.lista =new ArrayList<Przewoznik>();
        String line = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("przewoznicy.csv"));
            while ((line = br.readLine()) != null)
            {
                //System.out.println(line);
                //Przewoznik p=new Przewoznik(line);
                this.lista.add(new Przewoznik(line));
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Przewoznik dajprzewoznika(String nazwa)
    {
        new ListaPrzewoznikow();
        //System.out.println(lista.size());
        for(int i=0; i<lista.size();i++)
        {
            //System.out.println(lista.get(i).dajnazwe());
            if(lista.get(i).dajnazwe().equals(nazwa))
            {
                return lista.get(i);
            }
        }
            return null;
    }
}
