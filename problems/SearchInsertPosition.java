/*
Problem:
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would 
be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Link: https://leetcode.com/problems/search-insert-position/

Solution:
Binary search
*/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        
        return nums[left] < target ? left + 1: left;
    }   
}