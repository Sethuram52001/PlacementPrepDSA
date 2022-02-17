/*
Problem:
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates 
where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least 
one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Link: https://leetcode.com/problems/combination-sum/

Solution:
Backtracking
*/

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        solve(target, candidates, 0, new ArrayList<>(), combinations);
        return combinations;
    }
    
    private void solve(int target, int[] candidates, int idx, List<Integer> combination, List<List<Integer>> combinations) {
        if(target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i = idx; i < candidates.length; i++) {
            if(target < candidates[i]) {
                break;
            }
            
            combination.add(candidates[i]);
            solve(target - candidates[i], candidates, i, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}