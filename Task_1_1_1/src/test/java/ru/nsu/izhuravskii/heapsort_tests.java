package ru.nsu.izhuravskii;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class heapsort_tests {

    //The first test with a common heapsort
    @Test

    public void first_test() {
        int[] arr_correct = {0, 1, 2, 3, 4, 5};
        int[] arr_incorrect = {1, 5, 0, 2, 4, 3};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        assertArrayEquals(arr_incorrect, arr_correct);
    }

    //The second test with an array which consists only same elements

    @Test

    public void second_test() {

        int[] arr_correct = {0, 0, 0, 0, 0, 0};
        int[] arr_incorrect = {0, 0, 0, 0, 0, 0};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        assertArrayEquals(arr_incorrect, arr_correct);
    }


    //The third test with an array with only one element

    @Test

    public void third_test() {

        int[] arr_correct = {0};
        int[] arr_incorrect = {0};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        assertArrayEquals(arr_incorrect, arr_correct);
    }

    //The fourth test with negative numbers

    @Test

    public void fourth_test() {
        int[] arr_correct = {-2, -1, 0, 1, 2, 3};
        int[] arr_incorrect = {0, -2, 1, 3, 2, -1};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        assertArrayEquals(arr_incorrect, arr_correct);
    }

    //The fifth test with an empty array
    @Test

    public void fifth_test() {
        int[] arr_correct = {};
        int[] arr_incorrect = {};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        assertArrayEquals(arr_incorrect, arr_correct);
    }
}
