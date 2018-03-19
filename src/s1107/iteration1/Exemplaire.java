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
    private Emprunt emprunt;
    
    Exemplaire(Ouvrage o, boolean empruntable, GregorianCalendar dateRecepEx, int numEx) {
        this.setOuvrage(o);
        this.empruntable = empruntable;
        this.setDateRecepEx(dateRecepEx);
        this.numEx = numEx;
    }
    
    public void setOuvrage(Ouvrage o) {
        ouvrage = o;
    }
    
    public void setDateRecepEx(GregorianCalendar dateRecepEx){
            this.dateRecepEx = dateRecepEx;
    }
    
    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }
    /*
    Affiche le numéro d'exemplaire pour la relance
    */
    public void afficheRelance(){
        System.out.print(", numéro exemplaire : "+ getNumEx());
    }
    
    /*
    Affiche les informations nécessaires à la relance
    */
    public void infosRelance(){
        Ouvrage o = getOuvrage();
        o.afficheOuvrageLight();
        afficheRelance();
    }
    
    public void affiche(){
        EntreesSorties.afficherMessage("Numéro d'exemplaire : " + numEx + ", date réception : " + EntreesSorties.ecrireDate(dateRecepEx));
        if (empruntable)
            EntreesSorties.afficherMessage("Empruntable");
        else
            EntreesSorties.afficherMessage("Non empruntable");
    }
        
    public boolean exemplaireDisponible() {
        if (empruntable == true && emprunt == null)
            return true;
        return false;
    }
    
    public void affecterEmprunt(Emprunt emprunt) {
        setEmprunt(emprunt);
    } 
    
    public void afficherExemplaireLight() {
        Ouvrage o = getOuvrage();
        o.afficheOuvrageLight();
        EntreesSorties.afficherMessage("   N° d'exemplaire: " + getNumEx());
    }
    
    //////
    // RAJOUT POUR L'AFFICHAGE D'EMPRUNT - PEUT ETRE PAS A GARDER
    
    public Ouvrage getOuvrage() {
        return ouvrage;
    }
    
    public int getNumEx() {
        return numEx;
    }
    
    public Emprunt getEmprunt() {
       return emprunt;
    }
    
    public void supprimerEmprunt() {
       Emprunt em = getEmprunt();
       if(em != null) {
           em.supprimerEmprunt();
           unSetEmprunt();
       } else {
           EntreesSorties.afficherMessage("Cet exemplaire n'a pas été emprunté");
       }
    }
    
    public void unSetEmprunt() {
       emprunt = null;
    } 
    
}
