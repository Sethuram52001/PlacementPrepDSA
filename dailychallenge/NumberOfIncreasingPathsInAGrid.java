/*
Problem:
You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.

Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell. 
Since the answer may be very large, return it modulo 109 + 7.

Two paths are considered different if they do not have exactly the same sequence of visited cells.

Link: https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/description/

Solution:
* We can use dp.
* dp[row][col] = (1 + dp[row][col - 1] + dp[row][col + 1] + dp[row + 1][col] + dp[row - 1][col]) 
*/

import java.util.*;

public class NumberOfIncreasingPathsInAGrid {
    int mod = (int) (1e9 + 7);

    public int countPaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int paths = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                paths = (paths + getNoOfPaths(grid, r, c, -1, dp)) % mod;
            }
        }

        return paths;
    }

    private int getNoOfPaths(int[][] grid, int r, int c, int prev, int[][] dp) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] <= prev) {
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int down = getNoOfPaths(grid, r + 1, c, grid[r][c], dp);
        int up = getNoOfPaths(grid, r - 1, c, grid[r][c], dp);
        int left = getNoOfPaths(grid, r, c - 1, grid[r][c], dp);
        int right = getNoOfPaths(grid, r, c + 1, grid[r][c], dp);
        dp[r][c] = (1 + left + right + up + down) % mod;
        return dp[r][c];
    }
}
