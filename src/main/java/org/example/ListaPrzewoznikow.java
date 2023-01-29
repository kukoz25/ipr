package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static boolean checkdane(String g)
    {
        if(g.isEmpty())
        {
            return false;
        }
        else return true;
    }

    public static void dodajdoListy(String g)
    {
        lista.add(new Przewoznik(g));
        try
        {
            FileWriter fileWriter = new FileWriter("przewoznicy.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            bufferedWriter.write(g+"\n");
            bufferedWriter.close();
            fileWriter.close();

        }
        catch(IOException ex) {
            System.out.println("Error writing to file '"+ "przewoznicy.csv" + "'");}
    }

    public static String[] przewoznik()
    {
        new ListaPrzewoznikow();
        Set<String> k = new HashSet<>();
        for(int i=0;i<lista.size();i++)
        {
            //System.out.println(lista.get(i).dajkraj());
            k.add(lista.get(i).dajnazwe());
        }

        String[] przewoznik=k.toArray(new String[k.size()]);
        //System.out.println(kraje[1]);
        return przewoznik;

    }
}
