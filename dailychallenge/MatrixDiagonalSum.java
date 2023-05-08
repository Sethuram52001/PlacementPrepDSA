/*
Problem:
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the 
secondary diagonal that are not part of the primary diagonal.

Link: https://leetcode.com/problems/matrix-diagonal-sum/description/

Solution:
Sum up left diagonal elements.
If it is square matrix skip r == c element while summing up right diagonal elements.
*/

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int r = 0, c = 0; r < mat.length && c < mat[0].length; r++, c++) {
            sum += mat[r][c];
        }

        for(int r = 0, c = mat[0].length - 1; r < mat.length && c >= 0; r++, c--) {
            if(r == c) {
                continue;
            }
            sum += mat[r][c];
        }

        return sum;
    }    
}
