package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("main() is starting");

        Thread thread1 = new Thread1("myThread1");

//        thread1.setDaemon(true);
        thread1.start();

        Thread thread2 = new Thread(new Thread2(), "myThread2");

        thread2.start();

        System.out.println("main() is exiting");
    }
}