package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaKlientow {
    private static List<Klient> lista;

    ListaKlientow()
    {
        this.lista =new ArrayList<Klient>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("klienci.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] klient = line.split(splitBy);
                //System.out.println(klient[0]+klient[1]+klient[2]+klient[3]+klient[4]);
                this.lista.add(new Klient(klient[0],klient[1],klient[2],klient[3],klient[4],klient[5]));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String[][] dane()
    {
        new ListaKlientow();
        String [][] dane= new String[lista.size()][5];
        for(int i=0;i<lista.size();i++)
        {
            dane[i][0]=lista.get(i).dajimie();
            dane[i][1]=lista.get(i).dajnazwisko();
            dane[i][2]=lista.get(i).dajmail();
            dane[i][3]=lista.get(i).dajnumer();
            dane[i][4]=lista.get(i).dajkraj();

        }
        return dane;
    }

}
