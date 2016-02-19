package com.pexsoftware.concept.constructor;

/**
 *
 * @author JIVL
 */
public class BasicConstructor {
    
    public static String strStaticVariable;
    
    public String strInstanceVariable;
    
    static {
        System.out.println("Static initalization.");
        strStaticVariable = "Static variable";
    }
    
    {
        System.out.println("Instance initialization.");
        strInstanceVariable = "Instance variable";
    }
    
    public BasicConstructor() {
        System.out.println("No parameter BasicContructor()");
    }    
    
    public BasicConstructor(String parameter) {
        System.out.println("Paremeter BasicContructor()");
        strInstanceVariable = parameter;        
    }        
    
    public static void main (String args[]) {
        BasicConstructor basicConstructorClass = new BasicConstructor();
        System.out.println("strStaticVariable => " + BasicConstructor.strStaticVariable);   
        System.out.println("strInstanceVariable => " + basicConstructorClass.strInstanceVariable);
        System.out.println("\n\n");
        BasicConstructor basicConstructorClass2 = new BasicConstructor("new parameter");
        System.out.println("strStaticVariable => " + BasicConstructor.strStaticVariable);   
        System.out.println("strInstanceVariable => " + basicConstructorClass2.strInstanceVariable);        
    }

}
