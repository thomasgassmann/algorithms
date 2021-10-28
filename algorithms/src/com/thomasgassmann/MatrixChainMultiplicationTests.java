package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixChainMultiplicationTests {
    @Test
    public void CheckOptimalMatrixChosen() {
        var matrices = new int[][][]{
                {
                        {1}, {2}, {3}
                },
                {
                        {3, 2, 1}
                },
                {
                        {4}, {5}, {6}
                }
        };

        int cost = MatrixChainMultiplication.MostEfficientMatrixAssociativity(matrices);
        Assertions.assertEquals(cost, 6);
    }
}
