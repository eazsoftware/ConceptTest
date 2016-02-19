package com.pexsoftware.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TreeMap example code.
 */
public class TreeMapExample {

    public TreeMapExample() {
        super();
    }

    public static void main(String[] args) {
        //create an instance of TreeMap to Store Phone Number
        Map testTreeMap = new TreeMap();

        //Populate example map with values
        testTreeMap.put("Sam", 258963147);
        testTreeMap.put("John", 5874569);
        testTreeMap.put("Sunny", 58963147);
        testTreeMap.put("Linda", 523658);
        testTreeMap.put("Amit", 5333658);
        testTreeMap.put("Sheila", 4566878);
        testTreeMap.put("Lili", 852369);
        testTreeMap.put("Lili", 999999);
        
        for (Iterator<Entry> it = testTreeMap.entrySet().iterator(); it.hasNext();) {
            Entry entry = it.next();
            System.out.println("Key = " + entry.getKey() + ", Value = "
                    + entry.getValue());
        }

        //headMap method usage
        SortedMap headMapElements = ((TreeMap) testTreeMap).headMap("Linda");
        System.out.println("Output of headMap method ");
        for (Iterator<Entry> it = headMapElements.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = it.next();
            System.out.println("Key = " + entry.getKey() + ", Value = "
                    + entry.getValue());
        }

        //tailMap method usage
        SortedMap tailMapElements = ((TreeMap) testTreeMap).tailMap("Sheila");
        System.out.println("Output of tailMap method ");
        for (Iterator<Entry> it = tailMapElements.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = it.next();
            System.out.println("Key = " + entry.getKey() + ", Value = "
                    + entry.getValue());
        }

        //subMap method usage
        SortedMap subMapElements = ((TreeMap) testTreeMap).subMap("Amit", "Sheila");
        System.out.println("output of subMap method ");
        for (Iterator <Entry> it = subMapElements.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = it.next();
            System.out.println("Key = " + entry.getKey() + ", Value = "
                    + entry.getValue());
        }

    }
}