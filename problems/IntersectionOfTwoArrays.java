/*
Problem:
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique 
and you may return the result in any order.

Link: https://leetcode.com/problems/intersection-of-two-arrays/

Solution:
i. 2 sets
ii. sort both the arrays and use 2 pointers
iii. sort the shorter the array and use binary search

Note:
This is a Facebook interview question.
They ask for the intersection, which has a trivial solution using a hash or a set.

Then they ask you to solve it under these constraints:
O(n) time and O(1) space (the resulting array of intersections is not taken into consideration).
You are told the lists are sorted.

Cases to take into consideration include:
duplicates, negative values, single value lists, 0's, and empty list arguments.
Other considerations might include
sparse arrays.
*/

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) {
            return intersection(nums2, nums1);
        }
        
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        
        for(int num : nums1) {
            if(binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        
        int idx = 0;
        int[] res = new int[set.size()];
        
        for(Integer num : set) {
            res[idx++] = num;
        }
        
        return res;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] == target) {
                return true;
            }
            else if(nums[m] < target) {
                l++;
            }
            else {
                r--;
            }
        }
        return false;
    }

    public int[] intersection_two_sets(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }
        
        HashSet<Integer> intersection = new HashSet<>();
        for(int num : nums2) {
            if(set.contains(num)) {
                intersection.add(num);
            }
        }
        
        int[] res = new int[intersection.size()];
        int idx = 0;
        for(Integer num : intersection) {
            res[idx++] = num;
        }
        
        return res;
    }

    public int[] intersection_two_pointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        HashSet<Integer> set = new HashSet<>();
        
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j]) {
                j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int idx = 0;
        int[] res = new int[set.size()];
        for(Integer num : set) {
            res[idx++] = num;
        }
        
        return res;
    }
}