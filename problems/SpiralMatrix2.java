/*
Problem:
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Link: https://leetcode.com/problems/spiral-matrix-ii/submissions/

Solution:
Traverse the matrix with conditions
*/

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int num = 1;
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(int i = colStart; i <= colEnd; i++) {
                mat[rowStart][i] = num++;
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++) {
                mat[i][colEnd] = num++;
            }
            colEnd--;
            
            for(int i = colEnd; i >= colStart; i--) {
                mat[rowEnd][i] = num++;
            }
            rowEnd--;
            
            for(int i = rowEnd; i >= rowStart; i--) {
                mat[i][colStart] = num++;
            }
            colStart++;
        }    
        
        return mat;
    }   
}