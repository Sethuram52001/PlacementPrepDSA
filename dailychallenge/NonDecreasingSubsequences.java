/*
Problem:
Given an integer array nums, return all the different possible non-decreasing subsequences of the given array 
with at least two elements. You may return the answer in any order.

Link: https://leetcode.com/problems/non-decreasing-subsequences/description/

Solution:
Backtracking
*/

import java.util.*;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> nonDecreasingSubsequences = new HashSet<>();
        backtrack(nums, 0, new ArrayList<>(), nonDecreasingSubsequences);
        return List.copyOf(nonDecreasingSubsequences);
    }

    private void backtrack(int[] nums, int idx, List<Integer> subsequence,
            Set<List<Integer>> nonDecreasingSubsequences) {
        if (subsequence.size() >= 2) {
            nonDecreasingSubsequences.add(new ArrayList<>(subsequence));
        }

        for (int i = idx; i < nums.length; i++) {
            if (subsequence.size() == 0 || subsequence.get(subsequence.size() - 1) <= nums[i]) {
                subsequence.add(nums[i]);
                backtrack(nums, i + 1, subsequence, nonDecreasingSubsequences);
                subsequence.remove(subsequence.size() - 1);
            }
        }
    }
}