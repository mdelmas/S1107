/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1107.iteration1;

import java.util.Date;

/**
 *
 * @author delmasmo
 */
public class Ouvrage {
    
    private int isbn;
    private String titre;
    private String nomEditeur;
    private Date dateParution;
    private String nomAuteur;
    private int derNumEx;
    private Public publicVise;
    
    Ouvrage(int isbn, String titre, String nomEditeur, Date dateParution, String nomAuteur, String publicVise) {
        setIsbn(isbn);
        
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
    
    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }
    
    public Date getDateParution() {
        return dateParution;
    }
    
    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }
    
    public String getNomAuteur() {
        return nomAuteur;
    }
    
    
}
