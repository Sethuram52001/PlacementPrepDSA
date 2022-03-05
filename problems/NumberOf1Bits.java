/*
Problem:
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Link: https://leetcode.com/problems/number-of-1-bits/

Solution:
We can use logical bitwise and to check if the last digit is 1 or not.
Then we can right shift the number to check the next bit.
*/

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int noOfOnes = 0;
        for(int i = 0; i < 32; i++) {
            noOfOnes += (n & 1);
            n >>= 1;
        }   
        return noOfOnes;
    }   
}