package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriorityQueueTests {
    @Test
    public void checkDecreaseKey() {
        var q = new PriorityQueue<Integer>();
        q.enqueue(1, 10);
        q.assertHeapCondition();
        q.enqueue(2, 1);
        q.assertHeapCondition();
        q.enqueue(3, 2);
        q.assertHeapCondition();
        q.enqueue(4, 7);
        q.assertHeapCondition();
        q.enqueue(5, 5);
        q.assertHeapCondition();
        q.enqueue(6, 4);
        q.assertHeapCondition();
        q.enqueue(7, 8);
        q.assertHeapCondition();
        q.enqueue(8, 9);
        q.assertHeapCondition();
        q.decreaseKey(1, 0);
        q.assertHeapCondition();

        Assertions.assertEquals(q.dequeue(), 1);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 2);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 3);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 6);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 5);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 4);
        q.assertHeapCondition();
    }

    @Test
    public void checkPriorityQueue() {
        var q = new PriorityQueue<Integer>();
        q.enqueue(1, 10);
        q.assertHeapCondition();
        q.enqueue(2, 1);
        q.assertHeapCondition();
        q.enqueue(3, 2);
        q.assertHeapCondition();
        q.enqueue(4, 7);
        q.assertHeapCondition();
        q.enqueue(5, 5);
        q.assertHeapCondition();
        q.enqueue(6, 4);
        q.assertHeapCondition();
        q.enqueue(7, 8);
        q.assertHeapCondition();
        q.enqueue(8, 9);
        q.assertHeapCondition();

        Assertions.assertEquals(q.dequeue(), 2);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 3);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 6);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 5);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 4);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 7);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 8);
        q.assertHeapCondition();
        Assertions.assertEquals(q.dequeue(), 1);
        q.assertHeapCondition();
    }
}
