package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriorityQueueTests {
    @Test
    public void CheckPriorityQueue() {
        var q = new PriorityQueue<Integer>();
        q.enqueue(1, 10);
        q.enqueue(2, 1);
        q.enqueue(3, 2);
        q.enqueue(4, 7);
        q.enqueue(5, 5);
        q.enqueue(6, 4);
        q.enqueue(7, 8);
        q.enqueue(8, 9);

        Assertions.assertEquals(q.dequeue(), 1);
        Assertions.assertEquals(q.dequeue(), 8);
        Assertions.assertEquals(q.dequeue(), 7);
        Assertions.assertEquals(q.dequeue(), 4);
        Assertions.assertEquals(q.dequeue(), 5);
        Assertions.assertEquals(q.dequeue(), 6);
    }
}
