package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;

public class PriorityQueue<T> {
    private ArrayList<PriorityQueueItem<T>> values = new ArrayList<>();
    private HashMap<T, Integer> indicies = new HashMap<>();

    public void enqueue(T item, int priority) {
        values.add(new PriorityQueueItem<>(item, priority));
        indicies.put(item, values.size() - 1);
        restoreHeapConditionUp(values.size() - 1);
    }

    public boolean isEmpty() {
        return values.size() == 0;
    }

    public void decreaseKey(T item, int newPriority) {
        int idx = indicies.get(item);
        values.get(idx).priority = newPriority;
        restoreHeapConditionUp(idx);
    }

    public T dequeue() {
        if (values.size() == 0)
            return null;
        swap(values.size() - 1, 0);
        var pop = values.get(values.size() - 1);
        values.remove(pop);
        indicies.remove(pop.item);
        restoreHeapConditionDown();
        return pop.item;
    }

    public void assertHeapCondition() {
        assertHeapConditionInternal(1);
    }

    private void assertHeapConditionInternal(int i) {
        int l = i * 2;
        int r = l + 1;
        if (l <= values.size()) {
            Assertions.assertTrue(values.get(l - 1).priority >= values.get(i - 1).priority);
            assertHeapConditionInternal(l);
        }

        if (r <= values.size()) {
            Assertions.assertTrue(values.get(r - 1).priority >= values.get(r - 1).priority);
            assertHeapConditionInternal(r);
        }
    }

    private void swap(int i, int j) {
        var tmp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, tmp);

        // update indices
        indicies.put(tmp.item, j);
        indicies.put(values.get(i).item, i);
    }

    private void restoreHeapConditionUp(int i) {
        if (values.size() < 2) {
            return;
        }

        int current = i + 1;
        while (current > 1) {
            int j = current / 2;
            if (values.get(current - 1).priority < values.get(j - 1).priority) {
                swap(current - 1, j - 1);
            } else {
                return;
            }

            current = j;
        }
    }

    private void restoreHeapConditionDown() {
        if (values.size() < 2) {
            return;
        }

        int i = 1;
        while (2 * i <= values.size()) {
            int j = i * 2;
            if (j + 1 <= values.size() &&
                    values.get(j - 1).priority > values.get(j).priority)
                j++;

            if (values.get(i - 1).priority <= values.get(j - 1).priority) {
                return;
            }

            // swap i - 1 and j - 1
            swap(i - 1, j - 1);

            i = j;
        }
    }
}
