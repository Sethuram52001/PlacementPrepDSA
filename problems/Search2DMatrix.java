/*
 Problem:
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 i. Integers in each row are sorted from left to right.
 ii. The first integer of each row is greater than the last integer of the previous row.

 Link: https://leetcode.com/problems/search-a-2d-matrix/

 Solution: 
 we can treat the whole matrix as a 1 d array and do binary search
*/

public class Search2DMatrix {
    private static boolean searchMatrix_(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, h = m * n - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (matrix[mid / m][mid % m] == target) {
                return true;
            } else if (matrix[mid / m][mid % m] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 16;
        System.out.println(searchMatrix_(matrix, target));
        System.out.println(searchMatrix(matrix, target));
    }
}
