package problems;

import java.util.Arrays;

/*
 Question:
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation 
 of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order 
(i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory

link: https://leetcode.com/problems/next-permutation/

solution:
We can find the next permutation by plotting the array and find a way to increase the descending peak
*/

public class NextPermutation {
    private static void nextPermutation(int[] nums) {
        int idx1 = nums.length - 2, idx2 = 0;
        while(idx1 >= 0 && nums[idx1] >= nums[idx1 + 1]) {
            idx1--;
        }
        
        if(idx1 >= 0) {
            idx2 = nums.length - 1;
            while(nums[idx2] <= nums[idx1]) {
                idx2--;
            }
            swap(nums, idx1, idx2);
        }
        reverse(nums, idx1 + 1, nums.length - 1);
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 2 };
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
