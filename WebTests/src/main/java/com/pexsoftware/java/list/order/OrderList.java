package com.pexsoftware.java.list.order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIVL
 */
public class OrderList {

    List<Element> lElement;

    public OrderList() {
        lElement = new ArrayList<Element>();
    }

    public List<Element> getlElement() {
        return lElement;
    }

    public void setlElement(List<Element> lElement) {
        this.lElement = lElement;
    }
    
    public List<Element> add(Element newElement) {
        for(Element element : lElement) {
            if (element.getOrder() >= newElement.getOrder()) {
                element.setOrder(element.getOrder() + 1);
            }
        }
        lElement.add(newElement);
        
        return lElement;
    }
    
    public String printList() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("{ ");
        for (Element element : lElement) {
            sb.append(" [").append(element.getName()).append(",").append(element.getOrder()).append("] ");
        }
        sb.append(" }");
        
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(">>> Start OrderList");

        OrderList orderList = new OrderList();

        try {
            ///////////////////////////////////////////////////////////////////
            System.out.println(">>>>>> Add 3 first elements [A,B,C]");

            Element elementA = new Element("A", 1.0f);
            Element elementB = new Element("B", 2.0f);
            Element elementC = new Element("C", 3.0f);

            orderList.lElement.add(elementA);
            orderList.lElement.add(elementB);
            orderList.lElement.add(elementC);
            
            System.out.println(">>>>>> List: " + orderList.printList());
            ///////////////////////////////////////////////////////////////////
            System.out.println(">>>>>> Add 1 new element [D,1.0]");
            Element elementD = new Element("D", 1.0f);
            orderList.add(elementD);
            
            System.out.println(">>>>>> List: " + orderList.printList());
            ///////////////////////////////////////////////////////////////////
            System.out.println(">>>>>> Add 2 new elements [E,2.0] [F,3.0]");
            Element elementE = new Element("E", 2.0f);
            Element elementF = new Element("F", 3.0f);
            orderList.add(elementE);            
            orderList.add(elementF);
            System.out.println(">>>>>> List: " + orderList.printList());
            ///////////////////////////////////////////////////////////////////
            System.out.println(">>>>>> Add 1 new element [G,7.0]");
            Element elementG = new Element("G", 7.0f);
            orderList.add(elementG);
            
            System.out.println(">>>>>> List: " + orderList.printList());
            ///////////////////////////////////////////////////////////////////
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(">>> End OrderList");
    }
}
