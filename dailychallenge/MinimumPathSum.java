/*
Problem:
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes 
the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Link: https://leetcode.com/problems/minimum-path-sum/description/

Solution:
Dynamic programming
*/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[r][c] = grid[r][c];
                if (c == 0 && r >= 1) {
                    dp[r][c] += dp[r - 1][c];
                }
                if (r == 0 && c >= 1) {
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] += Math.min(dp[r - 1][c], dp[r][c - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
