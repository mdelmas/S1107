/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1107.iteration1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author delmasmo
 */
public class testEmprunt {

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";
        public static final String ANSI_GRAY = "\u001B[1m";

        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(Color.BLACK + "Ceci est un test." + Color.RESET);        
        System.out.println(Color.GRAY + "Ceci est un test." + Color.RESET);        
        System.out.println(Color.RED + "Ceci est un test." + Color.RESET);        
        System.out.println(Color.GREEN + "Ceci est un test." + Color.RESET);        
        System.out.println(Color.YELLOW + "Ceci est un test." + Color.RESET);        
        System.out.println(Color.BLUE + "Ceci est un test." + Color.RESET);        
        System.out.println(Color.PURPLE + "Ceci est un test." + Color.RESET);        
        System.out.println(Color.CYAN + "Ceci est un test." + Color.RESET);        
        System.out.println(Color.WHITE + "Ceci est un test." + Color.RESET);        
        
      /*  GregorianCalendar dateNaiss = new GregorianCalendar(1993, 05, 07);
        Lecteur lecteur = new Lecteur("DELMAS", 1, "Morgane", dateNaiss, "Grenoble", "0612345678");
        
        GregorianCalendar dateParution = new GregorianCalendar(2015, 10, 1);
        Ouvrage ouvrage = new Ouvrage(1234567891234L, "Les fiancés de l'hiver", "Gallimard", dateParution, "Dabos", Public.ADO);

        GregorianCalendar dateRecepEx = new GregorianCalendar(2017, 9, 4);
        Exemplaire exemplaire = new Exemplaire(ouvrage, true, dateRecepEx, 1);

        GregorianCalendar dateEmprunt = new GregorianCalendar();
        Emprunt emprunt = new Emprunt(lecteur, exemplaire, dateEmprunt);
        emprunt.affiche();

        System.out.println("test");*/
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
