/*
Problem:
Given an integer num, return the number of steps to reduce it to zero.

In one step, if the current number is even, you have to divide it by 2, otherwise, 
you have to subtract 1 from it.

Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

Solution:
If even divide by 2 else subtract 1.
*/

public class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num % 2 == 0 ? num / 2 : num - 1;
        }
        return count;
    }
}