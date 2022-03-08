/*
Problem:
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Solution:
2 binary search with slightly different constraints to find first and second idx
*/

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findSecond(nums, target);
        return result;
    }
    
    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
        
            if(nums[m] >= target) {
                r = m - 1;;
            }
            
            else {
                l = m + 1;
            }
            
            if(nums[m] == target) {
                idx = m;
            }
        }
        return idx;
    }
    
    private int findSecond(int[] nums, int target) {
        int idx = -1;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] <= target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
            if(nums[m] == target) {
                idx = m;
            }
        }
        return idx;
    }   
}