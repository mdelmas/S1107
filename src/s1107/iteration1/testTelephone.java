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
public class testTelephone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            System.out.println("Match ? ");

            String t1 = "abcdefghij";
            String t2 = "0123456889";
            String t3 = "01234";
            String regexStr = "^[0-9]{10}$";
            
            System.out.println("t1 match ? " + t1.matches(regexStr));        
            System.out.println("t2 match ? " + t2.matches(regexStr));
            System.out.println("t3 match ? " + t3.matches(regexStr));
    
}
    
}
