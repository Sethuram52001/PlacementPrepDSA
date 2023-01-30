/*
Problem:
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Link: https://leetcode.com/problems/n-th-tribonacci-number/description/

Solution:
dp - similar to fibanocci
*/

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int prev2 = 0, prev1 = 1, prev = 1;
        int val = 0;
        for (int i = 3; i <= n; i++) {
            val = prev2 + prev1 + prev;
            prev2 = prev1;
            prev1 = prev;
            prev = val;
        }

        return val;
    }
}
