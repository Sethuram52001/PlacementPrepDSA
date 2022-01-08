/*
Problem:
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

Link: https://leetcode.com/problems/diagonal-traverse/

Solution:
Observer the pattern of walk and frame the algorithm
*/

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] diagonalTraversal = new int[m * n];
        int r = 0, c = 0, d = 1;
        for (int i = 0; i < m * n; i++) {
            diagonalTraversal[i] = mat[r][c];
            r -= d;
            c += d;

            if (r >= m) {
                r = m - 1;
                c = c + 2;
                d = -d;
            }

            if (c >= n) {
                c = n - 1;
                r = r + 2;
                d = -d;
            }

            if (r < 0) {
                r = 0;
                d = -d;
            }

            if (c < 0) {
                c = 0;
                d = -d;
            }
        }

        return diagonalTraversal;
    }
}
