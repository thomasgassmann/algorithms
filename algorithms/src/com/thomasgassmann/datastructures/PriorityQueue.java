package com.thomasgassmann.datastructures;

import java.util.ArrayList;

public class PriorityQueue<T> {
    private ArrayList<PriorityQueueItem<T>> values = new ArrayList<>();

    public void enqueue(T item, int priority) {
        values.add(0, new PriorityQueueItem<>(item, priority));
        RestoreHeapCondition();
    }

    public T dequeue() {
        if (values.size() == 0)
            return null;
        var first = values.get(0);
        values.remove(0);
        RestoreHeapCondition();
        return first.item;
    }

    private void RestoreHeapCondition() {
        if (values.size() < 2) {
            return;
        }

        int i = 1;
        while (2 * i <= values.size()) {
            int j = i * 2;
            if (j + 1 <= values.size() &&
                    values.get(j - 1).priority < values.get(j).priority)
                j++;

            if (values.get(i - 1).priority >= values.get(j - 1).priority) {
                return;
            }

            // swap i - 1 and j - 1
            var tmp = values.get(i - 1);
            values.set(i - 1, values.get(j - 1));
            values.set(j - 1, tmp);

            i = j;
        }
    }
}
