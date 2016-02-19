package com.pexsoftware.java.list.order;

/**
 *
 * @author JIVL
 */
public class Element {
    
    protected String name;
    protected Float order;
    
    public Element() {
    
    }
    
    public Element (String name, Float order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getOrder() {
        return order;
    }

    public void setOrder(Float order) {
        this.order = order;
    }
    
}
