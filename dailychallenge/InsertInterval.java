/*
Problem:
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the 
start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given 
an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals 
still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Link: https://leetcode.com/problems/insert-interval/description/

Solution: 
1. Add the interval, in the ascending order position.
2. Merge the overlapping intervals.
*/

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>(Arrays.asList(intervals));
        boolean isInserted = false;

        for (int idx = 0; idx < intervals.length; idx++) {
            if (newInterval[0] < intervals[idx][0]) {
                newIntervals.add(idx, newInterval);
                isInserted = true;
                break;
            }
        }

        if (!isInserted) {
            newIntervals.add(newInterval);
        }

        return mergeOverLappingIntervals(newIntervals);
    }

    private int[][] mergeOverLappingIntervals(List<int[]> intervals) {
        List<int[]> res = new ArrayList<>();
        for (int idx = 0; idx < intervals.size(); idx++) {
            int[] currInterval = intervals.get(idx);
            while (idx < intervals.size() && overlap(currInterval, intervals.get(idx))) {
                currInterval = merge(currInterval, intervals.get(idx));
                idx++;
            }

            idx--;
            res.add(currInterval);
        }

        return res.toArray(new int[res.size()][2]);
    }

    private boolean overlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    private int[] merge(int[] a, int[] b) {
        return new int[] { Math.min(a[0], b[0]), Math.max(a[1], b[1]) };
    }
}
