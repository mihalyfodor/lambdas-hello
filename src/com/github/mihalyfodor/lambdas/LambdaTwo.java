package com.github.mihalyfodor.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Taking a look at some examples with lambdas.
 * 
 * @author Mihaly Fodor
 *
 */
public class LambdaTwo {

    public static void main(String[] args) {

    	// we could take a list of numbers, and try to do something with it
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // basic for, still has a lot of fluff
        for (int i=0; i<numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        
        // or a bit simpler
        for (int i : numbers) {
            System.out.println(i);
        }

        // what happens if we don't care about HOW we get through the list?
        // in most cases we want to do something with the elements
        // and we don't care much about which element is it exactly
        
        // we can just say that we want to take each value, and do something with it
        numbers.forEach( value -> System.out.println(value));

        // or as a short hand we can pass on a method reference (from the static
        // class out in this case). Only works if we are doing one action though.
        numbers.forEach(System.out::println);
        
        // or apply a static method of a normal class to each element
        numbers.forEach(LambdaTwo::doStuff);
        
        // this wont do much, but we can shorthand-call methods if it is from a class
        // that makes up the list. Integer in this case.
        numbers.forEach(Integer::intValue);

        // if we want to do more operations on an element, brackets are mandatory.
        numbers.forEach(e -> {
            System.out.println("some operation");
            System.out.println("some other operation");
            System.out.println("really!?");
        });
    }

    public static void doStuff(int i) {
        System.out.println(i);
    }
}
