/*
Problem:
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Link: https://leetcode.com/problems/subsets/

Solution:
backtracking solution

Time Complexity: O(2^n) for generating every subset and O(k)  to insert every subset in another data structure if the average length 
of every subset is k. Overall O(k * 2^n).

Space Complexity: O(2^n * k) to store every subset of average length k. Auxiliary space is O(n)  if n is the depth of the recursion tree.
*/

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));
        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}
