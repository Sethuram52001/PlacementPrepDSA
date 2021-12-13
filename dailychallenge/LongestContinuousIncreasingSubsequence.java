/*
Problem:
Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.b
A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].

Link: https://leetcode.com/problems/longest-continuous-increasing-subsequence/


*/

public class LongestContinuousIncreasingSubsequence {
    private static int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                curr++;
            } else {
                max = Math.max(curr, max);
                curr = 1;
            }
        }
        return Math.max(curr, max);
    }
}
