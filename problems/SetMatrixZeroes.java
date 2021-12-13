import java.util.Arrays;

/*
Question:
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
You must do it in place.

Link: https://leetcode.com/problems/set-matrix-zeroes/

Solution:
We can have the 1st col and row as the flag variables 
We need one more variable isCol0 to check whether a 0 is already present in the 1st col
*/

public class SetMatrixZeroes {
    private static void setZeroes(int[][] matrix) {
        boolean isColZero = false;
        int rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0)
                isColZero = true;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (isColZero)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
