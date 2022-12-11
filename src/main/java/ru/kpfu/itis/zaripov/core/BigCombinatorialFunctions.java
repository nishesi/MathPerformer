package ru.kpfu.itis.zaripov.core;

import java.math.BigInteger;
import java.util.Map;
import java.util.Optional;

import static ru.kpfu.itis.zaripov.core.MathCore.factorize;

public class BigCombinatorialFunctions {

    public static BigInteger permutation(int n, int... repeats) {
        BigInteger result = factorial(n);

        for(int repeat : repeats) {
            result = result.divide(factorial(repeat));
        }

        return result;
    }

    public static BigInteger combination(int n, int k, boolean withRepeats) {
        if (withRepeats) {
            return combWithoutRep(n + k - 1, k);
        } else {
            return combWithoutRep(n, k);
        }
    }


    public static BigInteger placement(int n, int k, boolean withRepeats) {
        if (withRepeats) {
            return pow(n, k);
        }
        return placementsWithoutRep(n, k);
    }

    protected static BigInteger combWithoutRep(int n, int m) {
        Map<Integer, Integer> nFactMultiplies = factorize(n);
        Map<Integer, Integer> mFactMultiplies = factorize(m);
        Map<Integer, Integer> subtractionFactMultiplies = factorize(n - m);

        nFactMultiplies.entrySet().forEach(integerIntegerEntry -> {
            Integer degree1 = integerIntegerEntry.getValue();
            Integer degree2 = Optional.ofNullable(mFactMultiplies.get(integerIntegerEntry.getKey())).orElse(0);
            Integer degree3 = Optional.ofNullable(subtractionFactMultiplies.get(integerIntegerEntry.getKey())).orElse(0);

            integerIntegerEntry.setValue(degree1 - degree2 - degree3);
        });

        BigInteger result = BigInteger.valueOf(1);

        for (Map.Entry<Integer, Integer> entry : nFactMultiplies.entrySet()) {
            result = result.multiply(pow(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    protected static BigInteger placementsWithoutRep(int n, int k) {
        Map<Integer, Integer> nFactMultipliers = factorize(n);
        Map<Integer, Integer> subtractionFactMultipliers = factorize(n - k);

        nFactMultipliers.entrySet().forEach(entry -> {
            Integer degree = entry.getValue() -
                    Optional.ofNullable(
                            subtractionFactMultipliers.get(entry.getKey())
                    ).orElse(0);
            entry.setValue(degree);
        });

        BigInteger result = BigInteger.valueOf(1);

        for (Map.Entry<Integer, Integer> entry : nFactMultipliers.entrySet()) {
            result = result.multiply(pow(entry.getKey(), entry.getValue()));
        }
        return result;
    }
    protected static BigInteger pow(int base, int exp) {

        BigInteger bigintBase = BigInteger.valueOf(base);

        BigInteger result = BigInteger.valueOf(1);

        while (true) {
            if (exp % 2 == 1)
                result = result.multiply(bigintBase);
            exp >>= 1;
            if (exp == 0)
                break;
            bigintBase = bigintBase.multiply(bigintBase);
        }

        return result;
    }

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n = " + n);
        }
        if (n == 0) {
            return BigInteger.valueOf(1);
        } else if (n == 1 || n == 2) {
            return BigInteger.valueOf(n);
        }

        Map<Integer, Integer> multipliers = factorize(n);

        BigInteger result = BigInteger.valueOf(1);

        for (Map.Entry<Integer, Integer> entry : multipliers.entrySet()) {
            result = result.multiply(
                    pow(entry.getKey(), entry.getValue())
            );
        }

        return result;
    }
}
