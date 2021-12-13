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
        int partitionIdx = l;
        
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, partitionIdx);
                partitionIdx++;
            }
        }
        swap(nums, partitionIdx, r);
        return partitionIdx;
    }

    private static void quickSort(int[] nums, int l, int h) {
        if (l < h) {
            int pivotIdx = partition(nums, l, h);
            quickSort(nums, l, pivotIdx - 1);
            quickSort(nums, pivotIdx + 1, h);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 64, 25, 12, 22, 11 };
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
