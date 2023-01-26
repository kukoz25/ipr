package org.example;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String imie;
    private String nazwisko;
    private String mail;
    private String telefon;
    private String kraj;

    List<Znizka> znizki;

    Klient(String i, String n, String m, String t, String k, String z) {
        this.imie = i;
        this.nazwisko = n;
        this.mail = m;
        this.telefon = t;
        this.kraj = k;
        znizki = new ArrayList<Znizka>();
        String tmp[] = z.split(";");
        for (int j = 0; j < tmp.length; j++) {
            String[] tmp2 = tmp[j].split("-");
            znizki.add(new Znizka(tmp2[0], Double.parseDouble(tmp2[1])));
        }
    }

    String dajimie() {
        return this.imie;
    }

    String dajnazwisko() {
        return this.nazwisko;
    }

    String dajmail() {
        return this.mail;
    }

    String dajnumer() {
        return this.telefon;
    }

    String dajkraj() {
        return this.kraj;
    }
}
