/*
Problem:
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to 
group numbers and operators. You may return the answer in any order.

Link: https://leetcode.com/problems/different-ways-to-add-parentheses/

Solution:
We can use recursion to solve it.
*/

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);
                List<Integer> possibilities1 = diffWaysToCompute(part1);
                List<Integer> possibilities2 = diffWaysToCompute(part2);

                // trying out all combinations
                for(int x : possibilities1) {
                    for(int y : possibilities2) {
                        switch(ch) {
                            case '+':
                                res.add(x + y);
                                break;
                            case '-':
                                res.add(x - y);
                                break;
                            case '*':
                                res.add(x * y);
                                break;
                        }
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        
        return res;
    }   
}