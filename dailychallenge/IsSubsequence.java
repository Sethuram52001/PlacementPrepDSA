/*
Problem:
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Link: https://leetcode.com/problems/is-subsequence/

Solution:
2 pointers
*/

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int si = 0, ti = 0, sLen = s.length(), tLen = t.length();
        if(sLen == 0) {
            return true;
        }
        
        while(ti < tLen) {
            if(s.charAt(si) == t.charAt(ti)) {
                si += 1;
            }
            
            if(si == sLen) {
                return true;
            }
            ti += 1;
        }
        
        return false;
    }
}