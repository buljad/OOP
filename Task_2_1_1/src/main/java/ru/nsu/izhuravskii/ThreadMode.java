package ru.nsu.izhuravskii;

import java.util.Arrays;
import java.util.List;

public class ThreadMode {

    private boolean notPrimeFlag = false;
    public class threadFinder extends Thread {
        private final List<Long> numbers;

        public threadFinder(List<Long> numbers) {
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

    public boolean multiThreadFinder(List <Long> numbers, int numberOfThreads) {
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
        threadFinder[] threads = new threadFinder[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int fromIndex = partOfList * i;
            int toIndex = partOfList * (i + 1);
            if (i == numberOfThreads) {
                toIndex = listLength;
            }
            threads[i] = new threadFinder(numbers.subList(fromIndex, toIndex));
            threads[i].start();

        }
        checkThreads(threads);
        return notPrimeFlag;
    }
    public void checkThreads(threadFinder[] threads) {
        Arrays.stream(threads).forEach(finderThread -> {
            try {
                finderThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

