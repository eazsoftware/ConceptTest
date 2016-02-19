/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pexsoftware.url.validator;

import java.net.URL;

/**
 *
 * @author JIVL
 */
public class URLValidator 
{
    public URLValidator (int iNum, String url) {    
        try {
            URL checkUrl = new URL(url);
            checkUrl.toURI();   
            
            System.out.println("\t["+iNum+"] > It looks '"+url+"' is a well-formed URL...");
        }
        catch(Exception e) {
            System.out.println("\t["+iNum+"] > " + e.toString());
        }        
    }
    
    public static void main (String args[]) {
        System.out.println("\n >>> Start URLValidator");
        
        URLValidator urlValidator1 = new URLValidator(1, "http://localhost:8091//enterprise");
        URLValidator urlValidator2 = new URLValidator(2, "http://");
        URLValidator urlValidator3 = new URLValidator(3, "http://a");
        URLValidator urlValidator4 = new URLValidator(4, "http://,");
        URLValidator urlValidator5 = new URLValidator(5, "http://    ");
        URLValidator urlValidator6 = new URLValidator(6, "");
        URLValidator urlValidator7 = new URLValidator(7, "  ");
        
        System.out.println("\n >>> End URLValidator");
    }

}