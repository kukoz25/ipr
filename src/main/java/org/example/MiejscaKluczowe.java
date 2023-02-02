package org.example;

import java.util.ArrayList;
import java.util.List;

public class MiejscaKluczowe {
    private String nazwa;
    private String kraj;

    private List<Ograniczenie> listaOgraniczen;

    MiejscaKluczowe(String n, String k, String o) {
        this.nazwa = n;
        this.kraj = k;
        String tmp[]=o.split(";");
        //System.out.println(tmp[0]);
        //System.out.println(tmp.length);
        if(tmp.length>=1)
        {
            listaOgraniczen=new ArrayList<Ograniczenie>();
            for(int i=0;i< tmp.length;i++)
            {
                String tmp2[]=tmp[i].split("-");
                //System.out.println(tmp2.length);
                if(tmp2.length>1)
                {
                    //System.out.println(tmp2[0]+"+"+tmp2[1]);
                    //System.out.println(tmp2[0]+"+"+tmp2[1]);
                    listaOgraniczen.add(new Ograniczenie(tmp2[0],tmp2[1]));
                }
            }
        }
    }

    String dajnazwe() {
        return this.nazwa;
    }

    String dajkraj() {
        return this.kraj;
    }

    public String [][] dajograniczenia() {
        if (listaOgraniczen != null) {
            //System.out.println(this.kraj+"+"+this.nazwa);
            String dane[][] = new String[listaOgraniczen.size()][2];
            for (int i = 0; i < listaOgraniczen.size(); i++) {
                //System.out.println(listaOgraniczen.get(i).dajTyp()+" "+listaOgraniczen.get(i).dajOpis());
                dane[i][0] = listaOgraniczen.get(i).dajTyp();
                dane[i][1] = listaOgraniczen.get(i).dajOpis();
            }
            return dane;
        }
        else
        { String dane[][]=null;
            return dane;
        }
    }



}
