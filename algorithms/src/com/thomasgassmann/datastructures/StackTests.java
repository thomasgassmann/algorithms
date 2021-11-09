package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTests {
    @Test
    public void CheckStack() {
        var stack = Stack.<Integer>newStack();
        CheckStack(stack);
    }

    @Test
    public void CheckArrayStack() {
        var stack = new ArrayStack<Integer>(3);
        CheckStack(stack);
    }

    private void CheckStack(IStack<Integer> stack) {
        Assertions.assertEquals(stack.isEmpty(), true);
        stack.push(1);
        Assertions.assertEquals(stack.top(), 1);
        Assertions.assertEquals(stack.pop(), 1);
        Assertions.assertEquals(stack.isEmpty(), true);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        Assertions.assertEquals(stack.top(), 9);
        Assertions.assertEquals(stack.top(), 9);
        Assertions.assertEquals(stack.pop(), 9);
        Assertions.assertEquals(stack.pop(), 7);
        Assertions.assertEquals(stack.pop(), 5);
    }
}
