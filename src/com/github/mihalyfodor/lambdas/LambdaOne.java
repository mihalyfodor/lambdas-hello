package com.github.mihalyfodor.lambdas;

/**
 * Taking a look of "classic" code versus lambdas.
 * 
 * @author Mihaly Fodor
 *
 */
public class LambdaOne {

    public static void main(String[] args) {

    	// creating a thread, we have quite a bit of visual fluff
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        });
        thread.start();

        // the same thing with a lambda expression, much more concise
        thread = new Thread( () -> System.out.println("other hello") );
        thread.start();

    }
}
