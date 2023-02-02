package org.example;

public class MiejscaKluczowe {
    private String nazwa;
    private String kraj;

    private Ograniczenie listaOgraniczen[];

    MiejscaKluczowe(String n, String k, Ograniczenie listaOgraniczen[]) {
        this.nazwa = n;
        this.kraj = k;
        this.listaOgraniczen = listaOgraniczen;
    }

    String dajnazwe() {
        return this.nazwa;
    }

    String dajkraj() {
        return this.kraj;
    }

    Ograniczenie[] dajOgraniczenia(){ return this.listaOgraniczen; }
}
