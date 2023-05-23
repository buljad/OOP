package ru.nsu.izhuravskii;

import java.util.Arrays;
import java.util.List;

/**
 * A variant of searching a non-prime number in the list using threads.
 */
public class ThreadMode {

    private boolean notPrimeFlag = false;

    /**
     * A method with logic of finding a non-prime number.
     */
    public class ThreadFinder extends Thread {
        private final List<Long> numbers;

        public ThreadFinder(List<Long> numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            for (Long i : numbers) {
                if (NotPrimeNumbers.isNotPrime(i)) {
                    notPrimeFlag = true;
                    break;
                }
            }
        }
    }

    /**
     * This method is about separating list of numbers to threads
     * and finding a non-prime number using ThreadFinder method.
     *
     * @param numbers - list of numbers to check.
     * @param numberOfThreads - quantity of threads to separate.
     * @return - returns boolean value:
     *           true if at least one number in list is not prime, else false.
     */
    public boolean multiThreadFinder(List<Long> numbers, int numberOfThreads) {
        int listLength = numbers.size();
        int partOfList;
        if (listLength > numberOfThreads) {
            partOfList = listLength / numberOfThreads;
        } else {
            partOfList = 1;
            numberOfThreads = listLength;
        }
        ThreadFinder[] threads = new ThreadFinder[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int fromIndex = partOfList * i;
            int toIndex = partOfList * (i + 1);
            threads[i] = new ThreadFinder(numbers.subList(fromIndex, toIndex));
            threads[i].start();

        }
        checkThreads(threads);
        return notPrimeFlag;
    }

    /**
     * This method's duty is to check how all the threads ended their work.
     *
     * @param threads - list of threads.
     */
    public void checkThreads(ThreadFinder[] threads) {
        Arrays.stream(threads).forEach(finderThread -> {
            try {
                finderThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
