/*
Problem:
You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks. 
The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks. You are also 
given an integer additionalRocks, the number of additional rocks you can place in any of the bags.

Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.

Link: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/

Solution:
Greedy
*/

import java.util.*;

public class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int idx = 0; idx < capacity.length; idx++) {
            pq.add(capacity[idx] - rocks[idx]);
        }

        int noOfBags = 0;
        while (!pq.isEmpty()) {
            int availableCapacity = pq.remove();
            if (availableCapacity == 0) {
                noOfBags++;
            } else if (availableCapacity <= additionalRocks) {
                noOfBags++;
                additionalRocks -= availableCapacity;
            }
        }

        return noOfBags;
    }
}
