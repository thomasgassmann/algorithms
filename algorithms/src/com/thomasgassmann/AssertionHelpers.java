package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;

public class AssertionHelpers {
    public static void AssertEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            Assertions.fail();
            return;
        }

        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(a[i], b[i]);
        }
    }
}
