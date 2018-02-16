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
    
    Ouvrage(int isbn, String titre, String nomEditeur, String dateParution, String nomAuteur, String publicVise) {
        
        setIsbn(isbn);
    }
    
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    public int getIsbn() {
        return isbn;
    }
    // , String titre, String nomEditeur, String dateParution, String nomAuteur, String public
}
