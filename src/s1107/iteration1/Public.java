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
    ENFANT("Enfant"),
    ADO("Adolescent"), 
    ADULTE("Adulte");
    
    private String nom="";


    Public(String nom){
        this.nom = nom;
    }
    
    public String toString(){
        return nom;
    }
}