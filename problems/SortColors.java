package problems;

import java.util.Arrays;

/*
Question:
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

Solution:
Dutch National Flag algo - maintain 3 pointers - l, m, h
left side of l must be 0 and right side of h should be 1
*/

public class SortColors {
    private static void sortColors(int[] nums) {
        int l = 0, h = nums.length - 1, mid = 0;
        
        while(mid <= h) {
            if(nums[mid] == 0) {
                swap(nums, l, mid);
                l++;
                mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, h);
                h--;
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
