package org.example;

public class ThreadsThreadSubclass
{

    /*
     There are to ways to create threads. One is to extend the Thread
     class.
    */

    public static void main(String[] args) {

        // Initialize some Threads by extending the Thread class using
        // anonymous classes and putting them in an array.
        Thread[] threads = {
                new Thread(){
                    @Override
                    public void run() {System.out.printf("Hello, I'm %s%n", Thread.currentThread().getName());}
                },
                new Thread(){
                    @Override
                    public void run() {System.out.printf("Hello, I'm %s%n", Thread.currentThread().getName());}
                },
                new Thread(){
                    @Override
                    public void run() {System.out.printf("Hello, I'm %s%n", Thread.currentThread().getName());}
                }
        };

        // Call a method that launches the threads.
        startThreads(threads);

    }

    public static void startThreads(Thread[] threads) {
        for(Thread thread: threads){
            // Must use start(), not run(), to actually execute as a new thread.
            thread.start();
        }

    }
}
