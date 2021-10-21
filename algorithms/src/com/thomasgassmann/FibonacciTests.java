package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTests {
    @Test
    public void CheckFibonacci() {
        Assertions.assertEquals(Fibonacci.FibonacciRecursive(5), 5);
    }

    @Test
    public void CheckFibonacciMemoization() {
        int[] values = new int[15];
        Assertions.assertEquals(Fibonacci.FibonacciMemoization(15, values), 610);
    }

    @Test
    public void CheckFibonacciDynamicProgramming() {
        Assertions.assertEquals(Fibonacci.FibonacciDynamicProgramming(15), 610);
    }
}
