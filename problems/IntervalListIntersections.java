/*
Problem:
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. 
Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. 
For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Link: https://leetcode.com/problems/interval-list-intersections/

Solution: 
2 pointers
*/

import java.util.*;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        int curr1 = 0, curr2 = 0, len1 = firstList.length, len2 = secondList.length;
        
        while(curr1 < len1 && curr2 < len2) {
            int start = Math.max(firstList[curr1][0], secondList[curr2][0]);
            int end = Math.min(firstList[curr1][1], secondList[curr2][1]);
            
            if(start <= end) {
                intersections.add(new int[]{start, end});
            }
            
            if(firstList[curr1][1] < secondList[curr2][1]) {
                curr1++;
            }
            else {
                curr2++;
            }
        }
        
        return intersections.toArray(new int[intersections.size()][]);
    }
}
