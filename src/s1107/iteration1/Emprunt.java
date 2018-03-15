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
public class Emprunt {
    
    private Lecteur lecteur;
    private Exemplaire exemplaire;
    private GregorianCalendar dateEmprunt;
    private GregorianCalendar dateRetour;
    final int DUREE_EMPRUNT = 8;
    
    Emprunt(Lecteur lecteur, Exemplaire exemplaire, GregorianCalendar dateEmprunt) {
        setLecteur(lecteur);
        setExemplaire(exemplaire);
        setDateEmprunt(dateEmprunt);
        dateRetour = new GregorianCalendar(dateEmprunt.get(GregorianCalendar.YEAR), dateEmprunt.get(GregorianCalendar.MONTH), dateEmprunt.get(GregorianCalendar.DATE) + DUREE_EMPRUNT);
    }
    
    private void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }
    
    public Lecteur getLecteur() {
        return lecteur;
    }
    
    private void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }
    
    public Exemplaire getExemplaire() {
        return exemplaire;
    }
    
    private void setDateEmprunt(GregorianCalendar dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }
    
    public GregorianCalendar getDateEmprunt() {
        return dateEmprunt;
    }
    
    private void setDateRetour(GregorianCalendar dateRetour) {
        this.dateRetour = dateRetour;
    }
    
    public GregorianCalendar getDateRetour() {
        return dateRetour;
    }
    
    /*
    Contrôle si l'emprunt en cours date de 15 jours ou plus, renvoie vrai si oui
    */
    private boolean aRelancer(GregorianCalendar dateJour){
        GregorianCalendar dateRelance = getDateEmprunt();
        dateRelance.add(GregorianCalendar.DAY_OF_MONTH, 15);
        return dateRelance.before(dateJour) || dateRelance.equals(dateJour);
    }
    
    //Contrôle si une relance est à effectuer et lance l'affichage des informations de l'emprunt
    public void relanceEmprunt(GregorianCalendar dateJour){
        boolean verif = aRelancer(dateJour);
        if(verif==true){
            Lecteur L = getLecteur();
            Exemplaire ex = getExemplaire();
            L.afficherLecteurRelance();
            ex.infosRelance();
            afficheDateEmprunt();
        }
    }
    
    //Affiche la date de l'emprunt
    private void afficheDateEmprunt(){
        System.out.println(", date d'emprunt : " + EntreesSorties.ecrireDate(getDateEmprunt()));
        System.out.println("-----------------------------------");
        
    }

    //////
    // AFFCHAGE NON FINAL
    
    public void affiche() {
        System.out.println("Emprunt: ");
        System.out.println("Lecteur: " + lecteur.getNom() + " " + lecteur.getPrenom());
        Ouvrage o = exemplaire.getOuvrage();
        System.out.println("Exemplaire: " + o.getTitre() + " - " + o.getIsbn() + ", ex n°" + exemplaire.getNumEx());
        System.out.print("Date emprunt: " + EntreesSorties.ecrireDate(getDateEmprunt()));
        System.out.println(", date retour: " + EntreesSorties.ecrireDate(getDateRetour()));
    }

    ////////
    
}
