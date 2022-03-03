/*
Problem:
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.

Link: https://leetcode.com/problems/combinations/

Solution:
backtracking
*/

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), combinations);
        return combinations;
    }
    
    private void backtrack(int val, int n, int k, List<Integer> combination, List<List<Integer>> combinations) {
        if(combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i = val; i <= n; i++) {
            combination.add(i);
            backtrack(i + 1, n, k, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }    
}