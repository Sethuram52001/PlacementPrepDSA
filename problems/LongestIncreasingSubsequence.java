/*
Problem:
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without 
changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Link: https://leetcode.com/problems/longest-increasing-subsequence/

Solution:
Patience sorting algorithm - https://www.youtube.com/watch?v=K9M6g7BiBX4
*/

import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            Integer ceil = set.ceiling(n);
            if (ceil == null) {
                set.add(n);
            } else {
                set.remove(ceil);
                set.add(n);
            }
        }
        return set.size();
    }

    public int lengthOfLISDP(int[] nums) {
        int[] longestLTS = new int[nums.length];
        longestLTS[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            longestLTS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && longestLTS[i] < longestLTS[j] + 1) {
                    longestLTS[i] = longestLTS[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i : longestLTS) {
            max = Math.max(max, i);
        }
        return max;
    }
}