package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTests {
    @Test
    public void CheckQueue() {
        var queue = new Queue<Integer>();
        CheckQueue(queue);
    }

    public void CheckQueue(IQueue<Integer> q) {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        Assertions.assertEquals(q.dequeue(), 1);
        Assertions.assertEquals(q.front(), 2);
        Assertions.assertEquals(q.dequeue(), 2);
        Assertions.assertEquals(q.dequeue(), 3);
        Assertions.assertEquals(q.isEmpty(), true);
    }
}
