package com.thomasgassmann;

import java.util.HashMap;

public class LongestSnake {
    public static int LongestSnake(int[] values, HashMap<Integer, int[]> neighbors) {
        int[] dp = new int[values.length];
        IndexTuple[] tuples = new IndexTuple[values.length];
        for (int i = 0; i < values.length; i++)
            tuples[i] = new IndexTuple(i, values[i]);

        HeapSort(tuples);

        for (int i = 0; i < values.length; i++) {
            // find max neighbor of i with values[j] = values[i] - 1
            IndexTuple tuple = tuples[i];
            int[] neighborIndices = neighbors.get(tuple.index);
            int maxLength = 0;
            for (int j = 0; j < neighborIndices.length; j++) {
                if (values[neighborIndices[j]] == tuple.value - 1 &&
                    dp[neighborIndices[j]] > maxLength) {
                    maxLength = dp[neighborIndices[j]];
                }
            }

            dp[tuple.index] = maxLength + 1;
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void HeapSort(IndexTuple[] arr) {
        for (int i = Math.floorDiv(arr.length - 1, 2); i >= 0; i--) {
            RestoreHeapCondition(arr, i, arr.length - 1);
        }

        for (int m = arr.length - 1; m >= 1; m--) {
            IndexTuple tmp = arr[m];
            arr[m] = arr[0];
            arr[0] = tmp;
            RestoreHeapCondition(arr, 0, m - 1);
        }
    }

    public static void RestoreHeapCondition(IndexTuple[] arr, int i, int m) {
        // heap indicies are 1-based
        i++;
        m++;
        while (2 * i <= m) {
            int j = 2 * i;
            if (j + 1 <= m && arr[j - 1].value < arr[j].value)
                j++;

            if (arr[i - 1].value >= arr[j - 1].value) {
                return;
            }

            IndexTuple tmp = arr[i - 1];
            arr[i - 1] = arr[j - 1];
            arr[j - 1] = tmp;

            i = j;
        }
    }

    private static class IndexTuple {
        public IndexTuple(int i, int v) {
            index = i;
            value = v;
        }

        public int index;
        public int value;
    }

}
