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
        System.out.println("AGE: " + lecteur.calculAge());
        
        GregorianCalendar dateParution = new GregorianCalendar(2015, 10, 1);
        Ouvrage ouvrage = new Ouvrage(1234567891234L, "Les fiancés de l'hiver", "Gallimard", dateParution, "Dabos", Public.ADO);

        GregorianCalendar dateRecepEx = new GregorianCalendar(2017, 9, 4);
        Exemplaire e1 = new Exemplaire(ouvrage, true, dateRecepEx, 1);
        Exemplaire e2 = new Exemplaire(ouvrage, true, dateRecepEx, 2);        
        Exemplaire e3 = new Exemplaire(ouvrage, false, dateRecepEx, 3);

        GregorianCalendar dateEmprunt = new GregorianCalendar();
        Emprunt emprunt = new Emprunt(lecteur, e1, dateEmprunt);
        emprunt.affiche();
        
        System.out.println("Exemplaire 1 dispo: " + e1.exemplaireDisponible());
        System.out.println("Exemplaire 2 dispo: " + e2.exemplaireDisponible());
        System.out.println("Exemplaire 3 dispo: " + e3.exemplaireDisponible());
        
        Public p = Public.ADO;
        System.out.println("AGE LIMITE ADO: " + p.getAgeLimite());
        
        
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
