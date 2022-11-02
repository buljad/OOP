package ru.nsu.izhuravskii;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for Heapsort.java program.
 */
public class HeapsortTests {

    /**
     * Test with a common heapsort.
     */
    @Test
    public void sortTest() {
        int[] arrCorrect = {0, 1, 2, 3, 4, 5};
        int[] arrIncorrect = {1, 5, 0, 2, 4, 3};

        Heapsort ob = new Heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }

    /**
     * Test with an array which consists only same elements.
     */
    @Test
    public void sameElementsTest() {

        int[] arrCorrect = {0, 0, 0, 0, 0, 0};
        int[] arrIncorrect = {0, 0, 0, 0, 0, 0};

        Heapsort ob = new Heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }

    /**
     * Test with an array with only one element.
     */
    @Test
    public void oneElementTest() {

        int[] arrCorrect = {0};
        int[] arrIncorrect = {0};

        Heapsort ob = new Heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }

    /**
     * Test with negative numbers.
     */
    @Test
    public void negativeTest() {
        int[] arrCorrect = {-2, -1, 0, 1, 2, 3};
        int[] arrIncorrect = {0, -2, 1, 3, 2, -1};

        Heapsort ob = new Heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }

    /**
     * Test with an empty array.
     */
    @Test
    public void emptyTest() {
        int[] arrCorrect = {};
        int[] arrIncorrect = {};

        Heapsort ob = new Heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }
}
