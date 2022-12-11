/*
Problem:
You are given an m x n matrix grid consisting of positive integers.

Perform the following operation until grid becomes empty:

Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
Add the maximum of deleted elements to the answer.
Note that the number of columns decreases by one after each operation.

Return the answer after performing the operations described above.

Link: https://leetcode.com/problems/delete-greatest-value-in-each-row/

Solution:
Sort the rows
*/

import java.util.*;

public class DeleteGreatestValueInEachRow {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += findMax(grid, m, i);
        }

        return res;
    }

    private int findMax(int[][] grid, int m, int c) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, grid[i][c]);
        }

        return max;
    }
}
