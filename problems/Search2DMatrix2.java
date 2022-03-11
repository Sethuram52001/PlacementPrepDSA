/*
Problem:
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
* Integers in each row are sorted in ascending from left to right.
* Integers in each column are sorted in ascending from top to bottom.

Link: https://leetcode.com/problems/search-a-2d-matrix-ii/

Solution:
We can start the search process from top right corner:
if(mat[r][c] == target):
    return true

else if(mat[r][c] < target):
    r++

else
    c--
*/

public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            }
            else if(matrix[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }
}