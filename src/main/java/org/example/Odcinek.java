package org.example;

public class Odcinek {
    private MiejscaKluczowe poczatek;
    private MiejscaKluczowe koniec;
    private Przewoznik przewoznik;
    private ListaPojazdow pojazdy=new ListaPojazdow();;
    private String wykluczenie;

    Odcinek(String p, String k, String g, String wrum[], String w) {
        this.poczatek = ListaMiejsc.dajmiejsce(p);
        this.koniec = ListaMiejsc.dajmiejsce(k);
        //new ListaPrzewoznikow();
        this.przewoznik = ListaPrzewoznikow.dajprzewoznika(g);
        //this.przewoznik=new Przewoznik("chuj");
        pojazdy.zmienkwoty(wrum);
        this.wykluczenie = w;

    }

    String start()
    {
        return this.poczatek.dajnazwe();
    }

    String koniec()
    {
        return this.koniec.dajnazwe();
    }
    String przewoznik() {
        return this.przewoznik.dajnazwe();
    }

    String samolot() {
        return pojazdy.samolot();
    }

    String autobus() {
        return pojazdy.autobus();
    }

    String prom() {
        return pojazdy.prom();
    }

    String samochod() {
        return pojazdy.samochod();
    }

    String tuktuk() {
        return pojazdy.tuktuk();
    }

    String wykluczenie() {
        return this.wykluczenie;
    }

}
