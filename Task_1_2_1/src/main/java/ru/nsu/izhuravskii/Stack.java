package ru.nsu.izhuravskii;

import java.util.Arrays;

import java.util.Objects;

import java.lang.Object;

public class Stack <T> {
    private int cnt;
    private T[] stack;
    private int stackLen;

    @SuppressWarnings("unchecked")
    public void stackInit(int capacity) {
        this.cnt = 0;
        this.stackLen = capacity;
        this.stack = (T[]) new Object[stackLen];
    }
    public void push(T obj) {
        cnt++;
        if (cnt > stackLen) {
            stackLen *= 2;
            stack = Arrays.copyOf(stack, stackLen);
        }
        stack[cnt--] = obj;
    }

    public void pushStack(T[] new_stack) {
        for(T i : new_stack) {
            push(i);
        }
    }

    public T pop() {
        if (cnt != 0) {
            cnt--;
            T prev = stack[cnt];
            stack[cnt] = null;
            return prev;
        } else {
            return null;
        }
    }
    public void popStack(int num) {
        for(int j = 0; j < num; j++) {
            pop();
        }
    }

    public int count() {
        return cnt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Stack<?> expected = (Stack<?>) obj;
        if (cnt != expected.cnt) {
            return false;
        }
        for (int i = 0; i < cnt; i++) {
            if (stack[i] != expected.stack[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cnt, stackLen);
        result = 31 * result + Arrays.hashCode(stack);
        return result;
    }

}
