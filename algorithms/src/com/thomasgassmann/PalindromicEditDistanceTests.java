package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromicEditDistanceTests {
    @Test
    public void checkMinimumDistance() {
        Assertions.assertEquals(
                3,
                PalindromicEditDistance.Palindromic_Edit_Distance("ETHZETHZ".toCharArray()));

        Assertions.assertEquals(
                19,
                PalindromicEditDistance.Palindromic_Edit_Distance("TZEHHEHZTTTHTEHZZTH".toCharArray())
        );
    }
}
