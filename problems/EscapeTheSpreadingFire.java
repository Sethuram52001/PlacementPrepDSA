/*
Problem:
You are given a 0-indexed 2D integer array grid of size m x n which represents a field. Each cell has one of three values:

0 represents grass,
1 represents fire,
2 represents a wall that you and fire cannot pass through.
You are situated in the top-left cell, (0, 0), and you want to travel to the safehouse at the bottom-right cell, (m - 1, n - 1). 
Every minute, you may move to an adjacent grass cell. After your move, every fire cell will spread to all adjacent cells that are not walls.

Return the maximum number of minutes that you can stay in your initial position before moving while still safely reaching the safehouse. 
If this is impossible, return -1. If you can always reach the safehouse regardless of the minutes stayed, return 109.

Note that even if the fire spreads to the safehouse immediately after you have reached it, it will be counted as safely reaching the safehouse.

A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).

Link: https://leetcode.com/problems/escape-the-spreading-fire/

Solution:
case 1: fire and person meets on safehouse --> ok
case 2: fire and person meets on any cell  --> fail
case 3: fire reach house before person     --> fail

We can use binary search to select the minutes and check for every range whether
it is safe or not.

For checking safety we can use BFS.

Reference: https://leetcode.com/problems/escape-the-spreading-fire/discuss/1994962/Java-Binary-Search-%2B-BFS-with-Explanation-or-Beats-100
*/

import java.util.*;

public class EscapeTheSpreadingFire {
    private int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maximumMinutes(int[][] grid) {
        List<int[]> fireCells = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fireCells.add(new int[] { i, j });
                }
            }
        }

        int low = -1, high = grid.length * grid[0].length;
        while (low < high) {
            int mid = low + (high - low) / 2 + 1;
            if (canReach(grid, mid, fireCells))
                low = mid;
            else
                high = mid - 1;
        }
        return low == grid.length * grid[0].length ? (int) 1e9 : low;
    }

    private boolean canReach(int[][] orgGrid, int minutes, List<int[]> fireCells) {
        int[][] grid = cloneGrid(orgGrid);

        Deque<int[]> queue = new ArrayDeque<>();
        queue.addAll(fireCells);
        while (!queue.isEmpty() && minutes-- > 0) {
            if (spread(queue, grid)) {
                return false;
            }
        }

        Deque<int[]> safePath = new ArrayDeque<>();
        safePath.add(new int[] { 0, 0 });
        while (!safePath.isEmpty()) {
            boolean onFire = spread(queue, grid);
            if (spread(safePath, grid)) {
                return true;
            }
            if (onFire) {
                return false;
            }
        }
        return false;
    }

    // return true if it reaches seafehouse
    private boolean spread(Deque<int[]> queue, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int size = queue.size();

        while (size-- > 0) {
            int[] cell = queue.remove();
            for (int[] d : directions) {
                int x = cell[0] + d[0], y = cell[1] + d[1];
                if (x == m - 1 && y == n - 1)
                    return true;
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                    grid[x][y] = -1;
                    queue.add(new int[] { x, y });
                }
            }
        }
        return false;
    }

    private int[][] cloneGrid(int[][] grid) {
        int[][] clonedGrid = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            clonedGrid[i] = grid[i].clone();
        }
        return clonedGrid;
    }
}