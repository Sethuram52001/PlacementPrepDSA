/*
Problem:
Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another 
interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.

Link: https://leetcode.com/problems/remove-covered-intervals/

Solution:
* Sort by the left bound, and when left bounds are equal, sort right bounds by reverse order; Therefore, no interval can cover previous ones;
* Loop through the intervals, whenever current right most bound < next interval's right bound, it means current interval can NOT cover next 
interval, update right most bound and increase counter by 1.
*/

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0, rightEnd = -1;
        for(int[] interval : intervals) {
            if(interval[1] > rightEnd) {
                rightEnd = interval[1];
                count++;
            }
        }
        return count;
    }   
}