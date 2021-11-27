package algorithms;

import java.util.*;

/*
 * quick sort: 
 * time complexity: O(N*LOG(N)) ~ O(N^2) in worst case
 * space complexity: O(1)
 */

public class QuickSort {
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;

        for (int j = l; j <= r - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);
            quickSort(nums, l, pivot - 1);
            quickSort(nums, pivot + 1, r);
        }
    } 
    public static void main(String[] args) {
        int[] nums = new int[] { 64, 25, 12, 22, 11 };
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
