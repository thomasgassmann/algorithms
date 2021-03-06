package com.thomasgassmann.sorting;

import org.junit.jupiter.api.Test;

import static com.thomasgassmann.AssertionHelpers.AssertEqual;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTests {
    @Test
    public void TestIsSorted() {
        assertEquals(true, Sorting.IsSorted(new int[] { 1, 2, 3, 4 }));
        assertEquals(false, Sorting.IsSorted(new int[] { 1, 2, 4, 3 }));
    }

    @Test
    public void TestBubbleSortNaive() {
        int[] a = new int[] { 4, 3, 7, 2, 7, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 7, 9 };
        Sorting.BubbleSortNaive(a);
        AssertEqual(a, r);
    }

    @Test
    public void TestBubbleSort() {
        int[] a = new int[] { 4, 3, 7, 2, 7, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 7, 9 };
        Sorting.BubbleSort(a);
        AssertEqual(a, r);
    }

    @Test
    public void TestSelectionSort() {
        int[] a = new int[] { 4, 3, 7, 2, 7, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 7, 9 };
        Sorting.SelectionSort(a);
        AssertEqual(a, r);
    }

    @Test
    public void TestInsertionSort() {
        int[] a = new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 7, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 7, 9, 10, 11, 15, 16, 23 };
        Sorting.InsertionSort(a);
        AssertEqual(a, r);
    }

    @Test
    public void TestExchangeSort() {
        int[] a = new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 7, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 7, 9, 10, 11, 15, 16, 23 };
        Sorting.ExchangeSort(a);
        AssertEqual(a, r);
    }
}
