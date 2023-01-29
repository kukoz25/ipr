package org.example;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String imie;
    private String nazwisko;
    private String mail;
    private String telefon;
    private String kraj;
    private List<Znizka> lista;


    Klient(String i, String n, String m, String t, String k, String z) {
        this.imie = i;
        this.nazwisko = n;
        this.mail = m;
        this.telefon = t;
        this.kraj = k;

        this.lista =new ArrayList<Znizka>();

        if(!z.equals("")){
            String tmp[] = z.split(";");
            for (int j = 0; j < tmp.length; j++) {
                String[] tmp2 = tmp[j].split("-");
                lista.add(new Znizka(tmp2[0], Double.parseDouble(tmp2[1])));
            }
        }
    }

    String dajimie() {return this.imie;}

    String dajnazwisko() {return this.nazwisko;}

    String dajmail() {return this.mail;}

    String dajnumer() {return this.telefon;}

    String dajkraj() {return this.kraj;}

    List<Znizka> dajZnizki() { return this.lista;}


    public void dodajZnizke(String nazwaZnizki, String wielkoscZnizki) {
        lista.add(new Znizka(nazwaZnizki, Double.parseDouble(wielkoscZnizki)));
    }


    public void usunZnizke(String wielkoscZnizki, String nazwaZnizki) {
        for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).dajnazwe().equals(nazwaZnizki) && lista.get(i).dajwartosc() == Integer.parseInt(wielkoscZnizki)){
                lista.remove(i);
            }
        }
    }
}
