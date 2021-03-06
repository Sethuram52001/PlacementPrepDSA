/*
Problem:
You are given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one 
palindromic subsequence from s.

Return the minimum number of steps to make the given string empty.

A string is a subsequence of a given string if it is generated by deleting some characters of a given 
string without changing its order. Note that a subsequence does not necessarily need to be contiguous.

A string is called palindrome if is one that reads the same backward as well as forward.

Link: https://leetcode.com/problems/remove-palindromic-subsequences/

Solution:
The string is only made of 2 characters, so we can boil down the question to 2 cases:
i. if the given string is palindrome then we need only 1 operation
ii. else we can remove all 'a' in on operation as 'aaa....aaaa' is valid palindromic subsequence, same with 'b'
    so we need atmost 2 operations
*/
public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s.equals("")) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}