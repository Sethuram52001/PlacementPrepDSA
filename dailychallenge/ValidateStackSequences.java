/*
Problem:
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the 
result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

Link: https://leetcode.com/problems/validate-stack-sequences/

Solution:
Simulate the push and pop sequence using a stack
*/

import java.util.*;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int popIdx = 0;
        
        for(int num : pushed) {
            st.push(num);
            
            while(!st.isEmpty() && st.peek() == popped[popIdx]) {
                st.pop();
                popIdx++;
            }
        }
        
        return popIdx == popped.length;
    }   
}