package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaOdcinkow {
    private static List<Odcinek> lista;

    ListaOdcinkow()
    {
        this.lista =new ArrayList<Odcinek>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("odcinki.csv"));
            while ((line = br.readLine()) != null)
            {
                //System.out.println(line);
                String[] odcinek = line.split(splitBy);
                String[] kwoty=odcinek[3].split(";");
                //System.out.println(klient[0]+klient[1]+klient[2]+klient[3]+klient[4]);
                this.lista.add(new Odcinek(odcinek[0],odcinek[1],odcinek[2],kwoty,odcinek[4]));
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
        new ListaOdcinkow();
        String [][] dane= new String[lista.size()][9];
        for(int i=0;i<lista.size();i++)
        {
            dane[i][0]=lista.get(i).start();
            dane[i][1]=lista.get(i).koniec();
            dane[i][2]=lista.get(i).przewoznik();
            dane[i][3]=lista.get(i).samolot();
            dane[i][4]=lista.get(i).autobus();
            dane[i][5]=lista.get(i).prom();
            dane[i][6]=lista.get(i).samochod();
            dane[i][7]=lista.get(i).tuktuk();
            dane[i][8]=lista.get(i).wykluczenie();

        }
        return dane;
    }
}
