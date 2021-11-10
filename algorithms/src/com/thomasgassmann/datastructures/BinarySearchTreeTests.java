package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class BinarySearchTreeTests {
    @Test
    public void checkBinarySearchTree() {
        var tree = new BinarySearchTree();
        var random = new Random(42);
        var values = new int[100];
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt();
        }

        for (int i = 0; i < values.length; i++) {
            tree.insert(values[i]);
        }

        for (int i = 0; i< values.length; i++) {
            Assertions.assertEquals(true, tree.contains(values[i]));
        }

        for (int i = 0; i < values.length / 2; i++) {
            tree.delete(values[i]);
        }

        for (int i = 0; i < values.length; i++) {
            Assertions.assertEquals(values.length / 2 <= i, tree.contains(values[i]));
        }
    }
}
