/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1107.iteration1;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author valentid
 */
public class Exemplaire implements Serializable {
    
    private static final long serialVersionUID = 290L;
    
    private boolean empruntable;
    private GregorianCalendar dateRecepEx;
    private int numEx;
    private Ouvrage ouvrage;
    
    Exemplaire(Ouvrage o, boolean empruntable, GregorianCalendar dateRecepEx){
        this.setOuvrage(o);
        this.empruntable = empruntable;
        this.setDateRecepEx(o,dateRecepEx);
        numEx = o.getDerNumEx() + 1;
        o.setDerNumEx(numEx);
        o.setExemplaire(numEx, this);
    }
    
    public void setOuvrage(Ouvrage o) {
        ouvrage = o;
    }
    
    public void setDateRecepEx(Ouvrage o, GregorianCalendar dateRecepEx){
    //    if(EntreesSorties.ecrireDate(this.dateRecepEx).compareTo(EntreesSorties.ecrireDate(o.getDateParution())) > 0 ){
    //        System.out.println("Erreur, la date de réception doit être inférieure à la date de publication de publication");
    //    }
    //    else{
            this.dateRecepEx = dateRecepEx;
    //    }
    }
    
    public void affiche(){
        System.out.print("Numéro d'exemplaire : " + numEx);
        System.out.print(", date réception : " + dateRecepEx.get(Calendar.DAY_OF_MONTH) + "." + dateRecepEx.get(Calendar.MONTH) + "." + dateRecepEx.get(Calendar.YEAR));
        if (empruntable)
            System.out.println(", empruntable");
        else
            System.out.println(", non empruntable");
        //    System.out.println("Numéro d'exemplaire : " + numEx + ", Date de réception : " + EntreesSorties.ecrireDate(this.dateRecepEx));
    }
    
    
}
