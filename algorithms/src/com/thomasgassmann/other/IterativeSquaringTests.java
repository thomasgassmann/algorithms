package com.thomasgassmann.other;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IterativeSquaringTests {
    @Test
    public void TestSquareEvenPowers() {
        assertEquals(16, IterativeSquaring.SquareEvenPower(2, 4));
    }

    @Test
    public void TestPowers() {
        assertEquals(16, IterativeSquaring.SquarePower(2, 4));
        assertEquals(32, IterativeSquaring.SquarePower(2, 5));
        assertEquals(27, IterativeSquaring.SquarePower(3, 3));
    }
}
