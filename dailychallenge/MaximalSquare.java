/*
Problem:
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Link: https://leetcode.com/problems/maximal-square/
*/

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxSide = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if(i > 0 && j > 0) {
                        dp[i][j] += Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        return maxSide*maxSide;
    }
}
