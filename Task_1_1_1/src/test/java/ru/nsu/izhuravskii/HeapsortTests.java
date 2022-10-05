package ru.nsu.izhuravskii;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class HeapsortTests {

    /**
     * The first test with a common heapsort.
     */

    @Test

    public void first_test() {
        int[] arrCorrect = {0, 1, 2, 3, 4, 5};
        int[] arrIncorrect = {1, 5, 0, 2, 4, 3};

        heapsort ob = new heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }

    /**
     * The second test with an array which consists only same elements.
     */

    @Test

    public void second_test() {

        int[] arrCorrect = {0, 0, 0, 0, 0, 0};
        int[] arrIncorrect = {0, 0, 0, 0, 0, 0};

        heapsort ob = new heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }

    /**
     * The third test with an array with only one element.
     */

    @Test

    public void third_test() {

        int[] arrCorrect = {0};
        int[] arrIncorrect = {0};

        heapsort ob = new heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }

    /**
     * The fourth test with negative numbers.
     */

    @Test

    public void fourth_test() {
        int[] arrCorrect = {-2, -1, 0, 1, 2, 3};
        int[] arrIncorrect = {0, -2, 1, 3, 2, -1};

        heapsort ob = new heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }

    /**
     * The fifth test with an empty array.
     */

    @Test

    public void fifth_test() {
        int[] arrCorrect = {};
        int[] arrIncorrect = {};

        heapsort ob = new heapsort();
        ob.sort(arrIncorrect);

        assertArrayEquals(arrIncorrect, arrCorrect);
    }
}
