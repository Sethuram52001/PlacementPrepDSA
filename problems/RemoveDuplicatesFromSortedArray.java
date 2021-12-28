/*
Problem:
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of 
the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final 
result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Solution: we can use 2 pointer approach
*/

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        
        for(; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j]; 
            }
        }
        
        return i + 1;
    }
}
