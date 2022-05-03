/*
Problem:
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray 
in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

Solution:
Thus, firstly we need to determine when the correctly sorted array goes wrong. We keep a track of this by 
observing rising slope starting from the beginning of the array. Whenever the slope falls, we know that the 
unsorted array has surely started. Thus, now we determine the minimum element found till the end of the array 
numsnums, given by minmin.

Similarly, we scan the array numsnums in the reverse order and when the slope becomes rising instead of falling, 
we start looking for the maximum element till we reach the beginning of the array, given by maxmax.

Then, we traverse over numsnums and determine the correct position of minmin and maxmax by comparing these elements 
with the other array elements. e.g. To determine the correct position of minmin, we know the initial portion of 
numsnums is already sorted. Thus, we need to find the first element which is just larger than minmin. Similarly, for 
maxmax's position, we need to find the first element which is just smaller than maxmax searching in numsnums backwards.
*/

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        boolean flag = false;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(nums[i], min);
            }
        }

        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(nums[i], max);
            }
        }

        int left, right;
        for (left = 0; left < nums.length; left++) {
            if (min < nums[left]) {
                break;
            }
        }

        for (right = nums.length - 1; right >= 0; right--) {
            if (max > nums[right]) {
                break;
            }
        }

        return right - left < 0 ? 0 : right - left + 1;
    }
}