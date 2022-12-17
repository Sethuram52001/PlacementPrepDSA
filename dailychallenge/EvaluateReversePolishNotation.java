/*
Problem:
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would 
always evaluate to a result, and there will not be any division by zero operation.

Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

Solution:
Stack - conditional statements
*/

import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (token.equals("-")) {
                int b = st.pop(), a = st.pop();
                st.push(a - b);
            } else if (token.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (token.equals("/")) {
                int b = st.pop(), a = st.pop();
                st.push(a / b);
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}
