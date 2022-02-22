/*
Problem:
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Link: https://leetcode.com/problems/rotting-oranges/

Solution:
BFS
*/

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int countFresh = 0;
        
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    countFresh++;
                }
                else if(grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
            }
        }
        
        if(countFresh == 0) {
            return 0;
        }
        
        int[][] dirs = {{0,1},{1,0},{-1, 0},{0,-1}};
        int minutes = 0;
        
        while(!q.isEmpty()) {
            minutes += 1;
            for(int size = q.size(); size > 0; size--) {
                int[] currCell = q.poll();
                for(int[] dir : dirs) {
                    int x = currCell[0] + dir[0];
                    int y = currCell[1] + dir[1];
                    
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    
                    grid[x][y] = 2;
                    q.add(new int[]{x,y});
                    countFresh -= 1;
                }
            }
        }
        
        return countFresh == 0 ? minutes - 1: -1;
    }   
}