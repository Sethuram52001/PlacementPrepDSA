package algorithms;

import java.util.Arrays;

/*
 * insertion sort:
 * time complexity: O(N^2)
 * space complexity: O(1)
*/


public class InsertionSort {
    private static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int value = nums[i];
            int hole = i;
            while (hole > 0 && nums[hole - 1] > value) {
                nums[hole] = nums[hole - 1];
                hole = hole - 1;
            }
            nums[hole] = value;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 64, 25, 12, 22, 11 };
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
