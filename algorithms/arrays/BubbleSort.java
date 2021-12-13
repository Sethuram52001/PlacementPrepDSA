package algorithms;

import java.util.*;

/*
 * bubble sort:
 * time complexity: O(N^2)
 * space complexity: O(1)
 */

public class BubbleSort {
    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped = false;
        for (int k = 0; k < n; k++) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 64, 25, 12, 22, 11 };
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
