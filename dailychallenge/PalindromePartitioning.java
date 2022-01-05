/*
Problem:
Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Link: https://leetcode.com/problems/palindrome-partitioning/

Solution:
Backtracking
for palindrome check we can use dp to cut time by O(N) althought the overall time complexity will remain the same O(N*2^N)

dp palindrome:
A given string ss starting at index \text{start}start and ending at index \text{end}end is a palindrome if following conditions are satisfied :

The characters at \text{start}start and \text{end}end indexes are equal.
The substring starting at index \text{start}+1start+1 and ending at index \text{end}-1end−1 is a palindrome.
*/

import java.util.*;

public class PalindromePartitioning {
    private List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] isValid = new boolean[s.length()][s.length()];
        backtrack(s, 0, new ArrayList<>(), res, isValid);
        return res;
    }
    
    private void backtrack(String s, int start, List<String> pal, List<List<String>> res, boolean[][] isValid) {
        if(start >= s.length()) {
            res.add(new ArrayList<String>(pal));
        }
        
        for(int end = start; end < s.length(); end++) {
            if(s.charAt(start) == s.charAt(end) && (end - start <= 2 || isValid[start + 1][end - 1])) {
                isValid[start][end] = true;
                pal.add(s.substring(start, end + 1));
                backtrack(s, end + 1, pal, res, isValid);
                pal.remove(pal.size() - 1);
            }
        }
    }
}
