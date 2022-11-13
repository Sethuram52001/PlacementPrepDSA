/*
Problem:
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string 
should only have a single space separating the words. Do not include any extra spaces.

Link: https://leetcode.com/problems/reverse-words-in-a-string/description/

Solution:
Save the words alone in a separate list and reverse the list.
Now, append the words in the list to form a new string.
*/

import java.util.*;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        List<String> res = new ArrayList<>();
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) != ' ') {
                for (int next = idx; next < s.length(); next++) {
                    if (s.charAt(next) == ' ') {
                        res.add(s.substring(idx, next));
                        idx = next;
                        break;
                    } else if (next == s.length() - 1) {
                        res.add(s.substring(idx));
                        idx = next;
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.reverse(res);
        for (String i : res) {
            sb.append(i);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
