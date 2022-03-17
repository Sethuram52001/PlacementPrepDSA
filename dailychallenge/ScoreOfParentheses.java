/*
Problem:
Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

Link: https://leetcode.com/problems/score-of-parentheses/

Solution: 
Stack: Our goal is to maintain the score at the current depth we are on. 
When we see an opening bracket, we increase our depth, and our score at the new depth is 0. 
When we see a closing bracket, we add twice the score of the previous deeper part - except 
when counting (), which has a score of 1.

O(1) space : The final sum will be a sum of powers of 2, as every core (a substring (), 
with score 1) will have it's score multiplied by 2 for each exterior set of parentheses 
that contains that core.
*/

import java.util.*;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int bal = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                bal++;
            } else {
                bal--;
                if (s.charAt(i - 1) == '(') {
                    score += (int) Math.pow(2, bal);
                }
            }
        }

        return score;
    }
    
    public int scoreOfParentheses_Stack(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                st.push(0);
            }
            else {
                int currBal = st.pop();
                int res = st.pop();
                
                res += (int)Math.max(2*currBal, 1);
                
                st.push(res);
            }
        }
        
        return st.pop();
    }
}