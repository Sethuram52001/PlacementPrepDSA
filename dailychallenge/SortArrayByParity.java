/*
Problem:
Given an integer array nums, move all the even integers at the beginning of the 
array followed by all the odd integers.

Return any array that satisfies this condition.

Link: https://leetcode.com/problems/sort-array-by-parity/

Solution:
2 pointer - we can place 1 pointer at the starting position andanother pointer at 
the ending position, now we iterate until the 2 pointer cross each other, while doing 
we check for parity and if required we swap the elements
*/

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 1) {
                while (i < j && nums[j] % 2 == 1) {
                    j--;
                }
                swap(nums, i, j);
                j--;
                i++;
            } else {
                i++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}