/*
Problem:
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.

Link: https://leetcode.com/problems/power-of-two/

Solution:
Remainder logic.
*/

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) {
            return false;
        }
        
        while(n % 2 == 0) {
            n /= 2;
        }
        
        return n == 1;
    }
}
