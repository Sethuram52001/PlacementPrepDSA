/*
Problem:
You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.
Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).
We view the projection of these cubes onto the xy, yz, and zx planes.
A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane. We are viewing the 
"shadow" when looking at the cubes from the top, the front, and the side.
Return the total area of all three projections.

Link: https://leetcode.com/problems/projection-area-of-3d-shapes/

Solution:
xy plane: From the top, the shadow made by the shape will be 1 square for each non-zero value.
yz plane: From the side, the shadow made by the shape will be the largest value for each row in the grid.
xz plane: From the front, the shadow made by the shape will be the largest value for each column in the grid.
*/

public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int xyPlane = 0, yzPlane = 0, xzPlane = 0;
        for (int r = 0; r < grid.length; r++) {
            int maxX = 0, maxY = 0;
            for (int c = 0; c < grid.length; c++) {
                if (grid[r][c] > 0) {
                    xyPlane++;
                }
                maxX = Math.max(maxX, grid[c][r]);
                maxY = Math.max(maxY, grid[r][c]);
            }
            yzPlane += maxX;
            xzPlane += maxY;
        }

        return xyPlane + yzPlane + xzPlane;
    }
}
