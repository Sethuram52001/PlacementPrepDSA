/*
Problem:
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Link: https://leetcode.com/problems/permutations/

Solution:
backtracking
*/

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        solve(nums, 0, permutations);
        return permutations;
    }
    
    private void solve(int[] nums, int idx, List<List<Integer>> permutations) {
        if(idx == nums.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for(int i : nums) {
                permutation.add(i);
            }
            permutations.add(permutation);
            return;
        }
        
        for(int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            solve(nums, idx + 1, permutations);
            swap(nums, i, idx);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<List<Integer>> permute_(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums, visited, new ArrayList<>(), permutations);
        return permutations;
    }
    
    private void solve(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> permutations) {
        if(permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            solve(nums, visited, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}