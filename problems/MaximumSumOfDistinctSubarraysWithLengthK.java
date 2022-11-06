/*
Problem:
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of 
nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, 
return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Link: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/

Solution:
Sliding window + set to keep track of duplicates
*/

import java.util.*;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        int left = 0, right = k;
        Set<Integer> set = new HashSet<>();
        for (int idx = 0; idx < k; idx++) {
            set.add(nums[idx]);
            sum += nums[idx];
        }

        if (set.size() == k) {
            maxSum = Math.max(maxSum, sum);
        }

        while (right < nums.length) {
            if (nums[left] != nums[left + 1]) {
                set.remove(nums[left]);
            }
            sum -= nums[left];
            left++;
            sum += nums[right];
            set.add(nums[right]);
            if (set.size() == k) {
                maxSum = Math.max(sum, maxSum);
            }

            right++;
        }

        return maxSum;
    }
}
