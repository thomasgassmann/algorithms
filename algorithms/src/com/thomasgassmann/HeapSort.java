package com.thomasgassmann;

public class HeapSort {
    public static void RestoreHeapCondition(int[] arr, int i, int m) {
        // heap indicies are 1-based
        i++;
        while (2 * i <= m) {
            int j = 2 * i;
            if (j + 1 <= m)
                if (arr[j - 1] < arr[j])
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
