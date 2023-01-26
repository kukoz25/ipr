package org.example;

public class MiejscaKluczowe {
    private String nazwa;
    private String kraj;

    MiejscaKluczowe(String n, String k) {
        this.nazwa = n;
        this.kraj = k;
    }

    String dajnazwe() {
        return this.nazwa;
    }

    String dajkraj() {
        return this.kraj;
    }
}
