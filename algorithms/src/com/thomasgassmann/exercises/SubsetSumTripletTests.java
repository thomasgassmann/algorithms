package com.thomasgassmann.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubsetSumTripletTests {
    @Test
    public void CheckTripletSum() {
        Assertions.assertEquals(SubsetSumTriplet.SubsetSumTriplet(new int[] {
                2, 4, 8, 1, 4, 5, 3
        }), true);
        Assertions.assertEquals(SubsetSumTriplet.SubsetSumTriplet(new int[] {
                3, 2, 5, 2
        }), false);
    }
}
