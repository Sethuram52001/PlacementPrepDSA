/*
Problem:
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of 
nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], 
nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Link: https://leetcode.com/problems/maximum-sum-circular-subarray/description/

Solution:
1. case 1: maximum sum is not in cirucular array rather it is straight forward.
2. case 2: prefix part in the array + suffix part of the array => total sum - minimum sum in the subarray 
*/

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int max = 0, min = 0, maxSum = nums[0], minSum = nums[0], sum = 0;
        for (int num : nums) {
            max = Math.max(max + num, num);
            maxSum = Math.max(maxSum, max);
            min = Math.min(min + num, num);
            minSum = Math.min(minSum, min);
            sum += num;
        }

        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }
}
