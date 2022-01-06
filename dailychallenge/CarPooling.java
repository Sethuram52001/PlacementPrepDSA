/*
Problem:
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has 
numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given 
as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

Link: https://leetcode.com/problems/car-pooling/

Solution:
We can use treemap to sort the entry and exit stops in sorted order (or a pq)
now we can put the values -trips[i] if someone drops off or +trips[i] if someone boards
at any point if the capacity goes negative we know that the problem statement can't be satisfied
*/

import java.util.*;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> entryExits = new TreeMap<>();
        for (int[] trip : trips) {
            entryExits.put(trip[1], entryExits.getOrDefault(trip[1], 0) + trip[0]);
            entryExits.put(trip[2], entryExits.getOrDefault(trip[2], 0) - trip[0]);
        }

        for (Integer cap : entryExits.values()) {
            capacity -= cap;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean carPoolingPQ(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        for(int[] trip : trips) {
            pq.add(new int[]{trip[1], trip[0]});
            pq.add(new int[]{trip[2], -trip[0]});
        }
        
        while(!pq.isEmpty()) {
            capacity -= pq.remove()[1];
            if(capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
