package org.example;

public class ThreadsThreadProperties {
    public static void main(String[] args) {
        Thread thr = Thread.currentThread();
        System.out.println(getName(thr));
        printIfDaemon(thr);

        System.out.println("Name: " + Thread.currentThread().getName());
        System.out.println("Priority: " + Thread.currentThread().getPriority());

    }

    public static String getName(Thread thread) {
        return thread.getName();
    }

    public static void printIfDaemon(Thread thread) {
        System.out.println(thread.isDaemon()?"daemon":"not daemon");
    }

}
