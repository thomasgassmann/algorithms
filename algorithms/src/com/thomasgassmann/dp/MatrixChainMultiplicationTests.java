package com.thomasgassmann.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MatrixChainMultiplicationTests {
    @Test
    public void CheckOptimalMatrixChosen() {
        var matrices = new int[][][]{
                {
                        {1}, {-1}, {2}, {-2}, {3}, {-3}
                },
                {
                        {3, -3, 2, -2, 1, -1}
                },
                {
                        {4}, {-4}, {5}, {-5}, {6}, {-6}
                },
                {
                        {1, 2, 3, 4, 5}
                }
        };

        var target = new MatrixChainMultiplication.Associativity[3];
        target[0] = new MatrixChainMultiplication.Associativity(0, 3);
        target[1] = new MatrixChainMultiplication.Associativity(1, 2);
        target[2] = new MatrixChainMultiplication.Associativity(1, 3);

        ArrayList<MatrixChainMultiplication.Associativity> assocs =
                new MatrixChainMultiplication()
                        .MostEfficientMatrixAssociativity(matrices);
        for (MatrixChainMultiplication.Associativity targetVal : target) {
            Assertions.assertTrue(assocs.stream().anyMatch(p -> p.from() == targetVal.from() &&
                                          p.to() == targetVal.to()));
        }
    }
}
