/*
Problem:
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number 
of 1's in the binary representation of i.

Link: https://leetcode.com/problems/counting-bits/

Solution:
we have X and Y in Such a way that,
X/2 = Y
then Number of set bits in X - Number of set bit in Y <= 1

There can be 2 cases
whether X is Odd or Even

X is ODD:

then the (LSB) Least Significant Bit will always be set and dividing by 2 means right shifting the number by 1 bit.
so if last bit is set and right shift it by 1 bit than the last set bit will be lost.
therfore the new number Y has 1 set bit less than in compare to X

X is Even:

then LSB will be equal to 0, therefore even we do right shift by1 bit then only this 0 bit will be lost and no set bit got lost
so When we have X has Even,

no of set bit in X = no of set bit in Y
and When X is ODD

no of set bit in X = 1 + no of set bit in Y
*/

public class CountingBits {
    public int[] countBits(int n) {
        if(n == 0) {
            return new int[]{0};
        }
        
        int[] noOfBits = new int[n + 1];
        noOfBits[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                noOfBits[i] = noOfBits[i / 2] + 1;
            }
            else {
                noOfBits[i] = noOfBits[i / 2];
            }
        }
        
        return noOfBits;
    }
}