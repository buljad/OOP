package ru.nsu.izhuravskii;

import java.lang.Object;
import java.util.Arrays;
import java.util.Objects;

/**
 * My realisation of stack on Java.
 *
 * @param <T> - generic type for making stack with opportunity to work with different types.
 */
public class Stack<T> {
    private int cnt;
    private T[] stack;
    private int stackLen;

    /**
     * Stack initialization.
     *
     * @param capacity - primary amount of arguments to add to stack.
     */
    @SuppressWarnings("unchecked")
    public void stackInit(int capacity) {
        this.cnt = 0;
        this.stackLen = capacity;
        this.stack = (T[]) new Object[stackLen];
    }

    /**
     * Procedure of adding one object to stack.
     *
     * @param obj - object to add.
     */
    public void push(T obj) {
        if (cnt >= stackLen) {
            stackLen *= 2;
            stack = Arrays.copyOf(stack, stackLen);
        }
        stack[cnt] = obj;
        cnt++;
    }

    /**
     * Procedure of adding some amount of objects to stack.
     *
     * @param newStack - array of objects to add.
     */
    public void pushStack(T[] newStack) {
        for (T i : newStack) {
            push(i);
        }
    }

    /**
     * Procedure of deleting one object from stack.
     *
     * @return - returning value of the previous object, if it exists.
     */
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

    /**
     * Procedure of deleting some amount of objects from stack.
     *
     * @param num - quantity of objects to delete.
     */
    public void popStack(int num) {
        for (int j = 0; j < num; j++) {
            pop();
        }
    }

    /**
     * Procedure to see, how many elements are in stack now.
     *
     * @return - returning a quantity of elements in stack.
     */
    public int count() {
        return cnt;
    }

    /**
     * Realisation of "equals" method for its working with generic types.
     *
     * @param obj - object to compare.
     *
     * @return - returning true, if elements are equal, else returning false.
     */
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
