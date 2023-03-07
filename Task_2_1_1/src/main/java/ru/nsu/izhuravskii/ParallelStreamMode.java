package ru.nsu.izhuravskii;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A variant of solving with using a parallelStream.
 */
public class ParallelStreamMode {
    /**
     * A finder of non-prime number with parallelStream.
     * @param numbers - a list of numbers to check.
     * @return - returning boolean value: true if at least one number in list is not prime, else false.
     */
    public static boolean parallelStreamFinder (@NotNull List<Long> numbers){
        return numbers.parallelStream().anyMatch(NotPrimeNumbers::isNotPrime);
    }
}
