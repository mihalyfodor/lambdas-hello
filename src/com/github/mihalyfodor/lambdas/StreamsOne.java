package com.github.mihalyfodor.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Taking a look at streams.
 * 
 * @author Mihaly Fodor
 *
 */
public class StreamsOne {

    public static void main(String[] args) {

    	// we take a list of numbers again
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // and try to imagine an expensive operation (compute sleeps for 1 second)
        // and then collect the sum of them.
        long start = System.currentTimeMillis();
        int result = numbers.stream()
                .filter( e -> e % 2 == 0)
                .mapToInt( StreamsOne::compute )
                .sum();
        System.out.println(result);
        System.out.println("Took " + (System.currentTimeMillis() - start) + " ms");

        // the above works, but making the stream parallel is better in this case.
        // note that this might not always be a good idea, and has some preconditions,
        // like making sure the computations are independent from one another
        start = System.currentTimeMillis();
        result = numbers.parallelStream()
                .filter( e -> e % 2 == 0)
                .mapToInt( StreamsOne::compute )
                .sum();
        System.out.println(result);
        System.out.println("Took " + (System.currentTimeMillis() - start) + " ms");

        // we can simplify manipulating elements of a list by a lot.
        // requirements of the following code could be:
        // given a list of number compute the number given by multiplying each
        // even number from the list with another.
        int resultMultiplied = numbers.stream()
                .filter( e -> e % 2 == 0)
                .map( e -> e * 2)
                .reduce(1, (carry, e) -> carry * e)
                .intValue();
        System.out.println(resultMultiplied);
        // without streams the above could would need a lot of boilerplate.

        List<Integer> numbersDuplicates = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        // and some more examples for mapping and collecting numbers:
        
        // grabbing the double of the even numbers
        numbersDuplicates.stream()
                .filter( e -> e % 2 == 0)
                .map( e -> e * 2)
                .collect(Collectors.toList());

        // and force the result to be unique by collecting to a set
        numbersDuplicates.stream()
                .filter( e -> e % 2 == 0)
                .map( e -> e * 2)
                .collect(Collectors.toSet());

    }

    public static int compute(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        return number * 2;
    }
}
