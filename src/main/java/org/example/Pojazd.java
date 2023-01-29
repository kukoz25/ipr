package org.example;

public class Pojazd {
    private String nazwa;
    private String kwota;

    Pojazd(String n, String k)
    {
        this.nazwa=n;
        this.kwota=k;
    }

    void zmienkwote(String k)
    {
        this.kwota=k;
    }

    String dajkwote(){
        return this.kwota;
    }
}
