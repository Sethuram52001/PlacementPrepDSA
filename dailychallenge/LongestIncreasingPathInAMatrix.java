/*
Problem:
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not 
move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

Solution:
To get max length of increasing sequences:

1. Do DFS from every cell
2. Compare every 4 direction and skip cells that are out of boundary or smaller
3. Get matrix max from every cell's max
4. Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
5. The key is to cache the distance because it's highly possible to revisit a cell

Reference: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78308/15ms-Concise-Java-Solution
*/

public class LongestIncreasingPathInAMatrix {
    private int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int longestIncreasingPath(int[][] matrix) {
        int maxLen = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, cache));
            }
        }

        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] cache) {
        if (cache[r][c] != 0) {
            return cache[r][c];
        }

        int currMax = 1;
        for (int[] dir : directions) {
            int x = dir[0] + r, y = dir[1] + c;
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[r][c]) {
                continue;
            }
            int len = 1 + dfs(matrix, x, y, cache);
            currMax = Math.max(len, currMax);
        }
        cache[r][c] = currMax;
        return currMax;
    }
}