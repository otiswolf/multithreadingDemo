package org.example;

public class Thread1 extends Thread{

    // Only required if we want to name the thread
    public Thread1(String threadName) {
        super(threadName);
    }

    // Code to execute
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("inside " + Thread.currentThread() + ": " + i);
        }
    }
}
