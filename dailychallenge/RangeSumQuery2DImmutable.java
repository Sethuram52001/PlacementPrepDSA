/*
Problem:
Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined 
by its upper left corner (row1, col1) and lower right corner (row2, col2). 

Link: https://leetcode.com/problems/range-sum-query-2d-immutable/

Solution:
We could pre-compute a cumulative region sum with respect to the origin at (0, 0).
Sum of the region ABCD:
Sum(ABCD) = Sum(OD) − Sum(OB) − Sum(OC) + Sum(OA)
*/
public class RangeSumQuery2DImmutable {
    private int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}