package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("main() is starting");

//        Thread thread1 = new Thread1("myThread1");
//
////        thread1.setDaemon(true);
//        thread1.start();
//
////        Thread thread2 = new Thread(new Thread2(), "myThread2");
//
//        // An alternate way of implementing runnables
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("inside " + Thread.currentThread() + ": " + i);
//            }
//        }, "myThread2");
//
//        thread2.start();
//
//        Stack stack = new Stack(5);
//
//        new Thread(() -> {
//            int counter = 0;
//            while(++ counter < 10) {
//                System.out.println("Pushed: " + stack.push(100));
//            }
//        }, "Pusher").start();
//
//        new Thread(() -> {
//            int counter = 0;
//            while(++ counter < 10) {
//                System.out.println("Popped: " + stack.pop());
//            }
//        }, "Popper").start();

        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(1);
                for (int i = 0; i < 5000; i++);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }, "States");

        thread3.start();

        while(true) {
            Thread.State state = thread3.getState();
            System.out.println(state);
            if (state == Thread.State.TERMINATED) break;
        }

        System.out.println("main() is exiting");
    }
}