package com.thomasgassmann;

public class MaximumSubarray {
    public static int PrefixSums(int[] arr) {
        int[] prefixSums = new int[arr.length + 1];
        prefixSums[0] = 0;
        for (int i = 1; i < arr.length + 1; i++)
            prefixSums[i] = prefixSums[i - 1] + arr[i - 1];

        int max = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr.length; j++) {
                int currentSum = prefixSums[j + 1] - prefixSums[i];
                if (currentSum > max)
                    max = currentSum;
            }

        return max;
    }

    public static int Naive(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
