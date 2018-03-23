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
public enum Color 
{
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    GRAY("\u001B[1m");

    private String code="";

    Color(String code){
        this.code = code;
    }
    
    public String code() {
        return code;
    }
    
    @Override
    public String toString(){
        return code;
    }
    
}
