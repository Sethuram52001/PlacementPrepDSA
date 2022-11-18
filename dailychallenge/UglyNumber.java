/*
Problem:
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return true if n is an ugly number.

Link: https://leetcode.com/problems/ugly-number/description/

Solution: 
Check for other prime factors by continuous division of the number with 2, 3 and 5.
*/

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] divisors = new int[] { 2, 3, 5 };
        for (int divisor : divisors) {
            n = continuousDivision(n, divisor);
        }

        return n == 1;
    }

    private int continuousDivision(int dividend, int divisor) {
        while (dividend % divisor == 0) {
            dividend /= divisor;
        }

        return dividend;
    }
}
