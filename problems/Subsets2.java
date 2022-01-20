/*
Problem:
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
 
Link: https://leetcode.com/problems/subsets-ii/

Solution:
We can sort the array to avoid hashset to remove duplicates
now we can use a standard backtracking recursive algo to generate the subsets
*/

import java.util.*;
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        search(0, nums, subsets, new ArrayList<>());
        return subsets;
    }

    private void search(int idx, int[] nums, List<List<Integer>> subsets, List<Integer> subset) {
        subsets.add(new ArrayList<Integer>(subset));

        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i - 1] == nums[i]) {
                continue;
            }
            subset.add(nums[i]);
            search(i + 1, nums, subsets, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
