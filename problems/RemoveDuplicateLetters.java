/*
Problem:
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Link: https://leetcode.com/problems/remove-duplicate-letters/

Solution:
stack
*/

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (seen[ch - 'a']) {
                continue;
            }

            while (!st.isEmpty() && st.peek() > ch && i < lastIdx[st.peek() - 'a']) {
                seen[st.pop() - 'a'] = false;
            }

            st.push(ch);
            seen[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
