/*
Problem:
You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, 
or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given 
that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

Link: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

Solution:
BFS, we can keep track of the state in such fashion:
BFS on (x, y, nk, d) x, y is coordinate, nk is remain number of obstacles you can remove, and d is the remaining distance.
*/

import java.util.*;

public class ShortestPathInAGridWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0, k, 0 });

        int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        visited[0][0][k] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int r = curr[0], c = curr[1], currK = curr[2], dist = curr[3];

            if (r == n - 1 && c == m - 1) {
                return dist;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int nk = currK - grid[nr][nc];
                if (nk >= 0 && !visited[nr][nc][nk]) {
                    queue.add(new int[] { nr, nc, nk, dist + 1 });
                    visited[nr][nc][nk] = true;
                }
            }
        }

        return -1;
    }
}