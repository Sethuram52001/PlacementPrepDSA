/*
Problem:
Reverse bits of a given 32 bits unsigned integer.

Link: https://leetcode.com/problems/reverse-bits/

Solution:
Bit manipulation
*/

public class ReverseBits {
    public int reverseBits(int n) {
        int reversed = 0;
        for(int i = 0; i < 32; i++) {
            reversed <<= 1;
            reversed += (n & 1);
            n >>= 1;
        }
        return reversed;
    }   
}