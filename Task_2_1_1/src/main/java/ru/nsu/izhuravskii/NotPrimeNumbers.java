package ru.nsu.izhuravskii;

import static java.lang.Math.sqrt;

public class NotPrimeNumbers {
    public static boolean isNotPrime(long num) {
        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}

