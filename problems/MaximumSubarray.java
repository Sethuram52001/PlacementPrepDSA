/*
Question:
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Link: https://leetcode.com/problems/maximum-subarray/

Solution:
Kadane's algorithm for O(N) solution
*/

public class MaximumSubarray {
    private static int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] < 0) {
                sum = 0;
                max = Math.max(nums[i], max);
            }
            else {
                sum += nums[i];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int maxSub = maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println(maxSub);
    }
}
