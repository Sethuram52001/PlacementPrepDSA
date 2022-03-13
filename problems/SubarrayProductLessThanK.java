/*
Problem:
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the 
product of all the elements in the subarray is strictly less than k.

Link: https://leetcode.com/problems/subarray-product-less-than-k/

Solution:
Sliding window
*/

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int l = 0, r = 0, n = nums.length;
        int product = 1, count = 0;
        while (r < n) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l++];
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}