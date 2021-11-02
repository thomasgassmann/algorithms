package com.thomasgassmann;

public class SubsetSum {
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
