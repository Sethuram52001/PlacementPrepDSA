/*
Problem:
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

* Element at grid[i][j] moves to grid[i][j + 1].
* Element at grid[i][n - 1] moves to grid[i + 1][0].
* Element at grid[m - 1][n - 1] moves to grid[0][0].

Return the 2D grid after applying shift operation k times.

Link: https://leetcode.com/problems/shift-2d-grid/

Solution:
1. We can put all the elements in 1-D array and shift them.
2. Since shifting right will put the last k cells in grid on the first k cells, we start from 
   the kth cells from last, the index of which is m * n - k % (m * n).
*/

import java.util.*;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        List<List<Integer>> shiftedList = new ArrayList<>();
        k %= m * n;
        int start = m * n - k;

        for (int i = start; i < m * n + start; i++) {
            int j = i % (m * n);
            int r = j / m, c = j % m;

            if ((i - start) % m == 0) {
                shiftedList.add(new ArrayList<>());
            }

            shiftedList.get(shiftedList.size() - 1).add(grid[r][c]);
        }

        return shiftedList;
    }
    
    public List<List<Integer>> shiftGrid_ExtraSpace(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[] shifted = new int[n*m];
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                shifted[idx++] = grid[i][j];
            }
        }
        
        k %= n*m;
        
        reverse(shifted, 0, n*m - 1);
        reverse(shifted, 0, k - 1);
        reverse(shifted, k, n*m - 1);
        
        List<List<Integer>> shiftedGrid = new ArrayList<>();
        idx = 0;
        for(int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < m; j++) {
                row.add(shifted[idx++]);
            }
            shiftedGrid.add(new ArrayList<>(row));
        }
        
        return shiftedGrid;
    }
    
    private void reverse(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}