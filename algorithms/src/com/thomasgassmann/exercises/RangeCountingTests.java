package com.thomasgassmann.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RangeCountingTests {
    @Test
    public void CheckRangeCounting() {
        var values = new int[] {3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        Assertions.assertEquals(RangeCounting.Range_Counting(
                values,
                values.length,
                6, 18), 4);
    }
}
