package com.thomasgassmann;

public class LongestIncreasingSubsequence {
    public static int[] LongestIncreasingSubsequence(int[] values) {
        int[] T = new int[values.length + 1];
        int[] V = new int[values.length];

        T[0] = Integer.MIN_VALUE;
        for (int i = 1; i < T.length; i++)
            T[i] = Integer.MAX_VALUE;

        for (int i = 0; i < values.length; i++) {
            int l = 0;
            int r = T.length - 1;
            while (l <= r) {
                int middle = Math.floorDiv(l + r, 2);
                if (T[middle] < values[i] && values[i] < T[middle + 1]) {
                    l = middle;
                    break;
                }

                if (T[middle] > values[i])
                    r = middle;
                if (T[middle] < values[i])
                    l = middle;
            }

            T[l + 1] = values[i];
            V[i] = T[l];
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = T.length - 1; i >= 0; i--) {
            if (T[i] < Integer.MAX_VALUE) {
                maxLength = i;
                break;
            }
        }

        int[] res = new int[maxLength];
        res[maxLength - 1] = T[maxLength];
        int i = values.length - 1;
        int resPointer = maxLength - 1;
        int search = T[maxLength];
        while (resPointer > 0) {
            while (values[i] != search)
                i--;
            res[--resPointer] = V[i];
            search = V[i];
        }

        return res;
    }
}
