/*
Problem:
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Link: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

Solution:
We can use stack to keep track of the indices of the invalid parentheses.
*/

import java.util.*;
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')' || s.charAt(i) == '(') {
                if(st.isEmpty()) {
                    st.push(i);
                }
                else if(s.charAt(st.peek()) == '(' && s.charAt(i) == ')') {
                    st.pop();
                }
                else {
                    st.push(i);
                }
            }
            sb.append(s.charAt(i));
        }
        
        while(!st.isEmpty()) {
            sb.deleteCharAt(st.pop());
        }
        
        return sb.toString();
    }
}
