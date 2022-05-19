/*
Problem:
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the 
product of those integers.

Return the maximum product you can get.

Link: https://leetcode.com/problems/integer-break/

Solution:
DP: we can construct the a dp array containing the max product we can get by
splitting the candidates from 1 to n. While doing so we eventually solve all the sub-problems
by which we can ultimately solve the final problem.
*/

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i == n ? 0 : i;
            for (int j = 1; j <= i; j++) {
                int temp = dp[j] * dp[i - j];
                dp[i] = Math.max(dp[i], temp);
            }
        }

        return dp[n];
    }
}