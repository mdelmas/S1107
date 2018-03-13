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
    
    Exemplaire(Ouvrage o, boolean empruntable, GregorianCalendar dateRecepEx, int numEx) {
        this.setOuvrage(o);
        this.empruntable = empruntable;
        this.setDateRecepEx(o,dateRecepEx);
        this.numEx = numEx;
    }
    
    public void setOuvrage(Ouvrage o) {
        ouvrage = o;
    }
    
    public void setDateRecepEx(Ouvrage o, GregorianCalendar dateRecepEx){
            this.dateRecepEx = dateRecepEx;
    }
    
    public void affiche(){
        System.out.print("Numéro d'exemplaire : " + numEx + ", ");
        System.out.print("date réception : " + EntreesSorties.ecrireDate(dateRecepEx));
        if (empruntable)
            System.out.println(", empruntable");
        else
            System.out.println(", non empruntable");
    }
        
    //////
    // RAJOUT POUR L'AFFICHAGE D'EMPRUNT - PEUT ETRE PAS A GARDER
    
    public Ouvrage getOuvrage() {
        return ouvrage;
    }
    
    public int getNumEx() {
        return numEx;
    }
    
    //////
    
}
