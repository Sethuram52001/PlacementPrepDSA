/*
Problem:
Given an integer array nums and two integers k and p, return the number of distinct subarrays which have at 
most k elements divisible by p.

Two arrays nums1 and nums2 are said to be distinct if:

They are of different lengths, or
There exists at least one index i where nums1[i] != nums2[i].
A subarray is defined as a non-empty contiguous sequence of elements in an array.

Link: https://leetcode.com/problems/k-divisible-elements-subarrays/

Solution:
We can use a prefix array to keep track the number of elements divisible at each interval (0, i).
Next we count all unique valid subsets, subset (i, j) is valid  if pSum(i, j) <= k.
*/

import java.util.*;

public class KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        pre[1] = nums[0] % p == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            pre[i + 1] = pre[i];
            if (nums[i] % p == 0) {
                pre[i + 1] += 1;
            }
        }

        Set<List<Integer>> distSub = new HashSet<>();
        for (int i = 0; i < n; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = i; j < n; j++) {
                sub.add(nums[j]);
                if (pre[j + 1] - pre[i] > k) {
                    break;
                }

                distSub.add(new ArrayList<>(sub));
            }
        }
        return distSub.size();
    }
}