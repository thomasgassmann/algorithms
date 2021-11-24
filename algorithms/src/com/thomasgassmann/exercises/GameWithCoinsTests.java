package com.thomasgassmann.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameWithCoinsTests {
    @Test
    public void CheckGameWithCoins() {
        Assertions.assertEquals(GameWithCoins.GameWithCoins(new int[]{
                1, 20, 20, 100, 5, 5
        }), 101);
    }
}
