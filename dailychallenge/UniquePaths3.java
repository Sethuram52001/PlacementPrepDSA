/*
Problem:
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending 
square, that walk over every non-obstacle square exactly once.

Link: https://leetcode.com/problems/unique-paths-iii/description/

Solution:
Backtracking - try all possible paths from the starting point to reach the ending point, while have
reached the end point check for the number for empty cells so that we can validate the path.
*/

public class UniquePaths3 {
    int uniquePaths, emptyCells;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] start = new int[2];
        uniquePaths = 0;
        emptyCells = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    start[0] = r;
                    start[1] = c;
                } else if (grid[r][c] == 0) {
                    emptyCells++;
                }
            }
        }

        backtrack(grid, m, n, start[0], start[1]);
        return uniquePaths;
    }

    private void backtrack(int[][] grid, int m, int n, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] < 0) {
            return;
        }
        if (grid[r][c] == 2) {
            if (emptyCells == 0)
                uniquePaths++;
            return;
        }

        emptyCells--;
        grid[r][c] = -2;
        backtrack(grid, m, n, r + 1, c);
        backtrack(grid, m, n, r - 1, c);
        backtrack(grid, m, n, r, c + 1);
        backtrack(grid, m, n, r, c - 1);
        grid[r][c] = 0;
        emptyCells++;
    }
}
