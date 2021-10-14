package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NearestMultipleTests {
    @Test
    public void DoneProperly() {
        int[] values = new int[]{
                0, 14, 6, 8, 9, 22, 21, 4
        };
        Assertions.assertEquals(NearestMultiple.Nearest_Multiple(values, values.length - 1, 4, 7), 6);
    }
}
