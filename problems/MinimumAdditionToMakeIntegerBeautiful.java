/*
Problem:
You are given two positive integers n and target.

An integer is considered beautiful if the sum of its digits is less than or equal to target.

Return the minimum non-negative integer x such that n + x is beautiful. The input will be 
generated such that it is always possible to make n beautiful.

Link: https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/

Solution:
1. My post on leetcode: https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/discuss/2758742/Java-solution-easy-to-understand-with-intuition-behind-the-logic
*/

public class MinimumAdditionToMakeIntegerBeautiful {
    public long makeIntegerBeautiful(long n, int target) {
        int sum = sumOfDigits(n);
        if (sum <= target) {
            return 0;
        }

        long mux = n / 10;
        long div = 10;
        while (mux != 0) {
            long nextPos = (mux + 1) * div;
            if (sumOfDigits(nextPos) <= target) {
                return nextPos - n;
            }
            div *= 10;
            mux = n / div;
        }

        long noOfDigits = String.valueOf(n).length();
        long nextNum = (long) Math.pow(10, noOfDigits);
        return nextNum - n;
    }

    private int sumOfDigits(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
