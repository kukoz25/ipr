package org.example;

public class Znizka {
    private String nazwa;
    private double procent;

    Znizka(String n, double p)
    {
        this.nazwa=n;
        this.procent=p;
    }

    String dajnazwe() {return this.nazwa;};

    double dajwartosc() {return this.procent;}


}
