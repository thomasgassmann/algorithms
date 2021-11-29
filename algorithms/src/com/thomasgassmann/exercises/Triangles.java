package com.thomasgassmann.exercises;

public class Triangles {
    public static long CountTriangles(int n, int[] A) {
        QuickSort(A, 0, n - 1);

        long triangles = 0;
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n; j++) {
                while (k < n && A[i] + A[j] >= A[k]) {
                    k++;
                }

                triangles += k - j - 1;
            }
        }

        return triangles;
    }

    public static void QuickSort(int[] a, int l, int r) {
        if (l < r) {
            int k = Partition(a, l, r);
            QuickSort(a, l, k);
            QuickSort(a, k + 1, r);
        }
    }

    public static int Partition(int[] a, int left, int right) {
        int pivot = a[Math.floorDiv(left + right, 2)];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            while (a[++i] < pivot) ;
            while (a[--j] > pivot) ;

            if (i >= j)
                return j;

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    public static long triangles_Solution(int n, int []A)
    {
        // n: length of A
        // A: an array of positive integers
        long triangles = 0; // the number of triangles may not fit into the int type

        // Sort
        for (int i = 0; i < n; i++) {
            int arg_min = i;
            for (int j = i + 1; j < n; j++)
                if (A[j] < A[arg_min])
                    arg_min = j;
            if (arg_min != i) {
                int temp = A[i];
                A[i] = A[arg_min];
                A[arg_min] = temp;
            }
        }

        // Count
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                while (k < n && A[k] <= A[i] + A[j])
                    k++;
                triangles += k - j - 1;
            }
        }

        return triangles;
    }
}
