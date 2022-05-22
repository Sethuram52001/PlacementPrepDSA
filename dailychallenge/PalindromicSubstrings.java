/*
Problem:
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

Link: https://leetcode.com/problems/palindromic-substrings/

Solution:
Idea is start from each index and try to extend palindrome for both odd and even length,
which can be done with the help of 2 pointers.
*/

public class PalindromicSubstrings {
    private int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    private void expandAroundCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i--) == s.charAt(j++)) {
            count++;
        }
    }
}