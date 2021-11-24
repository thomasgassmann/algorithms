package com.thomasgassmann.exercises;

import com.thomasgassmann.Indicies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NiceMatrixTests {
    @Test
    public void CheckNiceMatrix() {
        int[][] nice = new int[][]{
                { 1, 2, 5, 7 },
                { 3, 4, 6, 8 },
                { 4, 5, 7, 9 },
                { 6, 9, 10, 11 }
        };

        int b = 8;

        Indicies ind = NiceMatrix.FindInNiceMatrix(nice, b);
        Assertions.assertEquals(ind.getI(), 1);
        Assertions.assertEquals(ind.getJ(), 3);
    }
}
