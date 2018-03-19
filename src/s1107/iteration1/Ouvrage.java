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
public class Ouvrage implements Serializable{
    
    private static final long serialVersionUID = 456L;
    
    private long isbn;
    private String titre;
    private String nomEditeur;
    private GregorianCalendar dateParution;
    private String nomAuteur;
    private Public publicVise;
    private int derNumEx = 0;
    private HashMap<Integer, Exemplaire> exemplaires;
    
    public Ouvrage(long isbn, String titre, String nomEditeur, GregorianCalendar dateParution, String nomAuteur, Public publicVise) {
        setIsbn(isbn);
        setTitre(titre);
        setNomEditeur(nomEditeur);
        setDateParution(dateParution);
        setNomAuteur(nomAuteur);
        setPublicVise(publicVise);
        exemplaires = new HashMap<>();
    }
    
    // Getters & Setters
    
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    
    public long getIsbn() {
        return isbn;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }
    
    public String getNomEditeur() {
        return nomEditeur;
    }
    
    public void setDateParution(GregorianCalendar dateParution) {
        this.dateParution = dateParution;
    }
    
    public GregorianCalendar getDateParution() {
        return dateParution;
    }
    
    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }
    
    public String getNomAuteur() {
        return nomAuteur;
    }
    
    public void setPublicVise(Public publicVise) {
        this.publicVise = publicVise;
    }
    
    public Public getPublicVise() {
        return publicVise;
    }
    
    public void setDerNumEx(int derNumEx) {
        this.derNumEx = derNumEx;
    }
    
    public int getDerNumEx() {
        return derNumEx;
    }
    
    /**
     * Incrémente le dernier numéro d'exemplaire de la Classe
     */
    public void incDerNumEx(){
        derNumEx = derNumEx + 1;
    }
    
    /**
     * Affiche les informations de l'ouvrage, version réduite
     */
    public void afficheOuvrageLight() {
        System.out.println("Ouvrage :");
        System.out.println("ISBN: " + getIsbn() + ", titre : " + getTitre());
    }
    
    /**
     * Affiche les informations complètes de l'ouvrage
     */
    public void afficheOuvrage() {
        this.afficheOuvrageLight();
        System.out.print("nom auteur : " + getNomAuteur() + ", ");
        System.out.println("date parution : " + EntreesSorties.ecrireDate(getDateParution()));
        System.out.println("nom éditeur : " + getNomEditeur() + ", public : " + getPublicVise());
    }
    
    /**
     * Affiche tous les exemplaires rattachés à l'ouvrage
     */
    public void afficheExemplaires() {
        afficheOuvrageLight();
        for(Map.Entry<Integer, Exemplaire> entry : exemplaires.entrySet()) {
            Exemplaire exemplaire = entry.getValue();
            exemplaire.affiche();
        }
    }
    
    /**
     * Retourne l'ensemble des exemplaires rattachés à l'ouvrage
     */
    public Exemplaire getExemplaire(int numEx) {
        return exemplaires.get(numEx);
    }
    
    /**
     * Rattache un exemplaire donné à l'ouvrage
     */
    public void setExemplaire(int numEx, Exemplaire e) {
        exemplaires.put(numEx, e);
    }
    
    /**
     * Crée un exemplaire empruntable, le rattache à l'ouvrage, incrémente le dernier numéro d'exemplaire
     * @param dateRecepEx
     * @param nbExEmpruntables 
     */
    public void ajouterExemplairesEmpruntables(GregorianCalendar dateRecepEx, int nbExEmpruntables) {
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
    public void ajouterExemplairesNonEmpruntables(GregorianCalendar dateRecepEx, int nbExNonEmpruntables) {
        for (int i = 0; i < nbExNonEmpruntables; i++) {
            incDerNumEx();
            Exemplaire nouveau = new Exemplaire(this, false, dateRecepEx, derNumEx);
            setExemplaire(derNumEx, nouveau);
            nouveau.affiche();
        }
    }
            
}
