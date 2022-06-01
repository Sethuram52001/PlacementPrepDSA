/*
Problem:
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.

Link: https://leetcode.com/problems/running-sum-of-1d-array/

Solution:
Prefix sum
*/

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }

        return pre;
    }
}