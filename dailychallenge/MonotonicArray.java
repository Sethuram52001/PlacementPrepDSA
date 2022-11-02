/*
Problem:
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array 
nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Link: https://leetcode.com/problems/monotonic-array/

Solution:
Assume the the series to be both increasing and decreasing at the start, 
and while traversing check if the condition fails, if both condition fails
the array is not monotonic.
*/

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true, decreasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                decreasing = false;
            } else if (nums[i] < nums[i + 1]) {
                increasing = false;
            }
        }

        return increasing || decreasing;
    }
}
