/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pexsoftware.constructor;

/**
 *
 * @author JIVL
 */
public class Constructor 
{
    
    public Constructor() {
        System.out.println("Constructor() >>> ");
    }
    
    public Constructor(String cadena) {
        //this();
        System.out.println("Constructor(String cadena) >>> ");
    }
    
    public static void main(String args[]) {
        new Constructor("cadena");
        System.out.println(" - - - ");
        new Constructor();
    }

}
