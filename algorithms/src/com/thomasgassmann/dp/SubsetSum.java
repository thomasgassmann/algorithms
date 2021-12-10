package com.thomasgassmann.dp;

import java.util.ArrayList;

public class SubsetSum {
    public static int[] SubsetSumDP(int[] values) {
        int z = 0;
        for (int i = 0; i < values.length; i++)
            z += values[i];
        if (z % 2 == 1)
            return new int[0];
        z /= 2;

        boolean[][] dp = new boolean[values.length + 1][z + 1];
        // with 0 things, we can have a 0 sum
        dp[0][0] = true;
        // not necessary, but we like to be explicit here
        for (int i = 1; i <= z; i++)
            dp[0][i] = false;

        for (int i = 1; i <= values.length; i++) {
            for (int j = 0; j <= z; j++) {
                if (values[i - 1] > j) {
                    // values[i] is greater than the current sum j
                    // can we create sum j with i - 1 values?
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // values[i] is smaller or equal to the current sum j
                    // either we can create a sum j with the previous i - 1 values
                    // or we can create the sum j - values[i] with i - 1 values (and
                    // then add values[i] to get the final value)
                    dp[i][j] = dp[i - 1][j] || (j - values[i - 1] >= 0 && dp[i - 1][j - values[i - 1]]);
                }
            }
        }

        // can we create sum z with values.length values?
        boolean exists = dp[values.length][z];
        if (!exists)
            return new int[0];

        ArrayList<Integer> result = new ArrayList<>();
        int k = values.length;
        int s = z;
        while (k > 0 && s >= 0) {
            if (dp[k][s] == dp[k - 1][s]) {
                // k not used, we can create s with k - 1 elements too
                k--;
            } else {
                // we have to have dp[k][s] == dp[k - 1][s - values[k]] now
                result.add(values[k - 1]);
                k--;
                s -= values[k];
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

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
