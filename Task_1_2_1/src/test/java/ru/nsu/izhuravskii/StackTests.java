package ru.nsu.izhuravskii;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


public class StackTests {

    /**
     * The first Test with stack where pushed only numbers.
     */

    @Test
    public void firstTest() {
        Stack <Integer> st1 = new Stack<>();
        st1.stack_init(3);
        Stack <Integer> st2 = new Stack<>();
        st2.stack_init(3);

        st1.push(1);
        st1.push(2);
        st1.push(3);

        st2.push(1);
        st2.push(2);
        st2.push(3);

        Assertions.assertEquals(st1, st2);
    }


}
