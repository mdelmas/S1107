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
public enum Public 
{
    ENFANT("Enfant", 0),
    ADO("Adolescent", 10),
    ADULTE("Adulte", 16);

    private String nom="";
    private Integer ageMinimum;

    Public(String nom, Integer ageMinimum){
        this.nom = nom;
        this.ageMinimum = ageMinimum;
    }

    @Override
    public String toString(){
        return nom;
    }

    /*
     * Retourne l'age minimum/limite du lecteur pour un public donné
     */
    public Integer getAgeMinimum() {
        return ageMinimum;
    }

}
