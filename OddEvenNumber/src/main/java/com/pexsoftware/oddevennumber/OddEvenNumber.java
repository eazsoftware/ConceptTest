package com.pexsoftware.oddevennumber;

/**
 *
 * @author JIVL
 */
public class OddEvenNumber {

    public static void main(String args[]) {
        for (int i=0; i<=10; i++) {
            System.out.println("["+i+"] is even? ["+isEven(i)+"] mod ["+(i % 2)+"] div ["+(i/2)+"]");
        }
    }

    public static boolean isEven(int num) {
        return (num % 2) == 0;
    }

}
