package org.example;

public class Ograniczenie {

    private String typ;
    private String opis;

    Ograniczenie(String typ, String opis){
        this.typ = typ;
        this.opis = opis;
    }
    public static boolean czypoprawne(String n)
    {
        if(n.isEmpty())
        {
            return false;
        }
        else return true;
    }

    String dajTyp(){
        return this.typ;
    }

    String dajOpis(){
        return this.opis;
    }
}
