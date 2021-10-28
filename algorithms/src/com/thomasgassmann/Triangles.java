package com.thomasgassmann;

public class Triangles {
    private static class SortedValue {
        private int _a;
        private int _i;

        public SortedValue(int a, int i) {
            _a = a;
            _i = i;
        }

        public int getIndex() {
            return _i;
        }

        public int getValue() {
            return _a;
        }
    }

    public static long CountTriangles(int n, int[] A) {
        SortedValue[] values = new SortedValue[n];
        for (int i = 0; i < n; i++)
            values[i] = new SortedValue(A[i], i);

        QuickSort(values, 0, n - 1);

        long triangles = 0;
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                long currentTriangles = 0;
                int ival = values[i].getValue();
                int jval = values[j].getValue();
                while (k < n) {
                    int kval = values[k].getValue();
                    if (ival + jval < kval)
                        break;

                    if (values[j].getIndex() < values[k].getIndex() ||
                        values[i].getIndex() < values[k].getIndex()) {
                        currentTriangles++;
                    }

                    k++;
                }

                triangles += currentTriangles;
            }
        }

        return triangles;
    }

    public static boolean IsTriangle(int a, int b, int c) {
        return (a + b) >= c && (c + a) >= b && (b + c) >= a;
    }

    public static void QuickSort(SortedValue[] a, int l, int r) {
        if (l < r) {
            int k = Partition(a, l, r);
            QuickSort(a, l, k);
            QuickSort(a, k + 1, r);
        }
    }

    public static int Partition(SortedValue[] a, int left, int right) {
        SortedValue pivot = a[Math.floorDiv(left + right, 2)];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            while (a[++i].getValue() < pivot.getValue()) ;
            while (a[--j].getValue() > pivot.getValue()) ;

            if (i >= j)
                return j;

            SortedValue tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
