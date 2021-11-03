package com.thomasgassmann;

import java.util.ArrayList;

public class SubsetSum {
    public static int[] DivideAndConquer(int[] values) {
        if (values.length % 2 == 1) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for (int i = 0; i < values.length; i++)
            sum += values[i];
        // no solution
        if (sum % 2 != 0)
            return new int[0];
        int z = sum / 2;

        PartialSum[] lps = PartialSums(values, 0, values.length / 2 - 1);
        PartialSum[] rps = PartialSums(values, values.length / 2, values.length - 1);

        int i = 0;
        int j = (int)Math.pow(2, values.length / 2) - 1;

        while (i < values.length && j >= 0) {
            int s = lps[i].sum + rps[j].sum;
            if (s == z) {
                int[] res = new int[lps[i].indices.size() + lps[j].indices.size()];
                int ri = 0;
                for (int v = 0; v < values.length; v++)
                    if (lps[i].indices.contains(v) || rps[j].indices.contains(v))
                        res[ri++] = values[v];

                return res;
            } else if (s < z) {
                i++;
            } else {
                j--;
            }
        }

        // no solution
        return new int[0];
    }

    private static class PartialSum {
        public int sum = 0;
        public ArrayList<Integer> indices;
    }

    private static PartialSum[] PartialSums(int[] values, int i, int j) {
        int mperm = (int)Math.pow(2, j - i + 1);
        PartialSum[] partialSums = new PartialSum[mperm];
        for (int c = 0; c < mperm; c++) {
            partialSums[c] = new PartialSum();
            partialSums[c].indices = new ArrayList<Integer>();
            for (int s = i; s <= j; s++) {
                int offset = s - i;
                int mask = c & (1 << offset);
                if (mask != 0) {
                    partialSums[c].sum += values[s];
                    partialSums[c].indices.add(s);
                }
            }
        }

        for (int c = 0; c < partialSums.length; c++) {
            int minIdx = c;
            for (int d = c + 1; d < partialSums.length; d++) {
                if (partialSums[d].sum < partialSums[c].sum &&
                    partialSums[minIdx].sum > partialSums[d].sum) {
                    minIdx = d;
                }
            }

            PartialSum tmp = partialSums[minIdx];
            partialSums[minIdx] = partialSums[c];
            partialSums[c] = tmp;
        }

        return partialSums;
    }

    public static int[] SubsetSumNaive(int[] values) {
        for (int i = 0; i < Math.pow(2, values.length); i++) {
            int in = 0;
            int out = 0;
            for (int j = 0; j < values.length; j++) {
                if ((1 << j & i) != 0) {
                    in += values[j];
                } else {
                    out += values[j];
                }
            }

            if (in == out) {
                int current = i;
                int length = 0;
                while (current != 0) {
                    if ((current & 1) == 1) {
                        length++;
                    }

                    current >>= 1;
                }

                int[] ret = new int[length];
                int idx = 0;
                for (int c = 0; c < values.length; c++) {
                    if ((i & (1 << c)) != 0) {
                        ret[idx++] = values[c];
                    }
                }

                return ret;
            }
        }

        return new int[0];
    }
}
