/*
author: Aman Jeet Singh
description: Implementation of a leaky bucket that enqueues items up to a capacity and processes (removes) a specified number of items.
file: LeakyBucket.java
*/

import java.util.*;

public class LeakyBucket {

    private int capacity;
    private Deque<String> queue;

    public LeakyBucket(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayDeque<>();
    }

    public void enqueue(String item) {
        if (queue.size() == capacity) {
            queue.pollFirst(); // drop front
        }
        queue.addLast(item);
    }

    public List<String> process(int k) {
        List<String> removed = new ArrayList<>();

        while (k > 0 && !queue.isEmpty()) {
            removed.add(queue.pollFirst());
            k--;
        }
        return removed;
    }
}
