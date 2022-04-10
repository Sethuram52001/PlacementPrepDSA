/*
Problem:
You are given a 0-indexed string expression of the form "<num1>+<num2>" where <num1> and <num2> represent positive integers.

Add a pair of parentheses to expression such that after the addition of parentheses, expression is a valid mathematical expression 
and evaluates to the smallest possible value. The left parenthesis must be added to the left of '+' and the right parenthesis must 
be added to the right of '+'.

Return expression after adding a pair of parentheses such that expression evaluates to the smallest possible value. If there are 
multiple answers that yield the same result, return any of them.

The input has been generated such that the original value of expression, and the value of expression after adding any pair of parentheses 
that meets the requirements fits within a signed 32-bit integer.

Link: https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/

Solution:
Generate pairs using dfs and check for the position of parentheses with hashset.
Now, evaluate each expression after the addition of parentheses.
*/

public class MinimizeResultByAddingParenthesesToExpression {
    long maxValue = Integer.MAX_VALUE;
    String expectedString = "";
    HashSet<int[]> visited = new HashSet<>();

    public String minimizeResult(String expression) {
        int addPos = expression.indexOf('+');
        dfs(expression, addPos - 1, addPos + 3);
        return expectedString;
    }

    private void dfs(String exp, int l, int r) {
        if (l < 0 || r > exp.length() + 1) {
            return;
        }
        evaluateExp(exp, l, r);
        visited.add(new int[] { l, r });

        dfs(exp, l - 1, r + 1);
        dfs(exp, l - 1, r);
        dfs(exp, l, r + 1);
    }

    private void evaluateExp(String exp, int l, int r) {
        if (visited.contains(new int[] { l, r })) {
            return;
        }

        StringBuilder sb = new StringBuilder(exp);
        sb.insert(l, '(');
        sb.insert(r, ')');

        String newExp = sb.toString();
        int pStart = newExp.indexOf('(');
        int pEnd = newExp.indexOf(')');
        String a = newExp.substring(0, pStart);
        String b = newExp.substring(pStart + 1, pEnd);
        String c = newExp.substring(pEnd + 1);

        int val1 = 1, val2 = 1, val3 = 1;
        if (!a.equals("")) {
            val1 = Integer.valueOf(a);
        }
        if (!b.equals("")) {
            int idx = b.indexOf("+");
            val2 = Integer.valueOf(b.substring(0, idx)) + Integer.valueOf(b.substring(idx + 1));
        }
        if (!c.equals("")) {
            val3 = Integer.valueOf(c);
        }

        long val = val1 * val2 * val3;
        if (val < maxValue) {
            maxValue = val;
            expectedString = newExp;
        }

    }
}