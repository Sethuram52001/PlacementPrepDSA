/*
Problem:
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous 
subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Link: https://leetcode.com/problems/minimum-size-subarray-sum/

Solution:
2 pointers
*/

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int sum = 0;
        int minWindow = Integer.MAX_VALUE;
        
        for(; j < n ; j++) {
            sum += nums[j];
            while(sum >= target) {
                minWindow = Math.min(minWindow, j - i + 1);
                sum -= nums[i++];
            }
        }
        
        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }   
}