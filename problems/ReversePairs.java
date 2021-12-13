import java.util.*;
/*
 Problem:
 Given an integer array nums, return the number of reverse pairs in the array.

 A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
 
 Link: https://leetcode.com/problems/reverse-pairs/

 Solution:
 Use merge sort similar to inversion of array problem
*/

public class ReversePairs {
    private static int merge(int[] nums, int l, int m, int h) {
        int j = m + 1;
        int count = 0;
        for(int i = l; i <= m; i++) {
            while(j <= h && nums[i]/2.0 >nums[j]) {
                j++;
            }
            count += (j - (m + 1));
        }
        
        List<Integer> temp = new ArrayList<>();
        int left = l, right = m + 1;
        while(left <= m && right <= h) {
            if(nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            }
            else {
                temp.add(nums[right]);
                right++;
            }
        }
        
        while(left <= m) {
            temp.add(nums[left++]);
        }
        
        while(right <= h) {
            temp.add(nums[right++]);
        }
        
        for(int i = l; i<= h; i++) {
            nums[i] = temp.get(i - l);
        }
        return count;
    }
    
    private static int mergeSort(int[] nums, int l, int h) {
        int reversed = 0;
        if(l < h) {
            int m = l + (h-l)/2;
            reversed = mergeSort(nums, l, m);
            reversed += mergeSort(nums, m + 1, h);
            reversed += merge(nums, l, m, h);
        }
        return reversed;
    }
    
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    public static void main(String[] args) {
        
    }
}
