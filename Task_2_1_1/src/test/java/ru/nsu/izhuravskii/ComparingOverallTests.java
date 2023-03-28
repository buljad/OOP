package ru.nsu.izhuravskii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ComparingOverallTests {
    private final List<Long> primeNumbersList = PrimeNumbersListInit();
    private final List<Long> notPrimeNumbersList = NotPrimeNumbersListInit();
    private List<Long> PrimeNumbersListInit() {
        List<Long> primeNumbersList = new ArrayList<>();
        for(int i = 0; i < 1000000; i++) {
            primeNumbersList.add(2000303L);
        }
        return primeNumbersList;
    }

    private List<Long> NotPrimeNumbersListInit() {
        List<Long> notPrimeNumbersList = new ArrayList<>();
        for(int i = 0; i < 1000000; i++) {
            notPrimeNumbersList.add(2000302L);
        }
        return notPrimeNumbersList;
    }

    @Test
    public void SequentialSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(22L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        SequentialMode test = new SequentialMode();
        boolean expectedValue = true;
        boolean actualValue = test.sequentialFinder(numbers);
        System.out.println("sequential small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void ParallelStreamSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        boolean expectedValue = true;
        boolean actualValue = ParallelStreamMode.parallelStreamFinder(numbers);
        System.out.println("parallel stream small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void oneThreadSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 1);
        System.out.println("1 thread small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void twoThreadSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 2);
        System.out.println("2 thread small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void threeThreadSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 3);
        System.out.println("3 thread small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fourThreadSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 4);
        System.out.println("4 thread small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fiveThreadSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 5);
        System.out.println("5 thread small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sixThreadSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 6);
        System.out.println("6 thread small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sevenThreadSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 7);
        System.out.println("7 thread small:" + (System.currentTimeMillis() - begTime)); System.out.println(System.currentTimeMillis() - begTime);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void eightThreadSmallTest() {
        long begTime = System.currentTimeMillis();
        List<Long> numbers = Arrays.asList(2L, 3L, 5L, 4L, 6L, 1L, 13L, 2L, 3L, 5L, 4L, 6L, 1L, 13L);
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(numbers, 8);
        System.out.println("8 thread small:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void SequentialBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        SequentialMode test = new SequentialMode();
        boolean expectedValue = false;
        boolean actualValue = test.sequentialFinder(primeNumbersList);
        System.out.println("sequential big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void SequentialBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        SequentialMode test = new SequentialMode();
        boolean expectedValue = true;
        boolean actualValue = test.sequentialFinder(notPrimeNumbersList);
        System.out.println("sequential big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void ParallelStreamBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        boolean expectedValue = false;
        boolean actualValue = ParallelStreamMode.parallelStreamFinder(primeNumbersList);
        System.out.println("parallel stream big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void ParallelStreamBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        boolean expectedValue = true;
        boolean actualValue = ParallelStreamMode.parallelStreamFinder(notPrimeNumbersList);
        System.out.println("parallel stream big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void oneThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 1);
        System.out.println("1 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void oneThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 1);
        System.out.println("1 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void twoThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 2);
        System.out.println("2 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void twoThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 2);
        System.out.println("2 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void threeThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 3);
        System.out.println("3 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void threeThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 3);
        System.out.println("3 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fourThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 4);
        System.out.println("4 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fourThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 4);
        System.out.println("4 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fiveThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 5);
        System.out.println("5 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fiveThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 5);
        System.out.println("5 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sixThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 6);
        System.out.println("6 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sixThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 6);
        System.out.println("6 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sevenThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 7);
        System.out.println("7 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sevenThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 7);
        System.out.println("7 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void eightThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 8);
        System.out.println("8 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void eightThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 8);
        System.out.println("8 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void nineThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 9);
        System.out.println("9 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void nineThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 9);
        System.out.println("9 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void tenThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 10);
        System.out.println("10 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void tenThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 10);
        System.out.println("10 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void elevenThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 11);
        System.out.println("11 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void elevenThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 11);
        System.out.println("11 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void twelveThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 12);
        System.out.println("12 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void twelveThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 12);
        System.out.println("12 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void thirteenThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 13);
        System.out.println("13 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void thirteenThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 13);
        System.out.println("13 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fourteenThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 14);
        System.out.println("14 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fourteenThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 14);
        System.out.println("14 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fifteenThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 15);
        System.out.println("15 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fifteenThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 15);
        System.out.println("15 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sixteenThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 16);
        System.out.println("16 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sixteenThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 16);
        System.out.println("16 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fiftyThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 50);
        System.out.println("50 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void fiftyThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 50);
        System.out.println("50 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void hundredThreadBigPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = false;
        boolean actualValue = test.multiThreadFinder(primeNumbersList, 100);
        System.out.println("100 thread big prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void hundredThreadBigNotPrimeTest() {
        long begTime = System.currentTimeMillis();
        ThreadMode test = new ThreadMode();
        boolean expectedValue = true;
        boolean actualValue = test.multiThreadFinder(notPrimeNumbersList, 100);
        System.out.println("100 thread big not prime:" + (System.currentTimeMillis() - begTime));
        Assertions.assertEquals(expectedValue, actualValue);
    }
}



