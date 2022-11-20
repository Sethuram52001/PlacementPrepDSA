/*
Problem:
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the 
evaluation.
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Link: https://leetcode.com/problems/basic-calculator/description/

Solution:
Stack - to handle parantheses
*/

import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int result = 0, number = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number *= 10;
                number += ch - '0';
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                st.push(result);
                st.push(sign);
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= st.pop();
                result += st.pop();
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}