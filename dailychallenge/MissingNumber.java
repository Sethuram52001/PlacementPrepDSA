/*
Problem:
Given an array nums containing n distinct numbers in the range [0, n], return the only 
number in the range that is missing from the array.

Link: https://leetcode.com/problems/missing-number/

Solution:
missing number = (expected sum of n numbers) - (actual sum of n numbers)
*/

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int expectedSum = nums.length * (nums.length + 1) / 2;
        return expectedSum - sum;
    }
}