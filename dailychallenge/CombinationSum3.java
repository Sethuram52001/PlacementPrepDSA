/*
Problem:
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
* Only numbers 1 through 9 are used.
* Each number is used at most once.

Return a list of all possible valid combinations. The list must not contain the same combination twice, 
and the combinations may be returned in any order.

Link: https://leetcode.com/problems/combination-sum-iii/

Solution:
Backtracking
*/
import java.util.*;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), combinations);
        return combinations;
    }
    
    private void backtrack(int k, int n, int start, List<Integer> combination, List<List<Integer>> combinations) {
        if(k == combination.size() && n == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            combination.add(i);
            backtrack(k, n - i, i + 1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}