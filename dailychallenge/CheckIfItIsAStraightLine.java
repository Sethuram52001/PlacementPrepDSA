/*
Problem:
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
Check if these points make a straight line in the XY plane.

Link: https://leetcode.com/problems/check-if-it-is-a-straight-line/description/

Solution: 
* Check if the slope values remains same across all pair of points, if not return false.
*/

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        int deltaX = coordinates[1][0] - coordinates[0][0], deltaY = coordinates[1][1] - coordinates[0][1];
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        for (int idx = 2; idx < coordinates.length; idx++) {
            int x2 = coordinates[idx][0], y2 = coordinates[idx][1];
            if (deltaY * (x2 - x1) != deltaX * (y2 - y1)) {
                return false;
            }
        }

        return true;
    }
}
