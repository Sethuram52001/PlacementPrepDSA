/*
Problem:
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove 
to make the rest of the intervals non-overlapping.

Link: https://leetcode.com/problems/non-overlapping-intervals/

Solution:
Greedy soln - sort the intervals according to ending points, now count the overlapping sub-intervals, return total-intervals - overlapping-intervals
*/

import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int nonOverlappingIntervals = 1;
        int currPos = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++) {
            if(currPos <= intervals[i][0]) {
                nonOverlappingIntervals++;
                currPos = intervals[i][1];
            }
        }
        
        return intervals.length - nonOverlappingIntervals;
    }
}
