package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumProductTests {
    @Test
    public void MaximumProductCalculatedCorrectly() {
        Assertions.assertEquals(100 / 3D, MaximumProduct.MaximumProduct (
                new long[] { 150, 350, 500, 400 },
                new long[] { 150, 150, 200, -100 }
        ), 0.0001);

        Assertions.assertEquals(100 / 3D, MaximumProduct.MaximumProductLog(
                new long[] { 150, 350, 500, 400 },
                new long[] { 150, 150, 200, -100 }
        ), 0.0001);
    }

    @Test
    public void MaximumProductWithNegativesCorrect() {
        Assertions.assertEquals(966.6666666666665, MaximumProduct.MaximumProductWithNegative(
                new long[] { 5, 20, 10, -10, 5, 20, 60, 40 },
                new long[] { 5, 10, -10, 0, 10, 10, 20, -40 }
        ), 0.0001);
    }
}
