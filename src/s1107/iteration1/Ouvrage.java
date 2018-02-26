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
    
    private int isbn;
    private String titre;
    private String nomEditeur;
    private GregorianCalendar dateParution;
    private String nomAuteur;
    private Public publicVise;
    private int derNumEx = 0;
    private HashMap<Integer, Exemplaire> exemplaires;
    
    public Ouvrage(int isbn, String titre, String nomEditeur, GregorianCalendar dateParution, String nomAuteur, Public publicVise) {
        setIsbn(isbn);
        setTitre(titre);
        setNomEditeur(nomEditeur);
        setDateParution(dateParution);
        setNomAuteur(nomAuteur);
        setPublicVise(publicVise);
        exemplaires = new HashMap<>();
    }
    
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    public int getIsbn() {
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
     
    public void afficheOuvrage() {
        System.out.println("Ouvrage :");
        System.out.print("ISBN: " + getIsbn() + ", titre : " + getTitre());
        System.out.print("nom auteur : " + getNomAuteur() + ", ");
        GregorianCalendar d = getDateParution();
        System.out.print("date parution : " + d.get(Calendar.DAY_OF_MONTH) + "." + d.get(Calendar.MONTH) + "." + d.get(Calendar.YEAR));
        System.out.println(", nom éditeur : " + getNomEditeur() + ", public : " + getPublicVise());
    }

    public void afficheExemplaires() {
        afficheOuvrage();
        for(Map.Entry<Integer, Exemplaire> entry : exemplaires.entrySet()) {
            Exemplaire exemplaire = entry.getValue();
            exemplaire.affiche();
        }
    }
    
    public Exemplaire getExemplaire(int numEx) {
        return exemplaires.get(numEx);
    }
    
    public void setExemplaire(int numEx, Exemplaire e) {
        exemplaires.put(numEx, e);
    }
    
    public void ajouterExemplairesEmpruntables(GregorianCalendar dateRecepEx, int nbExEmpruntables) {
        for (int i = 0; i < nbExEmpruntables; i++) {
            Exemplaire nouveau = new Exemplaire(this, true, dateRecepEx);
        }
    }
    
    public void ajouterExemplairesNonEmpruntables(GregorianCalendar dateRecepEx, int nbExNonEmpruntables) {
        for (int i = 0; i < nbExNonEmpruntables; i++) {
            Exemplaire nouveau = new Exemplaire(this, false, dateRecepEx);
        }
    }
            
}
