/*
Problem:
railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the 
same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of 
time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

You don't need to read input or print anything. Your task is to complete the function findPlatform() which takes the array arr[] 
(denoting the arrival times), array dep[] (denoting the departure times) and the size of the array as inputs and returns the 
minimum number of platforms required at the railway station such that no train waits.

Link: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

Solution:
Sort the both arrival and departure times now greedily find the overlapping intervals
*/

import java.util.*;

public class MinimumPlatformsRailways {
    public int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int minPlatforms = 1, noOfPlatforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                noOfPlatforms++;
                i++;
            } else {
                noOfPlatforms--;
                j++;
            }
            minPlatforms = Math.max(minPlatforms, noOfPlatforms);
        }
        return minPlatforms;
    }
}