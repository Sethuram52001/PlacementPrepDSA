package problems;

import java.util.*;

/*
Problem:
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Link: https://leetcode.com/problems/merge-intervals/

Solution:
The idea is sort the given array according to starting time, and then compare the intervals to be merged.
*/

public class MergeIntervals {
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }
    
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] mergedIntervals = merge(intervals);
        for(int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
