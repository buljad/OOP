package ru.nsu.izhuravskii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

/**
 * Tests for SequentialMode of finding a non-prime number.
 */
public class SequentialModeTests {
    @Test
    public void notPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 9L);
        SequentialMode test = new SequentialMode();
        boolean expectedValue = true;
        boolean actualValue = test.sequentialFinder(numbers);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void onlyPrimeTest() {
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 7L, 11L);
        SequentialMode test = new SequentialMode();
        boolean expectedValue = false;
        boolean actualValue = test.sequentialFinder(numbers);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void onlyNotPrimeTest() {
        List<Long> numbers = Arrays.asList(4L, 6L, 8L, 10L, 12L);
        SequentialMode test = new SequentialMode();
        boolean expectedValue = true;
        boolean actualValue = test.sequentialFinder(numbers);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void onlyOneNumberTest() {
        List<Long> numbers = Arrays.asList(1L, 1L, 1L, 1L, 1L);
        SequentialMode test = new SequentialMode();
        boolean expectedValue = false;
        boolean actualValue = test.sequentialFinder(numbers);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void mixNotPrimeTest() {
        List<Long> numbers = Arrays.asList(19L, 29L, 1L, 4L, 5L);
        SequentialMode test = new SequentialMode();
        boolean expectedValue = true;
        boolean actualValue = test.sequentialFinder(numbers);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void mixPrimeTest() {
        List<Long> numbers = Arrays.asList(3L, 3L, 3L, 1L, 1L);
        SequentialMode test = new SequentialMode();
        boolean expectedValue = false;
        boolean actualValue = test.sequentialFinder(numbers);
        Assertions.assertEquals(expectedValue, actualValue);
    }

}
