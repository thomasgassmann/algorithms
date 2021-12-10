package com.thomasgassmann.sorting;

public class MergeSort {
    public static void MergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = Math.floorDiv(left + right, 2);
            MergeSort(arr, left, middle);
            MergeSort(arr, middle + 1, right);
            Merge(arr, left, middle, right);
        }
    }

    public static void NaturalMergeSort(int[] a) {
        int left = 0;
        do {
            int right = 0;
            while (right < a.length) {
                left = right + 1;
                int middle = left;
                while (middle < a.length && a[middle] >= a[middle - 1])
                    middle++;
                if (middle < a.length) {
                    right = middle + 1;
                    while (right < a.length && a[right] >= a[right - 1])
                        right++;
                    Merge(a, left - 1, middle - 1, right - 1);
                } else {
                    right = a.length;
                }
            }
        } while (left != 1);
    }

    public static void StraightMergeSort(int[] arr) {
        int length = 1;
        while (length < arr.length) {
            int right = 0;
            while (right + length < arr.length) {
                int left = right + 1;
                int middle = left + length - 1;
                right = Math.min(middle + length, arr.length);
                Merge(arr, left - 1, middle - 1, right - 1);
            }

            length *= 2;
        }
    }

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
