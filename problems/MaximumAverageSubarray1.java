/*
Problem:
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average 
value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Link: https://leetcode.com/problems/maximum-average-subarray-i/

Solution:
sliding window
*/

public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxAvg = (double)sum/k;
        
        for(int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxAvg = Math.max(maxAvg, (double)sum/k);
            }
        return maxAvg;
    }   
}