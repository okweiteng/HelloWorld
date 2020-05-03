package com.wt.study.algorithm.stackqueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackWithGetMin {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public StackWithGetMin() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newData) {
        stackData.push(newData);
        if (stackMin.isEmpty()) {
            stackMin.push(newData);
            return;
        }
        if (newData <= this.getMin()) {
            stackMin.push(newData);
        }
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new EmptyStackException();
        }
        int value = stackData.pop();
        if (value == this.getMin()) {
            stackMin.pop();
        }
        return value;

    }

    private int getMin() {
        if (stackMin.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackMin.peek();
    }
}
