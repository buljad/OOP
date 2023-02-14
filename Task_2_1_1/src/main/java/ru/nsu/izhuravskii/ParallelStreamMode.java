package ru.nsu.izhuravskii;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ParallelStreamMode {
    public boolean parallelStreamFinder (@NotNull List<Long> numbers) {
        return numbers.parallelStream().anyMatch(NotPrimeNumbers::isNotPrime);
    }
}
