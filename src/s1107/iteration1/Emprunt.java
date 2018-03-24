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
 * @author delmasmo
 */
public class Emprunt implements Serializable
{

    private static final long serialVersionUID = 48L;

    // -----------------------------------------------
    // Attributs
    // -----------------------------------------------
    
    private Lecteur lecteur;
    private Exemplaire exemplaire;
    private GregorianCalendar dateEmprunt;
    private GregorianCalendar dateRetour;
    final int DUREE_EMPRUNT = 8;

    
    // -----------------------------------------------
    // Constructeur
    // -----------------------------------------------

    Emprunt(Lecteur lecteur, Exemplaire exemplaire, GregorianCalendar dateEmprunt) 
    {
        setLecteur(lecteur);
        setExemplaire(exemplaire);
        lecteur.affecterEmprunt(this);
        exemplaire.affecterEmprunt(this);
        setDateEmprunt(dateEmprunt);
        dateRetour = new GregorianCalendar(dateEmprunt.get(GregorianCalendar.YEAR), dateEmprunt.get(GregorianCalendar.MONTH), dateEmprunt.get(GregorianCalendar.DATE) + DUREE_EMPRUNT);
    }

    
    // -----------------------------------------------
    // Getters
    // -----------------------------------------------

    public Lecteur getLecteur() 
    {
        return lecteur;
    }

    public Exemplaire getExemplaire() 
    {
        return exemplaire;
    }

    public GregorianCalendar getDateEmprunt() 
    {
        return dateEmprunt;
    }

    public GregorianCalendar getDateRetour() 
    {
        return dateRetour;
    }

    // -----------------------------------------------
    // Setters
    // -----------------------------------------------

    private void setLecteur(Lecteur lecteur) 
    {
        this.lecteur = lecteur;
    }

    private void setExemplaire(Exemplaire exemplaire) 
    {
        this.exemplaire = exemplaire;
    }

    private void setDateEmprunt(GregorianCalendar dateEmprunt) 
    {
        this.dateEmprunt = dateEmprunt;
    }

    private void setDateRetour(GregorianCalendar dateRetour) 
    {
        this.dateRetour = dateRetour;
    }
    
    /**
     * Retire le lien avec le lecteur
     */
    private void unSetLecteur() 
    {
       lecteur = null;
    }

    /**
     * Retire le lien avec l'exemplaire
     */
    private void unSetExemplaire() 
    {
       exemplaire = null;
    }


    // -----------------------------------------------
    // Méthodes publiques
    // -----------------------------------------------

    /**
     * Contrôle si une relance est à effectuer et lance l'affichage des informations de l'emprunt
     */
    public boolean relanceEmprunt(GregorianCalendar dateJour)
    {
    //    boolean relancesAFaire = false;
        if (aRelancer(dateJour) == true){
            Lecteur L = getLecteur();
            Exemplaire ex = getExemplaire();
            L.afficherLecteurRelance();
            afficherEmprunt();
            System.out.println("");
            return true;
        }
        return false;
    /*    if (relancesAFaire == false){
            EntreesSorties.afficherMessage("Aucune relance à effectuer");
        }*/
    }
    
    /**
     * Cherche le Lecteur associé à l'emprunt et supprime le lien à l'Emprunt
     * supprime les liens avec le Lecteur et l'Exemplaire
     */
    public void supprimerEmprunt() 
    {
        Lecteur L = getLecteur();
        L.supprimerEmprunt(this);
        unSetLecteur();
        unSetExemplaire();
    }

    /**
    Contrôle si l'emprunt en cours date de 15 jours ou plus, renvoie vrai si oui
    */
    private boolean aRelancer(GregorianCalendar dateJour)
    {
        GregorianCalendar dateRelance = new GregorianCalendar(dateEmprunt.get(GregorianCalendar.YEAR), dateEmprunt.get(GregorianCalendar.MONTH), dateEmprunt.get(GregorianCalendar.DATE));
        dateRelance.add(GregorianCalendar.DAY_OF_MONTH, 15);
        return dateRelance.before(dateJour) || dateRelance.equals(dateJour);
    }

 
    // Méthodes affichage
    
    public void afficherCreationEmprunt() 
    {
        Lecteur l = getLecteur();
        Exemplaire ex = getExemplaire();
        
        System.out.print("Lecteur n°" + l.getNumLecteur() + " a emprunté l'");
        ex.afficherExemplaireLight();
        System.out.println("Date emprunt: " + EntreesSorties.ecrireDate(getDateEmprunt()));
    }

    public void afficherEmprunt() 
    {
        Exemplaire ex = getExemplaire();
        
        ex.afficherExemplaireLight();
        System.out.print("Date emprunt: " + EntreesSorties.ecrireDate(getDateEmprunt()));
        System.out.println(", date retour: " + EntreesSorties.ecrireDate(getDateRetour()));
    }

}
