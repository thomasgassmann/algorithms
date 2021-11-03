package com.thomasgassmann;

import org.junit.jupiter.api.Test;

public class SubsetSumTests {
    @Test
    public void CheckNaive() {
        AssertionHelpers.AssertEqual(SubsetSum.SubsetSumNaive(new int[] {
                1, 6, 2, 11, 6, 1, 6, 1
        }), new int[] { 6, 11 });
    }

    @Test
    public void CheckDivideAndConquer() {
        AssertionHelpers.AssertEqual(SubsetSum.DivideAndConquer(new int[] {
                1, 6, 2, 11, 6, 1, 6, 1
        }), new int[] { 1, 2, 6, 1, 6, 1 });
    }

    @Test
    public void CheckDP() {
        AssertionHelpers.AssertEqual(SubsetSum.SubsetSumDP(new int[] {
                1, 6, 2, 11, 6, 1, 6, 1
        }), new int[] { 11, 6 });
    }
}
