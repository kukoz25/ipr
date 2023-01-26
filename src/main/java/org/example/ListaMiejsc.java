package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

}
