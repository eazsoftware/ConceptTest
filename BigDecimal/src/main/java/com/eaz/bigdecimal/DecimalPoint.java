package com.eaz.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author javier
 */
public class DecimalPoint {

    public static void main (String args[]) {
        final String strAmount = "12345.678";        
        printBD(strAmount, RoundingMode.HALF_UP);
        
        final String strAmount2 = "12345.67890";        
        printBD(strAmount2, RoundingMode.HALF_UP);
        
        final String strAmount3 = "12345.6";        
        printBD(strAmount3, RoundingMode.HALF_UP);
        
        final String strAmount4 = "12345.0";
        printBD(strAmount4, RoundingMode.HALF_UP);        
        
        final String strAmount5 = "12345";
        printBD(strAmount5, RoundingMode.HALF_UP);           
        
        final String strAmount6 = "12345.43";
        printBD(strAmount6, RoundingMode.HALF_UP); 
        
        final String strAmount7 = "12345.46";
        printBD(strAmount7, RoundingMode.HALF_UP);         
        
        final String strAmount8 = "12345.465";
        printBD(strAmount8, RoundingMode.HALF_UP);          
        
        final String strAmount9 = "12345.464";
        printBD(strAmount9, RoundingMode.HALF_UP);         
        /*******************************************/  
//        printBD(strAmount);           
//        printBD(strAmount2);
//        printBD(strAmount3);
//        printBD(strAmount4);
//        printBD(strAmount5);
        //printBD(strAmount6);
        
    }    
    
    protected static void printBD(String strAmount, RoundingMode rm) {
        BigDecimal bd = new BigDecimal(strAmount);
        
        System.out.println("Bigdecimal ["+bd+"] ==> ["+bd.toPlainString()+"]");
        System.out.println("Bigdecimal ["+bd+"] + RoundingMode.HALF_UP + Scale 0 ==> ["+bd.setScale(0, rm)+"]");
        System.out.println("Bigdecimal ["+bd+"] + RoundingMode.HALF_UP + Scale 2 ==> ["+bd.setScale(2, rm)+"]");
        System.out.println("Bigdecimal ["+bd+"] + RoundingMode.HALF_UP + Scale 2 * 100 ==> ["+bd.setScale(2, rm).multiply(new BigDecimal(100))+"]");
        System.out.println("(Bigdecimal ["+bd+"] + RoundingMode.HALF_UP + Scale 2 * 100) + Scale 0 ==> ["+(bd.setScale(2, rm).multiply(new BigDecimal(100))).setScale(0)+"]");    
        System.out.println("---");
    }
    
    protected static void printBD(String strAmount) {
        BigDecimal bd = new BigDecimal(strAmount);
        
        System.out.println("Bigdecimal ["+bd+"] ==> ["+bd.toPlainString()+"]");
        System.out.println("Bigdecimal ["+bd+"] + RoundingMode.HALF_UP + Scale 0 ==> ["+bd.setScale(0)+"]");
        System.out.println("Bigdecimal ["+bd+"] + RoundingMode.HALF_UP + Scale 2 ==> ["+bd.setScale(2)+"]");
        System.out.println("Bigdecimal ["+bd+"] + RoundingMode.HALF_UP + Scale 2 * 100 ==> ["+bd.setScale(2).multiply(new BigDecimal(100))+"]");
        System.out.println("(Bigdecimal ["+bd+"] + RoundingMode.HALF_UP + Scale 2 * 100) + Scale 0 ==> ["+(bd.setScale(2).multiply(new BigDecimal(100))).setScale(0)+"]");    
        System.out.println("---");
    }    
    
}
