/*
Problem:
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Link: https://leetcode.com/problems/valid-palindrome/

Solution:
Two pointers
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(!(Character.isLetterOrDigit(s.charAt(i)))) {
                i++;
                continue;
            }
            
            if(!(Character.isLetterOrDigit(s.charAt(j)))) {
                j--;
                continue;
            }
            
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }   
}