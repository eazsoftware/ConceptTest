package com.pexsoftware.java.reflection;
 
import java.util.Date;
import java.lang.reflect.Field;

/**
 *
 * @author JIVL
 */
public class Reflection 
{
    public static Date now;
    private Long id;
    public String name;
 
    public static void main(String[] args) {
        Reflection demo = new Reflection();
        Class clazz = demo.getClass();
 
        try {
            //
            // Get field id, set it value and read it back
            //            
            Field field = clazz.getDeclaredField("id");                        
            field.set(demo, new Long(12));
            field.get(demo);            
            Object value = field.get(demo);
            System.out.println("Value = " + value);
 
            //
            // Get static field date, set it value and read it back
            //
            field = clazz.getField("now");
            field.set(null, new Date());
            value = field.get(null);
            System.out.println("Value = " + value);
            
            System.out.println("clazz.getDeclaredField('id').getName() ==> " + clazz.getDeclaredField("id").getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
 
    }
}