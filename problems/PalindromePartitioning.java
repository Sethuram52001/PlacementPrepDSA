/*
Problem:
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.

Link: https://leetcode.com/problems/palindrome-partitioning/

Solution:
Backtrack and check for every string.
We can optimize the palindrome validity with DP - checking with a 2d array for whether the idx + 1 and end - 1 are true or not
*/

import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> pals = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), pals);
        return pals;

    }

    private void backtrack(String s, int idx, List<String> pal, List<List<String>> pals) {
        if (idx == s.length()) {
            pals.add(new ArrayList<>(pal));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isValid(s, idx, i)) {
                pal.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, pal, pals);
                pal.remove(pal.size() - 1);
            }
        }
    }

    private boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public List<List<String>> partitionDP(String s) {
        List<List<String>> pals = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        backtrack(s, 0, new ArrayList<>(), pals, dp);
        return pals;
        
    }
    
    private void backtrack(String s, int idx, List<String> pal, List<List<String>> pals, boolean[][] dp) {
        if(idx == s.length()) {
            pals.add(new ArrayList<>(pal));
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(s.charAt(idx) == s.charAt(i) && (i - idx <= 2 || dp[idx + 1][i - 1])) {
                dp[idx][i] = true;
                pal.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, pal, pals, dp);
                pal.remove(pal.size() - 1);
            }
        }
    }
}
