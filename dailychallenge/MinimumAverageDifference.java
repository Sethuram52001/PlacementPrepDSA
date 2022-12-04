/*
Problem:
You are given a 0-indexed integer array nums of length n.
The average difference of the index i is the absolute difference between the average of the first i + 1 elements of 
nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.
Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.

Note:
* The absolute difference of two numbers is the absolute value of their difference.
* The average of n elements is the sum of the n elements divided (integer division) by n.
* The average of 0 elements is considered to be 0.

Link: https://leetcode.com/problems/minimum-average-difference/description/

Solution:
Keep track of the running sum and total sum to complete it in 2 pass.
*/

public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long runningSum = 0;
        long minDiff = Integer.MAX_VALUE;
        int minDiffIdx = -1, n = nums.length;
        for (int idx = 0; idx < n - 1; idx++) {
            runningSum += nums[idx];
            long diff = Math.abs(runningSum / (idx + 1) - (sum - runningSum) / (n - idx - 1));
            if (diff < minDiff) {
                minDiff = diff;
                minDiffIdx = idx;
            }
        }

        return sum / n < minDiff ? n - 1 : minDiffIdx;
    }
}
