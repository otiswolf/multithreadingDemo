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

//        Thread thread3 = new Thread(() -> {
//            try {
//                Thread.sleep(1);
//                for (int i = 0; i < 5000; i++);
//            } catch (InterruptedException e) {
//                System.out.println(e);
//            }
//        }, "States");
//
//        thread3.start();
//
//        while(true) {
//            Thread.State state = thread3.getState();
//            System.out.println(state);
//            if (state == Thread.State.TERMINATED) break;
//        }
//
//        Thread thread4 = new Thread(() -> {
//            System.out.println(Thread.currentThread());
//        }, "Our Thread");
//
//        thread4.start();
//
//        try {
//            // Blocks main thread from continuing until thread4 completes
//            thread4.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        thread4.setPriority(1);
//        System.out.println(thread4.getPriority());

        // Deadlock situation

        String lock1 = "lock1";
        String lock2 = "lock2";

        Thread thread1 = new Thread(() -> {
            synchronized(lock1) {
                try {
                    Thread.sleep(1);
                    synchronized (lock2) {
                        System.out.println("lock 2 acquired");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            // use lock1 here to avoid deadlock
            synchronized(lock2) {
                try {
                    Thread.sleep(1);
                    // use lock2 here to avoid deadlock
                    synchronized (lock1) {
                        System.out.println("lock 1 acquired");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }, "thread2");

        thread1.start();
        thread2.start();

        System.out.println("main() is exiting");
    }
}