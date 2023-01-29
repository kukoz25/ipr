package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;

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
                System.out.println(klient.length);
                if(klient.length>5){
                    this.lista.add(new Klient(klient[0],klient[1],klient[2],klient[3],klient[4],klient[5]));
                }
                else{
                    this.lista.add(new Klient(klient[0],klient[1],klient[2],klient[3],klient[4],""));
                }
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

    public static String[][] daneZnizki(String tableEmail)
    {
        new ListaKlientow();

        for(int i=0;i<lista.size();i++){
            if (lista.get(i).dajmail().equals(tableEmail)){
                String [][] dane= new String[lista.get(i).dajZnizki().size()][3];

                for(int j=0;j<lista.get(i).dajZnizki().size();j++)
                {
                    dane[j][0]=lista.get(i).dajmail();
                    dane[j][1]=lista.get(i).dajZnizki().get(j).dajnazwe();
                    dane[j][2]= String.valueOf(lista.get(i).dajZnizki().get(j).dajwartosc());
                }
                return dane;
            }
        }
        return new String[0][];
    }

    public static void dodajZnizke(String wybranyEmail, String nazwaZnizki, String wielkoscZnizki) {

        for(int i=0;i<lista.size();i++){

            if (lista.get(i).dajmail().equals(wybranyEmail)){
                lista.get(i).dodajZnizke(nazwaZnizki, wielkoscZnizki);
            }
        }
    }


    public static void usunZnizke(String tableEmail, String wartoscWybranejZnizki, String nazwaWybranejZnizki) {

        for(int i=0;i<lista.size();i++){
            if (lista.get(i).dajmail().equals(tableEmail)){
                lista.get(i).usunZnizke(wartoscWybranejZnizki, nazwaWybranejZnizki);
            }
        }
    }

    public static void dopisDoCSV()throws Exception{

        String fileName = "C:\\Users\\rainb\\IdeaProjects\\IPR_main\\klienci.csv";
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for(int i=0;i<lista.size();i++){
            String linijka = lista.get(i).dajimie() + "," + lista.get(i).dajnazwisko() + "," + lista.get(i).dajmail() + "," + lista.get(i).dajnumer() + "," + lista.get(i).dajkraj() + ",";
            for(int j=0;j<lista.get(i).dajZnizki().size();j++){
                linijka = linijka + lista.get(i).dajZnizki().get(j).dajnazwe() + "-" + lista.get(i).dajZnizki().get(j).dajwartosc()+ ";";
            }
            bufferedWriter.write(linijka + "\n");
        }
        bufferedWriter.close();
    }
}
