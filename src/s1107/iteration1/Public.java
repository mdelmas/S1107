/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1107.iteration1;

/**
 *
 * @author delmasmo 
 */
public enum Public {
    ENFANT("Enfant", 0),
    ADO("Adolescent", 10), 
    ADULTE("Adulte", 16);
    
    private String nom="";
    private Integer ageLimite;

    Public(String nom, Integer ageLimite){
        this.nom = nom;
        this.ageLimite = ageLimite;
    }
    
    public String toString(){
        return nom;
    }
    
    public Integer getAgeLimite() {
        return ageLimite;
    }
    
}