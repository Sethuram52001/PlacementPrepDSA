import java.util.*;
/*
 * binary search:
 * time complexity: O(log n)
 * space complexity: O(log n)[recursive] | O(1)[iterative] 
 */

public class Search {

    private static int recBinSearch(int[] nums, int target, int l, int h) {
        if (l <= h && l < nums.length) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return recBinSearch(nums, target, l, mid - 1);
            } else {
                return recBinSearch(nums, target, mid + 1, h);
            }
        }
        return -1;
    }

    private static void recBinSearch(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println("found at: " + recBinSearch(nums, target, 0, nums.length));
    }

    private static int itBinSearchHelper(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
    private static void itBinSearch(int[] nums, int target) {
        Arrays.sort(nums);

        System.out.println("found at: " + itBinSearchHelper(nums, target));
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 19, 10, 5, 3, 3, 2, 6, 7, 9, 11 };
        recBinSearch(nums, 100);
        itBinSearch(nums, 10);
    }
}