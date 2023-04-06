/*
Problem:
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally 
(all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.

Link: https://leetcode.com/problems/number-of-closed-islands/description/

Solution:
* Exclude connected group of 0s on the corners because they are not closed island.
* Return number of connected component of 0s on the grid.
*/

public class NumberOfClosedIslands {
        public int closedIsland(int[][] grid) {
        for(int r = 0; r < grid.length; r++) {
            if(grid[r][0] == 0) {
                dfs(grid, r, 0);
            }
            if(grid[r][grid[0].length - 1] == 0) {
                dfs(grid, r, grid[0].length - 1);
            }
        }

        for(int c = 0; c < grid[0].length; c++) {
            if(grid[0][c] == 0) {
                dfs(grid, 0, c);
            }
            if(grid[grid.length - 1][c] == 0) {
                dfs(grid, grid.length - 1, c);
            }
        }

        int count = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 0) {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 0) {
            return;
        }

        grid[r][c] = 1;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
