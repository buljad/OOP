package ru.nsu.izhuravskii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for ThreadMode of finding a non-prime number.
 */
public class ThreadModeTests {

    @Test
    public void oneThreadOnlyPrimeTest() {
        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 5L, 7L, 11L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 1);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void oneThreadNotOnlyPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 11L, 12L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 1);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void twoThreadOnlyPrimeTest() {
        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 5L, 7L, 11L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 2);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void twoThreadNotOnlyPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 4L, 5L, 7L, 11L, 12L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 2);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void threeThreadOnlyPrimeTest() {
        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 5L, 7L, 11L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 3);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void threeThreadNotOnlyPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 11L, 12L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 3);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fourThreadShortOnlyPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 4);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fourThreadLongPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 11L, 17L, 1L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 3);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fourThreadLongNotPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 7L, 11L, 17L, 6L, 1L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 4);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fiveThreadShortNotPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 5);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fiveThreadLongNotPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 17L, 23L, 29L, 37L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 5);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fiveThreadLongPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 11L, 1L, 13L, 17L, 23L, 29L, 37L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 5);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sixThreadShortNotPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 6);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sixThreadLongNotPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 6);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sixThreadLongPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 11L, 1L, 13L, 17L, 23L, 29L, 37L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 6);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sevenThreadShortPrimeTest() {
        List<Long> numbers = Arrays.asList(1L, 11L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 7);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sevenThreadLongNotPrimeTest() {
        List<Long> numbers =
                Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 7);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sevenThreadLongPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 11L, 1L, 13L, 17L, 23L, 29L, 37L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 7);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void eightThreadShortPrimeTest() {
        List<Long> numbers = Arrays.asList(1L, 11L, 13L, 17L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 8);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void eightThreadLongNotPrimeTest() {
        List<Long> numbers =
                Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 8);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void eightThreadLongPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 11L, 1L, 13L, 17L, 23L, 29L, 37L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(numbers, 8);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void threadsDivisionTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        int numberOfThreads = 6;
        ThreadMode act = new ThreadMode();
        ThreadMode.ThreadFinder[] actualValue = act.threadDivision(numbers, numberOfThreads);
        List<Integer> exp = List.of(2, 2, 1, 1, 1, 1);
        List<Integer> actual = Arrays.stream(actualValue).map(t ->
                t.getNumbers().size()).collect(Collectors.toList());
        Assertions.assertEquals(exp, actual);

    }
}
