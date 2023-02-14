package ru.nsu.izhuravskii;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SequentialMode {
    public boolean sequentialFinder(@NotNull List<Long> numbers) {
        for(Long i : numbers) {
            if(NotPrimeNumbers.isNotPrime(i)) {
                return true;
            }
        }
        return false;
    }
}
