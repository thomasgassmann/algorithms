package com.thomasgassmann.datastructures;

import com.thomasgassmann.AssertionHelpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class BinarySearchTreeTests {
    @Test
    public void checkOrder() {
        var data = new int[] { 7, 5, 10, 8, 11, 9, 15 };
        var tree = new BinarySearchTree();
        for (int i = 0; i < data.length; i++)
            tree.insert(data[i]);

        var inorder = tree.inorder();
        var preorder = tree.preorder();
        var postorder = tree.postorder();

        AssertionHelpers.AssertEqual(new int[] { 7, 5, 10, 8, 9, 11, 15 }, preorder.stream().mapToInt(p -> p).toArray());
        AssertionHelpers.AssertEqual(new int[] { 5, 9, 8, 15, 11, 10, 7 }, postorder.stream().mapToInt(p -> p).toArray());
        AssertionHelpers.AssertEqual(new int[] { 5, 7, 8, 9, 10, 11, 15 }, inorder.stream().mapToInt(p -> p).toArray());
    }

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
