/*
Problem:
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), 
and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, 
left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Link: https://leetcode.com/problems/path-with-minimum-effort/

Solution:
Observation:
1. Consider the grid as a graph, where adjacent cells have an edge with cost of the difference between the cells.
2. If you are given threshold k, check if it is possible to go from (0, 0) to (n-1, m-1) using only edges of ≤ k cost.
3. Binary search the k value.

We pick the threshold value with binary search and use BFS to check the validity.
*/

import java.util.*;

public class PathWithMinimumEffort {
    private int[] directions = { 0, 1, 0, -1, 0 };

    public int minimumEffortPath(int[][] heights) {
        int low = 0, high = (int) Math.pow(10, 6);
        while (low < high) {
            int k = low + (high - low) / 2;
            if (isPath(heights, k)) {
                high = k;
            } else {
                low = k + 1;
            }
        }
        return low;
    }

    private boolean isPath(int[][] heights, int k) {
        int m = heights.length, n = heights[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0 });
        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0], y = curr[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int r = x + directions[i], c = y + directions[i + 1];
                if (0 <= r && r < m && 0 <= c && c < n && k >= Math.abs(heights[r][c] - heights[x][y])
                        && seen.add(r * n + c)) {
                    queue.offer(new int[] { r, c });
                }
            }
        }
        return false;
    }
}