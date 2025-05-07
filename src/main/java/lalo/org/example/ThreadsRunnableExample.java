package org.example;

public class ThreadsRunnableExample
{

    /*
     There are to ways to create threads. One is to implement the Runnable
     interface.
    */

    public static void main(String[] args) {

        // Initialize some Threads by implementing the Runnable interface using
        // a lambda and putting them in an array.
        Runnable[] runnables = {
                new Thread(() -> {System.out.printf("Hello, I'm %s%n", Thread.currentThread().getName());}) ,
                new Thread(() -> {System.out.printf("Hello, I'm %s%n", Thread.currentThread().getName());}) ,
                new Thread(() -> {System.out.printf("Hello, I'm %s%n", Thread.currentThread().getName());})
        };

        // Call a method that launches the threads.
        startRunnables(runnables);

    }

    public static void startRunnables(Runnable[] runnables) {
        for(Runnable runnable: runnables){
            // Must use start(), not run(), to actually execute as a new thread.
            new Thread(runnable).start();
        }

    }
}
