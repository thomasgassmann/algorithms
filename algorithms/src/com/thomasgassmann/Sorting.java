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

    private static void Swap(int[] a, int i, int j) {
        int first = a[i];
        a[i] = a[j];
        a[j] = first;
    }
}
