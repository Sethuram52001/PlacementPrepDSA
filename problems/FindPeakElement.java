/*
Problem:
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

Link: https://leetcode.com/problems/find-peak-element/

Solution:
Binary search:
we know that,
if nums[mid] < nums[mid + 1] then there must lie a peek in range of [mid + 1, right]
else in range of [0, mid]

Some notes on why the solution works:
1. https://www.youtube.com/watch?v=HtSuA80QTyo&list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb&index=1
2. https://leetcode.com/problems/find-peak-element/discuss/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search
*/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length  - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        return left;
    }   
}