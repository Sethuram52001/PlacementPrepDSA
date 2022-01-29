/*
Problem:
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element 
which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Link: https://leetcode.com/problems/single-element-in-a-sorted-array/

Solution:
We can observe the pattern that:
nums: 1 1 2 3 3 4 4
idx:  0 1 2 3 4 5 6

=> the left part of the unique element appears as pairs(even idx, odd idx) whereas towards right of the unique element
the elements appear in pari of(odd idx, even idx)

=> now can use binary search to solve this case
*/

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}