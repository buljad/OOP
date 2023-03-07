package ru.nsu.izhuravskii;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Sequential mode of checking list of numbers on primality.
 */
public class SequentialMode {
    /**
     * Main method that simply uses isNotPrime checking function from NotPrimeNumbers module.
     * @param numbers - a list of numbers to check.
     * @return - returning boolean value: true if at least one number in list is not prime, else false.
     */
    public boolean sequentialFinder(@NotNull List<Long> numbers) {
        for(Long i : numbers) {
            if(NotPrimeNumbers.isNotPrime(i)) {
                return true;
            }
        }
        return false;
    }
}
