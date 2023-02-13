/*
Problem:
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

Link: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

Solution:
Maths | common logic
*/

public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        boolean isLowOdd, isHighOdd; 
        isLowOdd = low % 2 == 1;
        isHighOdd = high % 2 == 1;

        int range = high - low;
        if(isLowOdd || isHighOdd) {
            return range / 2 + 1;
        } 

        return range / 2;
    }
}
