/*
Problem:
You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays 
horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 10^9 + 7.

Link: https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

Solution:
Lets first think of horizontal cuts. Each horizontal_cuts[i] would create a piece with length 'L' and height, say, heights[i].
As there are H cuts, there will be (H+1) pieces of length LENGTH.

Now each vertical cut vertical_cuts[i] will cut each of the horizontal pieces that we got in the previous step.
We already know the height of each piece, now with each vertical cut, we will know the length of each piece as well.

Because we want the maximize the area, we must try to maximize the length and height of each piece.
*/
import java.util.*;

public class MaximumAreaPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int hlen = horizontalCuts.length, vlen = verticalCuts.length, mod = (int) Math.pow(10, 9) + 7;
        int maxh = Math.max(horizontalCuts[0], h - horizontalCuts[hlen - 1]);
        int maxv = Math.max(verticalCuts[0], w - verticalCuts[vlen - 1]);

        for (int i = 0; i < hlen - 1; i++) {
            maxh = Math.max(horizontalCuts[i + 1] - horizontalCuts[i], maxh);
        }

        for (int i = 0; i < vlen - 1; i++) {
            maxv = Math.max(verticalCuts[i + 1] - verticalCuts[i], maxv);
        }

        return (int) ((long) maxv * maxh % mod);
    }
}