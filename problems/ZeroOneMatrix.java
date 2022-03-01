/*
Problem:
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Link: https://leetcode.com/problems/01-matrix/

Solution:
i. BFS
ii. DP: 
* In this problem, a cell has at most 4 neighbors that are left, top, right, bottom. If we use dynamic programming to compute the distance of the current cell 
based on 4 neighbors simultaneously, it's impossible because we are not sure if distance of neighboring cells is already computed or not.

* That's why, we need to compute the distance one by one:
    * Firstly, for a cell, we restrict it to only 2 directions which are left and top. Then we iterate cells from top to bottom, and from left to right, 
      we calculate the distance of a cell based on its left and top neighbors.
    * Secondly, for a cell, we restrict it only have 2 directions which are right and bottom. Then we iterate cells from bottom to top, and from right to 
      left, we update the distance of a cell based on its right and bottom neighbors.
*/

public class ZeroOneMatrix {    
    public int[][] updateMatrixDP(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int INF = (int)Math.pow(10, 5);
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(mat[r][c] == 0) {
                    continue;
                }
                
                int top = INF, left = INF;
                if(r - 1 >= 0) {
                    top = mat[r - 1][c];
                }
                
                if(c - 1 >= 0) {
                    left = mat[r][c - 1];
                }
                
                mat[r][c] = Math.min(top, left) + 1;
            }
        }
        
        for(int r = n - 1; r >= 0; r--) {
            for(int c = m - 1; c >= 0; c--) {
                if(mat[r][c] == 0) {
                    continue;
                }
                
                int bottom = INF, right = INF;
                
                if(r + 1 < n) {
                    right = mat[r + 1][c];
                }
                
                if(c + 1 < m) {
                    bottom = mat[r][c + 1];
                }
                
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
            }
        }
        
        return mat;
    }

    public int[][] updateMatrixBFS(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
                else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] curr = queue.remove();
            for(int i = 0; i < 4; i++) {
                int nr = curr[0] + dirs[i][0];
                int nc = curr[1] + dirs[i][1];
                
                if(nr < 0 || nc < 0 || nr >= mat.length || nc >= mat[0].length) {
                    continue;
                }
                
                if(mat[nr][nc] == 0) {
                    continue;
                }
                
                if(mat[nr][nc] > 1 + mat[curr[0]][curr[1]]) {
                    mat[nr][nc] = 1 + mat[curr[0]][curr[1]];
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        return mat;
    }
}