import java.util.*;

/*
 * merge sort: 
 * time complexity: O(N*LOG(N))
 * space complexity: O(N)
 */

public class MergeSort {
    private static void merge(int arr[], int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;

        int left[] = new int[len1];
        int right[] = new int[len2];

        for (int i = 0; i < len1; ++i) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < len2; ++j) {
            right[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
  
    private static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String args[]) {
        int[] nums = new int[] { 64, 25, 12, 22, 11 };
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
