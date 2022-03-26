/*
Problem:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Link: https://leetcode.com/problems/generate-parentheses/

Solution: 
backtracking
*/

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), parenthesis);
        return parenthesis;
    }

    private void backtrack(int l, int r, int n, StringBuilder sb, List<String> parenthesis) {
        if (sb.length() == 2 * n) {
            parenthesis.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append("(");
            backtrack(l + 1, r, n, sb, parenthesis);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(")");
            backtrack(l, r + 1, n, sb, parenthesis);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}