package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NimGameTests {
    @Test
    public void CheckNimGame() {
        Assertions.assertEquals(NimGame.NimGame(5, 5), false);
    }
}
