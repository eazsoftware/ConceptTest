package com.eaz.java8.functions.as.objects;

import java.util.function.Function;

/**
 *
 * @author javier
 * 
 * In Java 8, the java.util.Function<T, R> Interface was introduced. 
 * It can store a function which takes one argument and returns an object. 
 * The Generic T is the type of the argument and R the type of the object you return.
 * 
 * @see https://dzone.com/articles/functional-programming-in-java-8-part-1-functions-as-objects
 */
public class AwesomeClass {

    public static Integer compute(Function<Integer, Integer> function, Integer value) {
        return function.apply(value);
    }    

    private static Integer invert(Integer value) {
        return -value;
    }

    public static Integer invertTheNumber() {
        Integer toInvert = 5;
        Function<Integer, Integer> invertFunction = AwesomeClass::invert;
        return compute(invertFunction, toInvert);
    }
    
    /* ********************************************************************** */
    
    public static String computeString(Function<Integer, String> function, Integer value) {
        return function.apply(value);
    }      
    
    private static String multiplyBy2(Integer value) {
        final Integer TWO = 2;
        return String.format("%d multiply by 2 is equals to %d", (value * 2), TWO);
    }
    
    public static String multiplyBy2TheNumber() {
        Integer toMultiply = 10;
        Function<Integer, String> multiplyBy2Function = AwesomeClass::multiplyBy2;
        return computeString(multiplyBy2Function, toMultiply);
    }
    
    public static void main (String args[]) {
        System.out.println(AwesomeClass.computeString(function, 3));
    }

}
