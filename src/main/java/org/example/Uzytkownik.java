package org.example;

public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private String login;
    private String email;
    private String haslo;

    Uzytkownik(String i, String n, String l,String e, String h)
    {
        this.imie=i;
        this.nazwisko=n;
        this.login=l;
        this.email=e;
        this.haslo=h;
    }

    String getdata()
    {
        //System.out.println(this.login+';'+this.haslo);
        return this.login+';'+this.haslo;

    };


}
