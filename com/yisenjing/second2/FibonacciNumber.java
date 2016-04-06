package com.yisenjing.second2;

/**
 * Created by Yisen on 2/21/16.
 */
public class FibonacciNumber {

    public long fibonacci(int K) {
        long[] storage = new long[]{0, 1, 1};

        if (K < 0) {
            return 0;
        }

        if (K <= 1) {
            return storage[K];
        }

        int i = 0;
        while (i++ < K - 2) {
            long temp = storage[1] + storage[2];
            storage[0] = storage[1];
            storage[1] = storage[2];
            storage[2] = temp;
        }
        return storage[2];
    }
}
