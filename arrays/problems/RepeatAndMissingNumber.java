package problems;

import java.util.*;

/*
Problem:
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Link: https://www.interviewbit.com/problems/repeat-and-missing-number-array/

Solution:
We can use a hashset or sum of numbers and sum of squared numbers
but the most optimal way is to use xor

note: rightmost set bit = n & ~(n - 1)
*/

public class RepeatAndMissingNumber {
    private static int[] repeatedNumber(int[] A) {
        int xor = A[0];
        for (int i = 1; i < A.length; i++) {
            xor = xor ^ A[i];
        }

        for (int i = 1; i <= A.length; i++) {
            xor = xor ^ i;
        }

        int rightMostSetBit = xor & ~(xor - 1);
        int x = 0, y = 0;

        for (int i = 0; i < A.length; i++) {
            if ((rightMostSetBit & A[i]) != 0) {
                x = x ^ A[i];
            } else {
                y = y ^ A[i];
            }
        }

        for (int i = 1; i <= A.length; i++) {
            if ((rightMostSetBit & i) != 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }

        int repeat = 0;
        int missing = 0;
        for (int i : A) {
            if (x == i) {
                repeat = x;
                missing = y;
            } else if (y == i) {
                repeat = y;
                missing = x;
            }
        }
        return new int[] { repeat, missing };
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 5, 3};
        int[] ans = repeatedNumber(arr);
        System.out.println(Arrays.toString(ans));
    }
}