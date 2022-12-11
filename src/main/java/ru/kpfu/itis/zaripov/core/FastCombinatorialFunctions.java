package ru.kpfu.itis.zaripov.core;

import java.math.BigInteger;
import java.util.Map;
import java.util.Optional;

import static ru.kpfu.itis.zaripov.core.MathCore.factorize;

public class FastCombinatorialFunctions implements MathOperations{

    @Override
    public long permutation(int n, int... repeats) {
        BigInteger result = BigInteger.valueOf(factorial(n));

        for(int repeat : repeats) {
            result = result.divide(
                    BigInteger.valueOf(factorial(repeat))
            );
        }
        return result.longValue();
    }

    @Override
    public long combination(int n, int k, boolean withRepeats) {
        if (withRepeats) {
            return combWithoutRep(n + k - 1, k);
        } else {
            return combWithoutRep(n, k);
        }
    }

    @Override
    public long placement(int n, int k, boolean withRepeats) {
        if (withRepeats) {
            return pow(n, k);
        }
        return placementsWithoutRep(n, k);
    }

    protected long combWithoutRep(int n, int m) {
        Map<Integer, Integer> nFactMultiplies = factorize(n);
        Map<Integer, Integer> mFactMultiplies = factorize(m);
        Map<Integer, Integer> subtractionFactMultiplies = factorize(n - m);

        nFactMultiplies.entrySet().forEach(integerIntegerEntry -> {
            Integer degree1 = integerIntegerEntry.getValue();
            Integer degree2 = Optional.ofNullable(mFactMultiplies.get(integerIntegerEntry.getKey())).orElse(0);
            Integer degree3 = Optional.ofNullable(subtractionFactMultiplies.get(integerIntegerEntry.getKey())).orElse(0);

            integerIntegerEntry.setValue(degree1 - degree2 - degree3);
        });

        long result = 1;

        for (Map.Entry<Integer, Integer> entry : nFactMultiplies.entrySet()) {
            result *= pow(entry.getKey(), entry.getValue());
        }
        return result;
    }

    protected long placementsWithoutRep(int n, int k) {
        Map<Integer, Integer> nFactMultipliers = factorize(n);
        Map<Integer, Integer> subtractionFactMultipliers = factorize(n - k);

        nFactMultipliers.entrySet().forEach(entry -> {
            Integer degree = entry.getValue() -
                    Optional.ofNullable(
                                subtractionFactMultipliers.get(entry.getKey())
                    ).orElse(0);
            entry.setValue(degree);
        });

        long result = 1;

        for (Map.Entry<Integer, Integer> entry : nFactMultipliers.entrySet()) {
            result *= pow(entry.getKey(), entry.getValue());
        }
        return result;
    }

    // <= 20
    public long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n = " + n);
        }
        if (n == 0) {
            return 1;
        } else if (n == 1 || n == 2) {
            return n;
        }

        Map<Integer, Integer> multipliers = factorize(n);
        long result = 1;

        for (Map.Entry<Integer, Integer> entry : multipliers.entrySet()) {
            result *= pow(entry.getKey(), entry.getValue());
        }

        return result;
    }

    protected long pow(int base, int exp) {

        long result = 1;

        while (true) {
            if (exp % 2 == 1)
                result *= base;
            exp >>= 1;
            if (exp == 0)
                break;
            base *= base;
        }

        return result;
    }
}
