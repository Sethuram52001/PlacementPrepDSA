package problems;

import java.util.*;

/*
 Problem:
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Link: https://leetcode.com/problems/unique-paths/

Solution:
1. brute - recursive
2. improve the brute using dp
3. it's a combinations problems

*/

public class UniquePaths {
    private static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int R = n - 1;
        double uniquePaths = 1;

        for (int i = 1; i <= R; i++) {
            uniquePaths = uniquePaths * (N - R + i) / i;
        }

        return (int) uniquePaths;
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsDP(3, 7));
        System.out.println(uniquePaths(3, 7));
    }
}
