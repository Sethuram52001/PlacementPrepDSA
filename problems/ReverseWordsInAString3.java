/*
Problem:
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/

Solution:
2 pointers
*/

public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') { 
                int j = i;
                while (j + 1 < str.length && str[j + 1] != ' ') { 
                    j++; 
                }
                reverse(str, i, j);
                i = j;
            }
        }
        return new String(str);
    }
    
    private void reverse(char[] str, int i, int j) {
        while(i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }   
}