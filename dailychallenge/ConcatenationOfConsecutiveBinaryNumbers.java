/*
Problem:
Given an integer n, return the decimal value of the binary string formed by concatenating the binary 
representations of 1 to n in order, modulo 10^9 + 7.

Link: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

Solution:
Shift bitwise and add the values.
*/

public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1_000_000_007;
        for (int num = 1; num <= n; num++) {
            res = ((res << noOfBits(num)) + num) % mod;
        }
        return (int) res;
    }

    private int noOfBits(int n) {
        return Integer.toBinaryString(n).length();
    }
}