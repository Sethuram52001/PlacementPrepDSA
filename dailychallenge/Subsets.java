/*
Problem:
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Link: https://leetcode.com/problems/subsets/

Solution:
backtracking
*/

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums,0, new ArrayList<>(), subsets);
        return subsets;
    }
    
    private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));
        
        for(int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }    
}
