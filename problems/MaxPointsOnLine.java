/*
Problem:
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, 
return the maximum number of points that lie on the same straight line.

Link: https://leetcode.com/problems/max-points-on-a-line/

Solution:
If a line which passes through common points means, the line between any two points on that line
must have the same slope, so we can just find the number of points which have common slope by choosing a point
and connecting it to the rest.
*/

import java.util.*;

public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        HashMap<Double, Integer> slopeFreq = new HashMap<>();
        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                double slope = (x2 - x1) == 0 ? Integer.MAX_VALUE : (double) (y2 - y1) / (x2 - x1);
                slopeFreq.put(slope, slopeFreq.getOrDefault(slope, 0) + 1);
                maxPoints = Math.max(maxPoints, slopeFreq.get(slope));
            }
            slopeFreq.clear();
        }

        return maxPoints + 1;
    }
}