/*
Problem:
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Link: https://leetcode.com/problems/fibonacci-number/

Solution:
Bottom-up DP
*/

public class FibonacciNumber {
    public int fib(int n) {
        int prev = 0, curr = 1;
        if (n == 0) {
            return prev;
        }

        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }

        return curr;
    }
}