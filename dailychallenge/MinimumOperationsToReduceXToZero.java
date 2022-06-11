/*
Problem:
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or 
the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for 
future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

Link: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

Solution:
Think in reverse; instead of finding the minimum prefix + suffix, find the maximum subarray. Finding 
the maximum subarray is standard and can be done greedily. We can find the maximum subarray using a sliding 
window.
*/

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int maxLen = -1, currSum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while (l <= r && currSum > sum - x) {
                currSum -= nums[l++];
            }

            if (currSum == sum - x) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}