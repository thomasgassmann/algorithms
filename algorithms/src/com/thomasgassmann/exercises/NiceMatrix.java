package com.thomasgassmann.exercises;

import com.thomasgassmann.Indicies;

public class NiceMatrix {
    public static Indicies FindInNiceMatrix(int[][] a, int b) {
        if (a.length != a[0].length) {
            throw new IllegalArgumentException();
        }

        int i = a.length - 1;
        int j = 0;

        while (a[i][j] != b) {
            if (a[i][j] < b)
                j++;
            else
                i--;
        }

        return new Indicies(i, j);
    }
}
