/*
Problem:
A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and 
going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from 
mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

Link: https://leetcode.com/problems/sort-the-matrix-diagonally/

Solution:
Don't need to complicate things, we can just sort each diagonals separately.
But how to do it?
Simple every element mat[i][j] in a diagonal has the same value i - j, because every position in a diagonal just differs by (i + 1, j + 1)
*/
import java.util.*;

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int rows = mat.length, cols = mat[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                map.putIfAbsent(r - c, new PriorityQueue<>());
                map.get(r - c).add(mat[r][c]);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                mat[r][c] = map.get(r - c).poll();
            }
        }

        return mat;
    }
}