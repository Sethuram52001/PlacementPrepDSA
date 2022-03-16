/*
Problem:
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/

Solution:
BFS
*/

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) {
            return -1;
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        
        int shortestPath = 1;
        while(!queue.isEmpty()) {
            for(int size = queue.size(); size > 0; size--) {
                int[] cell = queue.remove();
                int r = cell[0], c = cell[1];
                
                
                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 1) {
                    continue;
                }
                
                grid[r][c] = 1;
                
                if(r == grid.length - 1 && c == grid[0].length - 1) {
                    return shortestPath;
                }
                
                queue.add(new int[] {r - 1, c});
                queue.add(new int[] {r + 1, c});
                queue.add(new int[] {r, c - 1});
                queue.add(new int[] {r, c + 1});
                queue.add(new int[] {r - 1, c - 1});
                queue.add(new int[] {r + 1, c - 1});
                queue.add(new int[] {r - 1, c + 1});
                queue.add(new int[] {r + 1, c + 1});
            }
            shortestPath++;
        }
        
        return -1;
    }
}