package com.thomasgassmann.other;

import com.thomasgassmann.sorting.Sorting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SelectionProblemTests {
    @Test
    public void checkSelectionProblem() {
        final int N = 250;
        var list = new int[N];
        for (int i = 0; i < N; i++)
            list[i] = i;
        var r = new Random(42);
        for (int i = 0; i < N; i++) {
            var from = r.nextInt(0, N);
            var to = r.nextInt(0, N);
            Sorting.Swap(list, from, to);
        }

        for (int i = 0; i < N; i++) {
            Assertions.assertEquals(i, SelectionProblem.selectionProblem(list, 0, list.length - 1, i));
        }
    }
}
