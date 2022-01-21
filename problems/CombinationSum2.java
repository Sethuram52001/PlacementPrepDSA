/*
Problem:
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Link: https://leetcode.com/problems/combination-sum-ii/

Solution:
backtracking approach
*/

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtrack(int[] candidates, int idx, int target, List<Integer> combination,
            List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}
