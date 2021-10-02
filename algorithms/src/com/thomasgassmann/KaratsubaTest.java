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
        assertEquals(31397584145L, Karatsuba.multiply(2335261, 13445));
    }
}