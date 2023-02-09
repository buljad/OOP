package ru.nsu.izhuravskii;

import java.lang.Math;

import static java.lang.Math.sqrt;

public class NotPrimeNumbers {
    public boolean IsNotPrime (long num) {
        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}

