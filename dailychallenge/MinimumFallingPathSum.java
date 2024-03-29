/* 
Problem:
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is
either directly below or diagonally left/right. Specifically, the next element from position (row, col) 
will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Link: https://leetcode.com/problems/minimum-falling-path-sum/description/

Solution:
Dynamic programming
*/

import java.util.*;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] += Math.min(matrix[r - 1][c], Math.min(matrix[r - 1][Math.max(0, c - 1)],
                        matrix[r - 1][Math.min(c + 1, matrix[0].length - 1)]));
            }
        }

        return Arrays.stream(matrix[matrix.length - 1]).min().getAsInt();
    }

    public int minFallingPathSum_ExtraSpace(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int c = 0; c < n; c++) {
            dp[0][c] = matrix[0][c];
        }

        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int prevSum = Integer.MAX_VALUE;
                if (c == 0) {
                    prevSum = Math.min(dp[r - 1][c], dp[r - 1][c + 1]);
                } else if (c == n - 1) {
                    prevSum = Math.min(dp[r - 1][c], dp[r - 1][c - 1]);
                } else {
                    prevSum = Math.min(dp[r - 1][c], Math.min(dp[r - 1][c - 1], dp[r - 1][c + 1]));
                }

                dp[r][c] = matrix[r][c] + prevSum;
            }
        }

        int minFallingSum = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            minFallingSum = Math.min(dp[m - 1][c], minFallingSum);
        }

        return minFallingSum;
    }
}
