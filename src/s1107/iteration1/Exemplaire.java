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
    
    //Getters & setters
    
    private void setOuvrage(Ouvrage o) {
        ouvrage = o;
    }
    
    public void setDateRecepEx(GregorianCalendar dateRecepEx){
            this.dateRecepEx = dateRecepEx;
    }
    
    private void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }
    /**
    Affiche le numéro d'exemplaire pour la relance
    */
    private void afficheRelance(){
        System.out.print(", numéro exemplaire : "+ getNumEx());
    }
    
    /**
    Affiche les informations nécessaires à la relance
    */
    public void infosRelance(){
        Ouvrage o = getOuvrage();
        o.afficheOuvrageLight();
        afficheRelance();
    }
    
    /**
     * Affiche les informations de l'exemplaire
     */
    public void affiche(){
        EntreesSorties.afficherMessage("Numéro d'exemplaire : " + numEx + ", date réception : " + EntreesSorties.ecrireDate(dateRecepEx));
        if (empruntable)
            EntreesSorties.afficherMessage("Empruntable");
        else
            EntreesSorties.afficherMessage("Non empruntable");
    }
        
    /**
     * Vérifie si l'exemplaire est empruntable et s'il n'a pas été emprunté, 
     * retourne vrai si les 2 sont vrais, faux sinon
     * @return 
     */
    public boolean exemplaireDisponible() {
        if (empruntable == true && emprunt == null)
            return true;
        return false;
    }
    
    public void affecterEmprunt(Emprunt emprunt) {
        setEmprunt(emprunt);
    } 
    
    /**
     * Affiche les informations de l'exemplaire, affichage réduit
     */
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
    
    /**
     * Retrouve l'Emprunt associé à l'Exemplaire, lui demande de supprimer le lien avec l'emprunt
     * supprime le lien entre l'exemplaire et l'emprunt
     */
    public void supprimerEmprunt() {
       Emprunt em = getEmprunt();
       if(em != null) {
           em.supprimerEmprunt();
           unSetEmprunt();
       } else {
           EntreesSorties.afficherMessage("Cet exemplaire n'a pas été emprunté");
       }
    }
    
    private void unSetEmprunt() {
       emprunt = null;
    } 
    
}
