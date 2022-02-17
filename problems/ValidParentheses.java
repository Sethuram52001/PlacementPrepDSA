/*
Problem:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Link: https://leetcode.com/problems/valid-parentheses/

Solution:
Stack to check the balance of the parentheses.
*/

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(st.isEmpty()) {
                st.push(ch);
            }
            else if(ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            }
            else if(st.peek() == '(' && ch == ')') {
                st.pop();
            }
            else if(st.peek() == '[' && ch == ']') {
                st.pop();
            }
            else if(st.peek() == '{' && ch == '}') {
                st.pop();
            }
            else {
                return false;
            }
        }
        return st.isEmpty();   
    }
}