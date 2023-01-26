package org.example;

import javax.swing.*;

public class Weryfikuj {
    public static void werifikuj(String dane) {
        //System.out.println(dane);
        if (ListaUzytkownikow.sprawdzdane(dane)) {
            new Main_menu();
//System.out.println("chuj");
        }
        else {
            JOptionPane.showMessageDialog(null, "Błędne dane logowanie");
            new Login();
        }
    }
}
