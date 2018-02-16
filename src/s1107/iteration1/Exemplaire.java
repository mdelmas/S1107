/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1107.iteration1;

import java.util.GregorianCalendar;

/**
 *
 * @author valentid
 */
public class Exemplaire {
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
    }
    
    public void setOuvrage(Ouvrage o) {
        ouvrage = o;
    }
    
    public void setDateRecepEx(Ouvrage o, GregorianCalendar dateRecepEx){
        if(EntreesSorties.ecrireDate(this.dateRecepEx).compareTo(EntreesSorties.ecrireDate(o.dateParution)) > 0 ){
            System.out.println("Erreur, la date de réception doit être inférieure à la date de publication de publication");
        }
        else{
            this.dateRecepEx = dateRecepEx;
        }
    }
    
    public void affiche(){
        System.out.println("Numéro d'exemplaire : " + numEx + ", Date de réception : " + EntreesSorties.ecrireDate(this.dateRecepEx));
    }
    
    
}
