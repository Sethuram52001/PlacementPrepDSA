/*
Problem:
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Link: https://leetcode.com/problems/valid-palindrome-ii/

Solution:
2 pointers - in the first iteration when we encounter a inequality, we call the checkPalindrome
to check for palindrome when a character was deleted from the string
*/

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return checkPalindrome(s, l + 1, r) || checkPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean checkPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}