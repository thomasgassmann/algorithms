package com.thomasgassmann.dp;

public class MaximumSubmatrixSum {
    public static int MaximumSubmatrixSum(int[][] matrix) {
        int length = matrix.length;

        int[][] prefix = new int[length][length];
        for (int i = 0; i < length; i++) {
            prefix[0][i] = matrix[0][i];
            for (int j = 1; j < length; j++) {
                prefix[j][i] = prefix[j - 1][i] + matrix[j][i];
            }
        }

        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                // for every row, we take their differences in the column values
                int[] diffsInCols = new int[length];
                for (int col = 0; col < length; col++) {
                    if (i == 0) {
                        diffsInCols[col] = prefix[j][col];
                    } else {
                        diffsInCols[col] = prefix[j][col] - prefix[i - 1][col];
                    }
                }

                int s = 0;
                for (int c = 0; c < diffsInCols.length; c++) {
                    s += diffsInCols[c];
                    if (s < 0)
                        s = 0;
                    if (s > max)
                        max = s;
                }
            }
        }

        return max;
    }
}
