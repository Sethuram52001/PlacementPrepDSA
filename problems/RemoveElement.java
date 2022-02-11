/*
Problem:
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of 
the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final
result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Link: https://leetcode.com/problems/remove-element/

Solution:
We can use two pointer approach to solve it.
But we can improve the solution, when elements to be removed are rare:
When we encounter nums[i]=valnums[i] = valnums[i]=val, we can swap the current element out with the last element and dispose the last one. 
This essentially reduces the array's size by 1.

Note that the last element that was swapped in could be the value you want to remove itself. But don't worry, in the next iteration we will still check this element.
*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length, i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public int removeElement_(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}