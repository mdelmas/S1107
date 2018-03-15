/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1107.iteration1;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author delmasmo
 */
public class testEmprunt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GregorianCalendar dateNaiss = new GregorianCalendar(1993, 05, 07);
        Lecteur lecteur = new Lecteur("DELMAS", 1, "Morgane", dateNaiss, "Grenoble", "0612345678");
        
        GregorianCalendar dateParution = new GregorianCalendar(2015, 10, 1);
        Ouvrage ouvrage = new Ouvrage(1234567891234L, "Les fiancés de l'hiver", "Gallimard", dateParution, "Dabos", Public.ADO);

        GregorianCalendar dateRecepEx = new GregorianCalendar(2017, 9, 4);
        Exemplaire exemplaire = new Exemplaire(ouvrage, true, dateRecepEx, 1);
        Exemplaire ex1 = new Exemplaire(ouvrage, true, dateRecepEx, 2);
        Exemplaire ex2 = new Exemplaire(ouvrage, true, dateRecepEx, 3);

        GregorianCalendar dateEmprunt = new GregorianCalendar();
        GregorianCalendar dateJour = new GregorianCalendar();
        dateJour.add(GregorianCalendar.DAY_OF_MONTH, 14);
        Emprunt emprunt = new Emprunt(lecteur, exemplaire, dateEmprunt);
        emprunt.affiche();
        //emprunt.relanceEmprunt(dateJour);
        GregorianCalendar dateEmprunt2 = new GregorianCalendar();
        dateEmprunt2.add(GregorianCalendar.DAY_OF_MONTH, 300);
        Emprunt em1 = new Emprunt(lecteur, ex1, dateEmprunt2);
        GregorianCalendar dateEmprunt3 = new GregorianCalendar();
        dateEmprunt3.add(GregorianCalendar.DAY_OF_MONTH, -60);
        Emprunt em2 = new Emprunt(lecteur, ex2, dateEmprunt3);
        
        
        Bibliotheque b = new Bibliotheque();
        
        
        
        
        // TODO code application logic here
        /*GregorianCalendar date = new GregorianCalendar();
        System.out.println(date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH)+1) + "/" + date.get(Calendar.YEAR));
        GregorianCalendar date2 = new GregorianCalendar(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH), date.get(GregorianCalendar.DATE) + 8);
        System.out.println(date2.get(Calendar.DAY_OF_MONTH) + "/" + (date2.get(Calendar.MONTH)+1) + "/" + date2.get(Calendar.YEAR));
*/
    }
    /*
    	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
	*/
}
