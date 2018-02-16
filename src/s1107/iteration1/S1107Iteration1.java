/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1107.iteration1;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author delmasmo
 */
public class S1107Iteration1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GregorianCalendar dateParution = new GregorianCalendar(2002, 9, 21);

        Ouvrage ouvrage1 = new Ouvrage(1111, "Ouvrage 1", "Editeur 1", dateParution, "Auteur 1", Public.ADO);
        ouvrage1.afficheOuvrage();
        ouvrage1.afficheExemplaires();
        
        GregorianCalendar d = new GregorianCalendar(2017, 2, 16);
        ouvrage1.ajouterExemplairesEmpruntables(d, 4);
        ouvrage1.ajouterExemplairesNonEmpruntables(d, 3);
        ouvrage1.afficheExemplaires();

    }
    
}
