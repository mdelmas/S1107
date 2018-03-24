/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1107.iteration1;

import java.io.Serializable;
import java.util.Calendar; 
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author delmasmo
 */
public class Ouvrage implements Serializable
{
    
    private static final long serialVersionUID = 456L;
    
    // -----------------------------------------------
    // Attributs
    // -----------------------------------------------

    private long isbn;
    private String titre;
    private String nomEditeur;
    private GregorianCalendar dateParution;
    private String nomAuteur;
    private Public publicVise;
    private int derNumEx = 0;
    private HashMap<Integer, Exemplaire> exemplaires;
    

    // -----------------------------------------------
    // Constructeur
    // -----------------------------------------------

    public Ouvrage(long isbn, String titre, String nomEditeur, GregorianCalendar dateParution, String nomAuteur, Public publicVise) 
    {
        setIsbn(isbn);
        setTitre(titre);
        setNomEditeur(nomEditeur);
        setDateParution(dateParution);
        setNomAuteur(nomAuteur);
        setPublicVise(publicVise);
        exemplaires = new HashMap<>();
    }
    

    // -----------------------------------------------
    // Getters
    // -----------------------------------------------
    
    public long getIsbn() 
    {
        return isbn;
    }
    
    public String getTitre() 
    {
        return titre;
    }
    
    public String getNomEditeur() 
    {
        return nomEditeur;
    }
    
    public GregorianCalendar getDateParution() 
    {
        return dateParution;
    }
    
    public String getNomAuteur() 
    {
        return nomAuteur;
    }
    
    public Public getPublicVise() 
    {
        return publicVise;
    }
    
    public int getDerNumEx() 
    {
        return derNumEx;
    }
    
    /**
     * Retourne l'exemplaire numEx rattaché à l'ouvrage
     */
    public Exemplaire getExemplaire(int numEx) 
    {
        return exemplaires.get(numEx);
    }
    
    
    // -----------------------------------------------
    // Setters
    // -----------------------------------------------

    private void setIsbn(long isbn) 
    {
        this.isbn = isbn;
    }
    
    private void setTitre(String titre) 
    {
        this.titre = titre;
    }
    
    private void setNomEditeur(String nomEditeur) 
    {
        this.nomEditeur = nomEditeur;
    }
    
    private void setDateParution(GregorianCalendar dateParution) 
    {
        this.dateParution = dateParution;
    }
    
    private void setNomAuteur(String nomAuteur) 
    {
        this.nomAuteur = nomAuteur;
    }
    
    private void setPublicVise(Public publicVise) 
    {
        this.publicVise = publicVise;
    }
    
    private void setDerNumEx(int derNumEx) 
    {
        this.derNumEx = derNumEx;
    }
    
    /**
     * Rattache un exemplaire donné à l'ouvrage
     */
    private void setExemplaire(int numEx, Exemplaire e) 
    {
        exemplaires.put(numEx, e);
    }
    

    // -----------------------------------------------
    // Méthodes
    // -----------------------------------------------

    /**
     * Incrémente le dernier numéro d'exemplaire de la Classe
     */
    public void incDerNumEx()
    {
        derNumEx = derNumEx + 1;
    }
    
    /**
     * Crée un exemplaire empruntable, le rattache à l'ouvrage, incrémente le dernier numéro d'exemplaire
     * @param dateRecepEx
     * @param nbExEmpruntables 
     */
    public void ajouterExemplairesEmpruntables(GregorianCalendar dateRecepEx, int nbExEmpruntables) 
    {
        for (int i = 0; i < nbExEmpruntables; i++) {
            incDerNumEx();
            Exemplaire nouveau = new Exemplaire(this, true, dateRecepEx, derNumEx);
            setExemplaire(derNumEx, nouveau);
            nouveau.affiche();
        }
    }
    
    /**
     * Crée un exemplaire non-empruntable, le rattache à l'ouvrage, incrémente le dernier numéro d'exemplaire
     * @param dateRecepEx
     * @param nbExNonEmpruntables 
     */
    public void ajouterExemplairesNonEmpruntables(GregorianCalendar dateRecepEx, int nbExNonEmpruntables) 
    {
        for (int i = 0; i < nbExNonEmpruntables; i++) {
            incDerNumEx();
            Exemplaire nouveau = new Exemplaire(this, false, dateRecepEx, derNumEx);
            setExemplaire(derNumEx, nouveau);
            nouveau.affiche();
        }
    }
    
    
    // Méthodes d'affichage
    
    /**
     * Affiche les informations de l'ouvrage, version réduite
     */
    public void afficheOuvrageLight() 
    {
        System.out.print("Ouvrage n°" + getIsbn() + ", titre : " + getTitre());
    }
    
    /**
     * Affiche les informations complètes de l'ouvrage
     */
    public void afficheOuvrage() 
    {
        System.out.println("Ouvrage n°" + getIsbn());
        System.out.println("Titre : " + getTitre());
        System.out.println("Nom auteur : " + getNomAuteur() + ", nom éditeur : " + getNomEditeur());
        System.out.print("Date parution : " + EntreesSorties.ecrireDate(getDateParution()) + ", ");
        System.out.println("public : " + getPublicVise());
    }
    
    /**
     * Affiche tous les exemplaires rattachés à l'ouvrage
     */
    public void afficheExemplaires() 
    {
        afficheOuvrageLight();
        if (exemplaires.size() == 0)
            System.out.println("Aucun exemplaire.");
        else {
            System.out.println(exemplaires.size() + " exemplaires :");
            for (Exemplaire exemplaire: exemplaires.values()) {
                exemplaire.affiche();
            }
        }
    }
            
}
