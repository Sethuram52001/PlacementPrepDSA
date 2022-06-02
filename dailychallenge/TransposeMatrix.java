/*
Problem:
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, 
switching the matrix's row and column indices.

Link: https://leetcode.com/problems/transpose-matrix/

Solution:
transpose_mat[j][i] = mat[i][j]
*/

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] transposeMatrix = new int[n][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }   
}