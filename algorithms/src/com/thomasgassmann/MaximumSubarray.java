package com.thomasgassmann;

public class MaximumSubarray {
    public static int Inductive(int[] arr) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }

        return max;
    }

    public static int DivideAndConquer(int[] arr, int from, int toExclusive) {
        if (toExclusive - from == 1)
            return Math.max(0, arr[0]);

        int split = from + (toExclusive - from) / 2;
        int firstMax = DivideAndConquer(arr, from, split);
        int secondMax = DivideAndConquer(arr, split, toExclusive);

        int[] prefixSums = new int[toExclusive - split + 1];
        int[] suffixSums = new int[split - from + 1];
        prefixSums[0] = 0;
        suffixSums[suffixSums.length - 1] = 0;

        int maxPrefixSum = 0;
        for (int i = split; i < toExclusive; i++) {
            int absIndex = i - split;
            prefixSums[absIndex + 1] = prefixSums[absIndex] + arr[i];
            if (prefixSums[absIndex + 1] > maxPrefixSum)
                maxPrefixSum = prefixSums[absIndex + 1];
        }

        int maxSuffixSum = 0;
        for (int i = split; i > from; i--) {
            int absIndex = i - from;
            suffixSums[absIndex - 1] = suffixSums[absIndex] + arr[i - 1];
            if (suffixSums[absIndex - 1] > maxSuffixSum)
                maxSuffixSum = suffixSums[absIndex - 1];
        }

        int shared = maxPrefixSum + maxSuffixSum;

        return Math.max(firstMax, Math.max(secondMax, shared));
    }

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
