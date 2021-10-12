package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumProductTests {
    @Test
    public void MaximumProductCalculatedCorrectly() {
        Assertions.assertEquals(100 / 3D, MaximumProduct.MaximumProduct(
                new long[] { 150, 350, 500, 400 },
                new long[] { 150, 150, 200, -100 }
        ), 0.0001);

        Assertions.assertEquals(100 / 3D, MaximumProduct.MaximumProductLog(
                new long[] { 150, 350, 500, 400 },
                new long[] { 150, 150, 200, -100 }
        ), 0.0001);
    }
}
