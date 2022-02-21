/*
Problem:
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
A subarray is a contiguous subsequence of the array.

Link: https://leetcode.com/problems/maximum-product-subarray/

Solution:
Similar to Kadane's algorithm, we will keep track of the min value and max value possible to reach until the idx,
and we update the global max. 
*/

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxProd = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i]*temp, Math.max(min*nums[i], nums[i]));
            min = Math.min(nums[i]*temp, Math.min(min*nums[i], nums[i]));
            maxProd = Math.max(maxProd, max);
        }
        
        return maxProd;
    }   
}