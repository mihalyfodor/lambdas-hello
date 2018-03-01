package com.github.mihalyfodor.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Having more complex data structures gives us more possibilities :)
 * 
 * @author Mihaly Fodor
 *
 */
public class StreamsTwo {

    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );

    }

    public static void main(String[] args) {
    	
    	// given a list of people
        List<Person> people = createPeople();

        // we can remap them to bring out their name and age as key, and the person object as value
        System.out.println(people.stream().collect(Collectors.toMap(
                person -> person.getName() + " " + person.getAge(),
                person -> person
        )));

        // or grab the first person matching a gender
        System.out.println(people.stream()
                .filter( e -> e.getGender() == Gender.FEMALE)
                .findFirst()
                .get());

        // or collect them to a map with their names as key
        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getName)));

        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.mapping(Person::getAge, Collectors.toList()))));

        // one more exercise
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 2 ,9, 54, 23, 11 , 6, 7, 8,
                32, 78, 99, 11, 11, 9, 10,15, 36, 85, 63 ,52);

        // given a list find the double of the first even nr greater then 3.
        // a basic solution would be the following
        int result = 0;
        for (int e : numbers) {
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }

        // we can make it a lot nicer though
        result = numbers.stream()
                .filter(StreamsTwo::isGT3)
                .filter(StreamsTwo::isEven)
                .map( StreamsTwo::doubleIt)
                .findFirst()
                .get();
        
        System.out.println(result);

        numbers.stream()
        	.sorted()
        	.distinct()
        	.forEach(System.out::println);

    }

    public static boolean isGT3(int number) {
        return number > 3;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        return number * 2;
    }
}
