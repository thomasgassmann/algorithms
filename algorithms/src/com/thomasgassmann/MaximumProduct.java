package com.thomasgassmann;

public class MaximumProduct {
    public static double MaximumProductLog(long[] is, long[] as) {
        double randmax = 0;
        double maxP = 0;
        for (int i = 0; i < as.length - 1; i++) {
            randmax = randmax + Math.log((is[i + 1] - as[i + 1]) / (double)is[i]) / Math.log(Math.E);
            if (randmax > maxP)
                maxP = randmax;
            if (randmax < 0)
                randmax = 0;
        }

        return Math.pow(Math.E, maxP) * 100 - 100;
    }

    public static double MaxProfitUsingSum(int[] is, int[] as) {
        double[] gs = new double[as.length - 1];
        for (int i = 0; i < is.length - 1; i++) {
            gs[i] = (is[i + 1] - as[i + 1]) / (double)is[i];
        }

        double p = gs[0];
        double maxProd = Math.max(1, p);
        for (int i = 1; i < gs.length; i++) {
            p = Math.max(gs[i], gs[i] * p);
            maxProd = Math.max(maxProd, p);
        }

        return 100 * maxProd - 100;
    }

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

    public static double MaximumProductWithNegative(long[] is, long[] as) {
        double[] gs = new double[as.length - 1];
        for (int i = 0; i < is.length - 1; i++) {
            gs[i] = (is[i + 1] - as[i + 1]) / (double)is[i];
        }

        double pmax = gs[0];
        double pmin = gs[0];
        double maxProd = Math.max(1, pmax);
        for (int i = 1; i < gs.length; i++) {
            pmax = Math.max(gs[i], Math.max(gs[i] * pmax, gs[i] * pmin));
            pmin = Math.min(gs[i], Math.max(gs[i] * pmax, gs[i] * pmin));
            maxProd = Math.max(maxProd, pmax);
        }

        return 100 * maxProd - 100;
    }
}
