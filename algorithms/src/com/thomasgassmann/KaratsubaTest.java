package com.thomasgassmann;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KaratsubaTest {
    @Test
    public void SingleDigit() {
        assertEquals(20, Karatsuba.multiply(4, 5));
    }

    @Test
    public void TwoDigit() {
        assertEquals(1054, Karatsuba.multiply(17, 62));
    }

    @Test
    public void MultiDigit() {
        assertEquals(112111, Karatsuba.multiply(1, 112111));
        assertEquals(1440, Karatsuba.multiply(12, 120));
        assertEquals(16134288, Karatsuba.multiply(12, 1344524));
        assertEquals(15241383936L, Karatsuba.multiply(123456, 123456));
    }
}