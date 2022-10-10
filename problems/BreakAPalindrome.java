/*
Problem:
Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter 
so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.

Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a 
character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" 
because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.

Link: https://leetcode.com/problems/break-a-palindrome/

Solution:
Traverse the 1st half of the string, because it's a palindrome.
Replace the first non 'a' character with 'a', else replace the last
character to 'b'.
If the size of the string is 1, it is impossible to satisfy the problem statement
so return empty string "".
*/

public class BreakAPalindrome {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) {
            return "";
        }
        
        StringBuilder res = new StringBuilder(palindrome);
        boolean flag = true;
        for(int i = 0; i < palindrome.length()/2; i++) {
            if(palindrome.charAt(i) != 'a') {
                flag = false;
                res.setCharAt(i, 'a');
                break;
            }
        }
        
        if(flag) {
            res.setCharAt(palindrome.length() - 1, 'b');
        }
        
        return res.toString();
    }    
}
