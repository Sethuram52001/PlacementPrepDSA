/*
Problem:
You are given an integer array nums of length n, and an integer array queries of length m.

Return an array answer of length m where answer[i] is the maximum size of a subsequence that 
you can take from nums such that the sum of its elements is less than or equal to queries[i].

A subsequence is an array that can be derived from another array by deleting some or no 
elements without changing the order of the remaining elements.

Link: https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/

Solution:
Prefix sum + binary search
*/

import java.util.*;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] cumSum = new int[nums.length];
        cumSum[0] = nums[0];

        for (int idx = 1; idx < nums.length; idx++) {
            cumSum[idx] = cumSum[idx - 1] + nums[idx];
        }

        int[] res = new int[queries.length];
        for (int idx = 0; idx < queries.length; idx++) {
            res[idx] = binarySearch(cumSum, queries[idx]);
        }

        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left] > target ? left : left + 1;
    }
}
