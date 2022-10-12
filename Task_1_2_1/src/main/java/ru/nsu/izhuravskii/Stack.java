package ru.nsu.izhuravskii;

import java.util.Arrays;

import java.lang.Object;

public class Stack <T>{
    public int cnt;
    public T[] stack;
    public int stackLen;

    public void stack_init(int capacity) {
        cnt = 0;
        stackLen = capacity;
        stack = (T[]) new Object[stackLen];
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

}
