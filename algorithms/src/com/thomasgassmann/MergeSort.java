package com.thomasgassmann;

public class MergeSort {
    public static void Merge(int[] arr, int left, int middle, int right) {
        int[] b = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right)
            b[k++] = arr[i] <= arr[j]
                    ? arr[i++]
                    : arr[j++];

        while (i <= middle)
            b[k++] = arr[i++];
        while (j <= right)
            b[k++] = arr[j++];

        for (int l = left; l <= right; l++)
            arr[l] = b[l - left];
    }
}
