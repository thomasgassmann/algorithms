package com.thomasgassmann;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EuclidianGCDTest {
    @Test
    public void TestGCDCalculation() {
        assertEquals(EuclidianGCD.GCD(15, 5), 5);
        assertEquals(EuclidianGCD.GCD(139472305678615L, 273426584985L), 5);
        assertEquals(EuclidianGCD.GCD(7, 13), 1);
    }
}
