package ru.kpfu.itis.zaripov.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MathCore {

    protected static Map<Integer, Integer> factorize(int n) {
        int[] simpleNumbers = findSimpleNumbers(n);
        Map<Integer, Integer> multipliers = new HashMap<>();

        for (int simpleNumber : simpleNumbers) {
            int k = n / simpleNumber;
            int c = 0;
            while (k > 0) {
                c += k;
                k /= simpleNumber;
            }
            multipliers.put(simpleNumber, c);
        }
        return multipliers;
    }

    // The Sieve of Eratosthenes
    protected static int[] findSimpleNumbers(int n) {
        boolean[] numbers = new boolean[n + 1];

        for (int i = 2; i * i <= n; i++) {
            if (!numbers[i]) {
                for (int j = i * i; j <= n; j += i) {
                    numbers[j] = true;
                }
            }
        }

        ArrayList<Integer> simpleNumbers = new ArrayList<>();

        for (int i = 2; i < numbers.length; i++) {
            if (!numbers[i]) {
                simpleNumbers.add(i);
            }
        }

        return simpleNumbers.stream().mapToInt(x -> x).toArray();
    }
}
