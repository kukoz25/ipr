package org.example;

public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;

    Uzytkownik(String i, String n, String e, String h)
    {
        this.imie=i;
        this.nazwisko=n;
        this.email=e;
        this.haslo=h;
    }

    String getdata()
    {
        //System.out.println(this.email+';'+this.haslo);
        return this.email+';'+this.haslo;

    };


}
