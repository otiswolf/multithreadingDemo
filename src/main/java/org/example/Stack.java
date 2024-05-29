package org.example;

public class Stack {
    private int[] array;
    private int stackTop;
    Object lock;

    public Stack(int capacity) {
        array = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }

    public boolean push(int element) {
        synchronized(lock) {
            if (isFull()) return false;
            ++stackTop;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            // Could get a OutOfBounds exception here if we didn't use locks (synchronized)
            // If pop() is called by another thread before we reach this line in our thread
            array[stackTop] = element;
            return true;
        }
    }

    public int pop() {
        synchronized(lock) {
            if (isEmpty()) return Integer.MIN_VALUE;
            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            stackTop --;
            return obj;
        }
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length -1;
    }
}
