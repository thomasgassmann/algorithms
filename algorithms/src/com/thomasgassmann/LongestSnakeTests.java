package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LongestSnakeTests {
    @Test
    public void CheckLongestSnakeLength() {
        Assertions.assertEquals(LongestSnake.LongestSnakeLength(
                GetValues(),
                GetNeighbors()), 11);
        Assertions.assertEquals(LongestSnake.LongestSnakeLinearTimeLength(
                GetValues(),
                GetNeighbors()), 11);
    }

    @Test
    public void CheckLongestSnake() {
        AssertionHelpers.AssertEqual(LongestSnake.LongestSnake(
                GetValues(),
                GetNeighbors()
        ), new int[] { 12, 7, 6, 10, 16, 21, 22, 23, 18, 17, 11 });
        AssertionHelpers.AssertEqual(LongestSnake.LongestSnakeLinearTime(
                GetValues(),
                GetNeighbors()
        ), new int[] { 12, 7, 6, 10, 16, 21, 22, 23, 18, 17, 11 });
    }

    private int[] GetValues() {
        return new int[]{
                11, 12, 3, 21,
                10, 5, 3, 2, 20,
                9, 4, 11, 1, 2,
                1, 6, 5, 10, 9,
                12, 13, 6, 7, 8
        };
    }

    private HashMap<Integer, int[]> GetNeighbors() {
        HashMap<Integer, int[]> neighbors = new HashMap<>();
        neighbors.put(0, new int[]{1, 4, 5});
        neighbors.put(1, new int[]{0, 5, 2, 6});
        neighbors.put(2, new int[]{3, 1, 6, 7});
        neighbors.put(3, new int[]{2, 7, 8});
        neighbors.put(4, new int[]{0, 5, 9});
        neighbors.put(5, new int[]{0, 1, 4, 6, 9, 10});
        neighbors.put(6, new int[]{1, 2, 5, 7, 10, 11});
        neighbors.put(7, new int[]{2, 3, 6, 8, 11, 12});
        neighbors.put(8, new int[]{3, 7, 12, 13});
        neighbors.put(9, new int[]{4, 5, 10, 14, 15});
        neighbors.put(10, new int[]{5, 6, 9, 11, 15, 16});
        neighbors.put(11, new int[]{6, 7, 10, 12, 16, 17});
        neighbors.put(12, new int[]{7, 8, 11, 13, 17, 18});
        neighbors.put(13, new int[]{8, 12, 18});
        neighbors.put(14, new int[]{9, 15, 19});
        neighbors.put(15, new int[]{9, 10, 14, 16, 19, 20});
        neighbors.put(16, new int[]{10, 11, 15, 17, 20, 21});
        neighbors.put(17, new int[]{11, 12, 16, 18, 21, 22});
        neighbors.put(18, new int[]{12, 13, 17, 22, 23});
        neighbors.put(19, new int[]{14, 15, 20});
        neighbors.put(20, new int[]{15, 16, 19, 21});
        neighbors.put(21, new int[]{16, 17, 20, 22});
        neighbors.put(22, new int[]{17, 18, 21, 23});
        neighbors.put(23, new int[]{18, 22});
        return neighbors;
    }
}
