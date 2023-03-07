package ru.nsu.izhuravskii;

import java.util.Arrays;
import java.util.List;

/**
 * A variant of searching a non-prime number in the list using threads.
 */
public class ThreadMode {

    private boolean notPrimeFlag = false;

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

    public boolean multiThreadFinder(List<Long> numbers, int numberOfThreads) {
        int maxThreads = Runtime.getRuntime().availableProcessors();
        if (numberOfThreads > maxThreads) {
            numberOfThreads = maxThreads;
        }
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
            if (i <= numberOfThreads) {
                toIndex = listLength;
            }
            threads[i] = new ThreadFinder(numbers.subList(fromIndex, toIndex));
            threads[i].start();

        }
        checkThreads(threads);
        return notPrimeFlag;
    }

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

