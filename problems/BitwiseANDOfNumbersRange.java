/*
Problem:
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers 
in this range, inclusive.

Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/

Solution:
Bitwise-AND of any two numbers will always produce a number less than or equal to the smaller number.
*/

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right &= (right - 1);
        }

        return right & left;
    }
}