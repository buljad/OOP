package ru.nsu.izhuravskii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Stack.java program.
 */
public class StackTests {

    /**
     * Test with push function.
     */

    @Test
    public void pushTest() {
        Stack<Integer> st1 = new Stack<>();
        st1.stackInit(3);
        Stack<Integer> st2 = new Stack<>();
        st2.stackInit(3);

        st1.push(1);
        st1.push(2);
        st1.push(3);

        st2.push(1);
        st2.push(2);
        st2.push(3);

        Assertions.assertEquals(st1, st2);
    }

    /**
     * Test with pop function.
     */
    @Test
    public void popTest() {
        Stack<Integer> st1 = new Stack<>();
        st1.stackInit(4);
        Stack<Integer> st2 = new Stack<>();
        st2.stackInit(4);

        st1.push(1);
        st1.push(2);
        st1.push(3);

        st2.push(1);
        st2.push(2);
        st2.push(3);
        st2.push(4);
        st2.pop();

        Assertions.assertEquals(st1, st2);
    }

    /**
     * Test with pushStack function.
     */

    @Test
    public void pushStackTest() {
        Stack<Integer> st1 = new Stack<>();
        st1.stackInit(4);
        Stack<Integer> st2 = new Stack<>();
        st2.stackInit(4);

        Stack<Integer> arr = new Stack<>();
        arr.stackInit(4);

        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);


        st1.pushStack(arr);

        st2.push(1);
        st2.push(2);
        st2.push(3);
        st2.push(4);

        Assertions.assertEquals(st1, st2);
    }

    /**
     * Test with popStack function.
     */

    @Test
    public void popStackTest() {
        Stack<Integer> st1 = new Stack<>();
        st1.stackInit(4);
        Stack<Integer> st2 = new Stack<>();
        st2.stackInit(4);

        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.push(4);


        st2.push(1);
        st2.push(2);

        st1.popStack(2);

        Assertions.assertEquals(st1, st2);
    }

    /**
     * Test with the pop return action.
     */

    @Test
    public void popReturnTest() {
        Stack<Integer> st1 = new Stack<>();
        st1.stackInit(2);
        Stack<Integer> st2 = new Stack<>();
        st2.stackInit(2);

        st1.push(1);
        st1.push(1);

        Integer t = st1.pop();

        st2.push(t);

        Assertions.assertEquals(st1, st2);
    }
    /**
     * Test with comparing of empty stacks and extra pop action.
     */

    @Test
    public void emptyStackTest() {
        Stack<Integer> st1 = new Stack<>();
        st1.stackInit(2);
        Stack<Integer> st2 = new Stack<>();
        st2.stackInit(2);

        st1.push(1);
        st2.push(1);

        st1.pop();
        st2.pop();
        st2.pop();

        Assertions.assertEquals(st1, st2);
    }

    /**
     * Test with overflowing of stack's capacity.
     */
    @Test
    public void overflowingTest() {
        Stack<Integer> st1 = new Stack<>();
        st1.stackInit(1);
        Stack<Integer> st2 = new Stack<>();
        st2.stackInit(1);

        for (int i = 0; i < 20; i++) {
            st1.push(i);
            st2.push(i);
        }

        Assertions.assertEquals(st1, st2);
    }

    /**
     * Test with count function.
     */
    @Test
    public void countTest() {
        Stack<Integer> st1 = new Stack<>();
        st1.stackInit(4);

        int a = 0;
        for (int i = 0; i < 10; i++) {
            st1.push(1);
            a++;
        }

        int b = st1.count();
        Assertions.assertEquals(a, b);
    }

}
