package com.thomasgassmann;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTests {
    @Test
    public void BinarySearchTest() {
        assertEquals(3, Search.BinarySearch(new int[] {
                1, 4, 5, 8, 9, 10, 15, 17, 19, 25
        }, 8));
    }

    @Test
    public void InterpolationSearchTest() {
        assertEquals(3, Search.InterpolationSearch(new int[] {
                1, 4, 5, 8, 9, 10, 15, 17, 19, 25
        }, 8));
    }

    @Test
    public void ExponentialSearchTest() {
        assertEquals(3, Search.ExponentialSearch(new int[] {
                1, 4, 5, 8, 9, 10, 15, 17, 19, 25
        }, 8));
    }

}
