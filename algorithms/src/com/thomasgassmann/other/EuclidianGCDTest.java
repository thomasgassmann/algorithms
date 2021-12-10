package com.thomasgassmann.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EuclidianGCDTest {
    @Test
    public void checkExtendedGCD() {
        var res = EuclidianGCD.ExtendedGCD(142, 553);
        Assertions.assertEquals(res.gcd, 1);
        Assertions.assertEquals(res.u, 74);
        Assertions.assertEquals(res.v, -19);
    }

    @Test
    public void TestGCDCalculation() {
        assertEquals(EuclidianGCD.GCD(15, 5), 5);
        assertEquals(EuclidianGCD.GCD(139472305678615L, 273426584985L), 5);
        assertEquals(EuclidianGCD.GCD(7, 13), 1);

        assertEquals(EuclidianGCD.GCDIterative(15, 5), 5);
        assertEquals(EuclidianGCD.GCDIterative(139472305678615L, 273426584985L), 5);
        assertEquals(EuclidianGCD.GCDIterative(7, 13), 1);
    }
}
