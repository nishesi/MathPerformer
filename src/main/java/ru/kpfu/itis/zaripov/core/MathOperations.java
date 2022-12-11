package ru.kpfu.itis.zaripov.core;

public interface MathOperations {
    long permutation(int n, int... repeats);

    long combination(int n, int k, boolean withRepeats);

    long placement(int n, int k, boolean withRepeats);
}
