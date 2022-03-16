/*
Problem:
Given a string s, return the longest palindromic substring in s.

Link: https://leetcode.com/problems/longest-palindromic-substring/

Solution:
We can expand around centers i.e idx positions which are taken as center, we can expand
until we meet the palindromic conditions.
*/

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int startIdx = 0, endIdx = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int max = Math.max(len1, len2);
            if(max > endIdx - startIdx + 1) {
                startIdx = i - (max - 1)/2;
                endIdx = i + max/2;
            }
        }
        return s.substring(startIdx, endIdx + 1);
    }
    
    private int expandAroundCenter(String s, int i, int j) {
        if(i < 0 || j >= s.length()) {
            return 0;
        }
        
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }   
}