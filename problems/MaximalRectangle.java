/*
Problem:
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Link: https://leetcode.com/problems/maximal-rectangle/

Solution:
Prerequisite: largest rectangle histogram
We can create an elevation map using the matrix given, now we can apply the largest rectangle in histogram concept
in the elevation map.
*/

import java.util.*;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] elevationMatrix = new int[n][m];
        for (int i = 0; i < m; i++) {
            elevationMatrix[0][i] = matrix[0][i] == '0' ? 0 : 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                elevationMatrix[i][j] += matrix[i][j] == '0' ? 0 : elevationMatrix[i - 1][j] + 1;
            }
        }

        int maxArea = 0;
        for (int[] row : elevationMatrix) {
            maxArea = Math.max(maxArea, maxRectangle(row));
        }
        return maxArea;
    }

    private int maxRectangle(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = st.peek() + 1;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n - 1;
            }

            else {
                right[i] = st.peek() - 1;
            }
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * heights[i]);
        }
        return maxArea;
    }
}