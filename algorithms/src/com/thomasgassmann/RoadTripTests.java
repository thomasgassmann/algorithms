package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoadTripTests {
    @Test
    public void checkRoadTrip() {
        int[] cityDistances = new int[] {
            0, 2, 4, 5, 6, 7, 8, 11, 14, 15, 18
        };
        int maxD = 3;

        int possibilities = RoadTrip.possibilities(cityDistances, maxD);
        Assertions.assertEquals(11, possibilities);
    }
}
