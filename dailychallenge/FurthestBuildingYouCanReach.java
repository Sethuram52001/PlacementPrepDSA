/*
Problem:
You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.

You start your journey from building 0 and move to the next building by possibly using bricks or ladders.

While moving from building i to building i+1 (0-indexed),
* If the current building's height is greater than or equal to the next building's height, you do not need a 
ladder or bricks.
* If the current building's height is less than the next building's height, you can either use one ladder or 
(h[i+1] - h[i]) bricks.

Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.

Link: https://leetcode.com/problems/furthest-building-you-can-reach/

Solution:
Greed approach:
You'll have to do a set of jumps, and choose for each one whether to do it using a ladder or bricks. It's always optimal to 
use ladders in the largest jumps. So, what we can do is that we can use min heap to store the height difference between 2 buildings
and when it exceeds more than the count of ladders(as we're intending to use ladders for the largest diff jumps), we pop
last the difference and use bricks to jump that gap.
*/ 

import java.util.*;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for (; idx < heights.length - 1; idx++) {
            int heightDiff = heights[idx + 1] - heights[idx];
            if (heightDiff <= 0) {
                continue;
            }
            pq.add(heightDiff);
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }
            if (bricks < 0) {
                return idx;
            }
        }

        return heights.length - 1;
    }
}