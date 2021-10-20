package com.thomasgassmann;

public class HeapSort {
    public static void HeapSort(int[] arr) {
        for (int i = Math.floorDiv(arr.length - 1, 2); i >= 0; i--) {
            RestoreHeapCondition(arr, i, arr.length);
        }

        for (int m = arr.length - 1; m > 1; m--) {
            Sorting.Swap(arr, 0, m);
            RestoreHeapCondition(arr, 0, m - 1);
        }
    }

    public static void RestoreHeapCondition(int[] arr, int i, int m) {
        // heap indicies are 1-based
        i++;
        while (2 * i <= m) {
            int j = 2 * i;
            if (j + 1 <= m && arr[j - 1] < arr[j])
                j++;

            if (arr[i - 1] >= arr[j - 1]) {
                return;
            }

            int tmp = arr[i - 1];
            arr[i - 1] = arr[j - 1];
            arr[j - 1] = tmp;

            i = j;
        }
    }
}
