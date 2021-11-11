package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class AVLTreeTests {
    @Test
    public void checkAVLTree() {
        // Arrange
        var tree = new AVLTree();
        var random = new Random(42);
        var values = new int[30];
        for (int i = 0; i < values.length; i++)
            values[i] = random.nextInt(values.length);

        // Act
        for (int i = 0; i < values.length; i++) {
            tree.insert(values[i]);
        }

        // Assert
        var root = tree.getRoot();
        int leftHeight = root.left.height();
        int rightHeight = root.right.height();
        Assertions.assertEquals(true,
                Math.abs(rightHeight - leftHeight) <= 1);

        for (int i = 0; i < values.length; i++) {
            Assertions.assertEquals(true, tree.contains(values[i]));
        }
    }
}
