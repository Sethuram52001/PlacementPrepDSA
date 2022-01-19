/*
Problem:
You are given N activities with their start time Start[] and finish time Finish[]. You need to tell the maximum number of activities a single person can perform.

Link: https://www.codingninjas.com/codestudio/problems/1062712?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

Solution:
Same as n meetings in one room greedily sort the activities according to their ending times.
Now find the non-overlapping activities.
*/


import java.util.*;

public class ActivitySelection {

    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        List<int[]> activities = new ArrayList<>();
        int n = start.size();
        for (int i = 0; i < n; i++) {
            activities.add(new int[] { start.get(i), end.get(i) });
        }

        activities.sort((a, b) -> a[1] - b[1]);
        /*for(int[] a : activities) {
            System.out.println(a[0] + "  " + a[1]);
        }*/
        int nonOverlapping = 1;
        int limit = activities.get(0)[1];
        for (int i = 1; i < n; i++) {
            if (activities.get(i)[0] >= limit) {
                limit = activities.get(i)[1];
                nonOverlapping++;
            }
        }

        return nonOverlapping;
    }
}