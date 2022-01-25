/*
Problem:
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N – 1, N – 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are ‘U'(up), ‘D'(down), ‘L’ (left), ‘R’ (right). Value 0 at a cell in the matrix represents that it is blocked and the rat cannot move to it while value 1 at a cell in the matrix represents that rat can travel through it.
Note: In a path, no cell can be visited more than one time.

Link: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1# 

Solution:
backtracking
*/

import java.util.*;

public class RatInMaze {
    private static void solve(int[][] m, int n, boolean[][] visited, int r, int c, String path, List<String> paths) {
        if (r == n - 1 && c == n - 1) {
            paths.add(path);
            return;
        }

        // left
        if (c - 1 >= 0 && !visited[r][c - 1] && m[r][c - 1] == 1) {
            visited[r][c] = true;
            solve(m, n, visited, r, c - 1, path + 'L', paths);
            visited[r][c] = false;
        }

        // right
        if (c + 1 < n && !visited[r][c + 1] && m[r][c + 1] == 1) {
            visited[r][c] = true;
            solve(m, n, visited, r, c + 1, path + 'R', paths);
            visited[r][c] = false;
        }

        // up
        if (r - 1 >= 0 && !visited[r - 1][c] && m[r - 1][c] == 1) {
            visited[r][c] = true;
            solve(m, n, visited, r - 1, c, path + 'U', paths);
            visited[r][c] = false;
        }

        // down
        if (r + 1 < n && !visited[r + 1][c] && m[r + 1][c] == 1) {
            visited[r][c] = true;
            solve(m, n, visited, r + 1, c, path + 'D', paths);
            visited[r][c] = false;
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> paths = new ArrayList<>();
        if (m[0][0] == 1) {
            solve(m, n, visited, 0, 0, "", paths);
        }
        return paths;
    }
}