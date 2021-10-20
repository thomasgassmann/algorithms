package com.thomasgassmann;

public class Sorting {
    public static boolean IsSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void BubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    Swap(a, j + 1, j);
                }
            }
        }
    }

    public static void BubbleSortNaive(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j + 1] < a[j]) {
                    Swap(a, j + 1, j);
                }
            }
        }
    }

    public static void SelectionSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            // largest item in [0, i]
            int largestIndex = -1;
            int largest = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                if (a[j] > largest) {
                    largest = a[j];
                    largestIndex = j;
                }
            }

            Swap(a, largestIndex, i);
        }
    }

    public static void InsertionSort(int[] a) {
        if (a.length == 1) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int b = a[i];

            // find index where to insert b
            int upper = i;
            int lower = 0;
            int middle = -1;
            while (upper >= lower) {
                middle = (upper + lower) / 2;
                if (a[middle] < b) {
                    lower = middle++ + 1;
                } else if (a[middle] > b) {
                    upper = middle - 1;
                } else {
                    break;
                }
            }

            // insert element at
            for (int j = i; j > middle; j--) {
                a[j] = a[j - 1];
            }

            a[middle] = b;
        }
    }

    public static void Swap(int[] a, int i, int j) {
        int first = a[i];
        a[i] = a[j];
        a[j] = first;
    }
}
