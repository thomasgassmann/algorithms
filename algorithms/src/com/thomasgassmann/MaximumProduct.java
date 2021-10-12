package com.thomasgassmann;

public class MaximumProduct {
    public static double MaximumProduct(long[] is, long[] as) {
        double randmax = 1;
        double maxP = 1;
        for (int i = 0; i < as.length - 1; i++) {
            randmax = randmax * ((is[i + 1] - as[i + 1]) / (double)is[i]);
            if (randmax > maxP)
                maxP = randmax;
            if (randmax < 1)
                randmax = 1;
        }

        return 100 * maxP - 100;
    }
}
