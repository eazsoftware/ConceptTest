package com.eaz.java8.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8Consumer {

    public static void main(String args[]) {
        Consumer<Integer> consumer = i -> System.out.print(" " + i);
        
        List<Integer> integerList = Arrays.asList(1,
                new Integer(10), new Integer(200),
                new Integer(101), new Integer(-10),
                new Integer(0));
        printList(integerList, consumer);
    }

    public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
        listOfIntegers.forEach((integer) -> {
            consumer.accept(integer);
        });
    }

}
