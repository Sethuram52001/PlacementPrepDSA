/*
Problem:
You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer 
arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions 
of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their 
position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that 
can see it.

Return the number of unoccupied cells that are not guarded.

Link: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/

Solution:
Simulation - we'll mark the walls as -1 and guards as 2.
Now, we go to the cell where each guard is posted and do the 4 way traversal
while doing so, we stop the traversal if we either encounter a wall or another guard.

Note: We stop on seeing a guard as the cells will be covered by that guard over that direction,
this is to avoid TLE.
*/

public class CountUnguardedCellsInTheGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int[] guard : guards) {
            updateGrid(grid, m, n, guard[0], guard[1]);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private void updateGrid(int[][] grid, int m, int n, int r, int c) {
        // up
        grid[r][c] = 1;
        for (int i = r - 1; i >= 0; i--) {
            if (grid[i][c] == 2 || grid[i][c] == -1) {
                break;
            }
            grid[i][c] = 1;
        }

        // down
        for (int i = r + 1; i < m; i++) {
            if (grid[i][c] == 2 || grid[i][c] == -1) {
                break;
            }
            grid[i][c] = 1;
        }

        // left
        for (int i = c - 1; i >= 0; i--) {
            if (grid[r][i] == 2 || grid[r][i] == -1) {
                break;
            }
            grid[r][i] = 1;
        }

        //right
        for (int i = c + 1; i < n; i++) {
            if (grid[r][i] == 2 || grid[r][i] == -1) {
                break;
            }
            grid[r][i] = 1;
        }
    }
}