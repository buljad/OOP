package ru.nsu.izhuravskii;

import static java.lang.Math.sqrt;

/**
 * There is a module for finding a non-prime number form list of Long numbers.
 */
public class NotPrimeNumbers {
    /**
     * Exact method of searching a non-prime number in the list.
     * @param num - number to check on primality.
     * @return - returning boolean value: true if number is not prime, else false.
     */
    public static boolean isNotPrime(long num) {
        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}

