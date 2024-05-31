package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int capacity) {
        q = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean add(int item) {
        synchronized (q) {
            while(q.size() == capacity) {
                try {
                    // B) Thread will wait, relinquishing its lock, until other threads pop items from the Queue
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            q.add(item);
            // Allows wait A to continue execution
            q.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (q) {
            while(q.size() == 0) {
                try {
                    // A) Thread will wait, relinquishing its lock, until other threads add items to the Queue
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int element = q.poll();
            // Allows wait B to continue execution
            q.notifyAll();
            return element;
        }
    }
}
