package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListaPojazdow {
    private List<Pojazd> lista = new ArrayList<Pojazd>();

    ListaPojazdow()
    {
        lista.add(new Pojazd("Samolot","-"));
        lista.add(new Pojazd("Autobus","-"));
        lista.add(new Pojazd("Prom","-"));
        lista.add(new Pojazd("Samochód","-"));
        lista.add(new Pojazd("Tuk-Tuk","-"));
    }

    void zmienkwoty(String k[])
    {
        //new ListaPojazdow();
        for(int i=0;i<k.length;i++)
        {
            lista.get(i).zmienkwote(k[i]);
        }
    }

    String samolot()
    {
        return lista.get(0).dajkwote();
    }

    String autobus()
    {
       return lista.get(1).dajkwote();
    }

    String prom()
    {
        return lista.get(2).dajkwote();
    }

    String samochod()
    {
        return lista.get(3).dajkwote();
    }

    String tuktuk()
    {
        return lista.get(4).dajkwote();
    }


}
