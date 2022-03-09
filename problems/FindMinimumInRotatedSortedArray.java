/*
Problem:
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Solution:
Binary search: We do not set the exit condition as left <= right as we are trying to reach the index by converging:
if nums[mid] > nums[right], we know that the soln lies somewhere in the right side of mid, so we set left = mid + 1
else nums[mid] <= nums[right], we know that the soln must lie in between [left, mid] as it appears to be sorted in increasing fashion
*/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        return nums[left];
    }   
}