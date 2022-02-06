/*
Problem:
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

Solution:
We can have 2 pointers, one to keep the actual constrainted array and another to traverse the array
While traversing we can check for the duplicate count with a count variable
*/

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int idx = 1, count = 1, n = nums.length;
        int duplicateAllowed = 2;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == nums[i]) {
                if (count < duplicateAllowed) {
                    nums[idx++] = nums[i];
                }
                count++;
            } else {
                count = 1;
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}