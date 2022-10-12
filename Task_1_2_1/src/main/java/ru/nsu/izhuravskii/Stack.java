package ru.nsu.izhuravskii;

import java.util.Arrays;

import java.util.Objects;

import java.lang.Object;

public class Stack <T> {
    private int cnt;
    private T[] stack;
    private int stackLen;

    @SuppressWarnings("unchecked")
    public void stack_init(int capacity) {
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

    public void push_stack(T[] new_stack) {
        for(T i : new_stack) {
            push(i);
        }
    }

    public void pop() {
        if (cnt != 0) {
            stack[cnt] = null;
            cnt--;
        }
    }
    public void pop_stack(int num) {
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
