/*
Problem:
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). 
You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column 
of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot 
step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell 
that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Link: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/

Solution:
BFS
*/

import java.util.*;

public class NearestExitFromEntranceInMaze {
    private static final int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        int distance = 1;

        queue.add(entrance);

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int[] curr = queue.remove();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (insideMaze(r, c, m, n) && maze[r][c] == '.' && !visited[r][c]) {
                        if (!(r == entrance[0] && c == entrance[1]) && onBorder(r, c, m, n)) {
                            return distance;
                        }
                        visited[r][c] = true;
                        queue.offer(new int[] { r, c });
                    }
                }
            }
            distance++;
        }

        return -1;
    }

    private boolean insideMaze(int r, int c, int m, int n) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    private boolean onBorder(int r, int c, int m, int n) {
        return r == 0 || r == m - 1 || c == 0 || c == n - 1;
    }
}
