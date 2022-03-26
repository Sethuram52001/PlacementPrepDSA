/*
Problem:
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations 
in any order.

Link: https://leetcode.com/problems/permutations-ii/

Solution:
Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.
Sort the array "int[] nums" to make sure we can skip the same value.
when a number has the same value with its previous, we can use this number only if his previous is used
*/

import java.util.*;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }

        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        solve(nums, visited, new ArrayList<>(), permutations);
        return permutations;
    }

    private void solve(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            permutation.add(nums[i]);
            solve(nums, visited, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}