/*
Problem:
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking 
off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Link: https://leetcode.com/problems/number-of-enclaves/description/

Solution:
* Do dfs on all the lands cells on the boundary and turn to 0's.
* Now count the remaining number of land cells.
*/

public class NumberOfEnclaves {
        public int numEnclaves(int[][] grid) {
        for(int r = 0; r < grid.length; r++) {
            if(grid[r][0] == 1) {
                dfs(grid, r, 0);
            }
            if(grid[r][grid[0].length - 1] == 1) {
                dfs(grid, r, grid[0].length - 1);
            }
        }

        for(int c = 0; c < grid[0].length; c++) {
            if(grid[0][c] == 1) {
                dfs(grid, 0, c);
            }
            if(grid[grid.length - 1][c] == 1) {
                dfs(grid, grid.length - 1,c);
            }
        }

        int numOfEnclaves = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    numOfEnclaves++;
                }
            }
        }

        return numOfEnclaves;
    }

    private void dfs(int[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
