package com.thomasgassmann;

import java.util.HashMap;

public class LongestSnake {
    public static int LongestSnakeLinearTimeLength(int[] values, HashMap<Integer, int[]> neighbors) {
        int[] dp = new int[values.length];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                MoveToTail(dp, values, neighbors, i);
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static int[] LongestSnakeLinearTime(int[] values, HashMap<Integer, int[]> neighbors) {
        int[] dp = new int[values.length];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                MoveToTail(dp, values, neighbors, i);
            }
        }

        int max = 0;
        int maxI = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxI = i;
            }
        }

        int[] res = new int[max];
        while (max > 0) {
            res[max - 1] = maxI;
            int[] currentNeighbors = neighbors.get(maxI);
            for (int i = 0; i < currentNeighbors.length; i++) {
                int current = currentNeighbors[i];
                if (dp[current] == max - 1) {
                    maxI = current;
                }
            }

            max--;
        }

        return res;
    }

    public static void MoveToTail(int[] dp, int[] values, HashMap<Integer, int[]> neighbors, int i) {
        int[] currentNeighbors = neighbors.get(i);
        for (int j = 0; j < currentNeighbors.length; j++) {
            int currentNeighbor = currentNeighbors[j];
            if (values[currentNeighbor] == values[i] - 1 && dp[currentNeighbor] == 0) {
                MoveToTail(dp, values, neighbors, currentNeighbor);
            }
        }

        int maxNeighbor = 0;
        for (int j = 0; j < currentNeighbors.length; j++) {
            if (values[currentNeighbors[j]] == values[i] - 1 &&
                    dp[currentNeighbors[j]] > maxNeighbor) {
                maxNeighbor = dp[currentNeighbors[j]];
            }
        }

        dp[i] = maxNeighbor + 1;
    }

    public static int[] LongestSnake(int[] values, HashMap<Integer, int[]> neighbors) {
        int[] dp = LongestSnakeDP(values, neighbors);

        int max = 0;
        int maxI = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                maxI = i;
                max = dp[i];
            }
        }

        int[] res = new int[max];
        while (max > 0) {
            res[max - 1] = maxI;
            int[] currentNeighbors = neighbors.get(maxI);
            for (int i = 0; i < currentNeighbors.length; i++) {
                int current = currentNeighbors[i];
                if (dp[current] == max - 1) {
                    maxI = current;
                }
            }

            max--;
        }

        return res;
    }

    public static int LongestSnakeLength(int[] values, HashMap<Integer, int[]> neighbors) {
        int[] dp = LongestSnakeDP(values, neighbors);

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static int[] LongestSnakeDP(int[] values, HashMap<Integer, int[]> neighbors) {
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

        return dp;
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
