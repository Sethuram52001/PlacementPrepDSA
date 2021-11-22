package algorithms;

import java.util.Arrays;

/*
 * selection sort:
 * time complexity: O(N^2)
 * space complexity: O(1)
 */

public class SelectionSort {
    private static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 64, 25, 12, 22, 11 };
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
