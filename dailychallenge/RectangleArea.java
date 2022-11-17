/*
Problem:
Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

Link: https://leetcode.com/problems/rectangle-area/description/

Solution:
area1 + area2 - overlapping area
*/

public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = computeArea(ax1, ay1, ax2, ay2);
        int area2 = computeArea(bx1, by1, bx2, by2);
        int commonArea = computeCommonArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);

        return area1 + area2 - commonArea;
    }

    private int computeArea(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (y2 - y1);
    }

    private int computeCommonArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x1 = Math.max(ax1, bx1);
        int x2 = Math.min(ax2, bx2);
        int y1 = Math.max(ay1, by1);
        int y2 = Math.min(ay2, by2);

        if (x2 - x1 > 0 && y2 - y1 > 0) {
            return computeArea(x1, y1, x2, y2);
        }
        return 0;
    }
}
