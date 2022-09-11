/*
Problem:
You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers
numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.

Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.

Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 10^9 + 7.

Link: https://leetcode.com/problems/maximum-performance-of-a-team/

Solution:
Keep track of the engineers by their efficiency in decreasing order.
Starting from one engineer, to build a team, it suffices to bring K-1 more engineers who have 
higher efficiencies as well as high speeds.
*/

import java.util.*;

public class MaximumPerformanceOfATeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[] { speed[i], efficiency[i] };
        }

        Arrays.sort(engineers, (e1, e2) -> e2[1] - e1[1]);
        PriorityQueue<Integer> speeds = new PriorityQueue<>();

        long maxPerformance = 0, sumOfSpeed = 0;
        for (int[] engineer : engineers) {
            sumOfSpeed += engineer[0];
            speeds.offer(engineer[0]);
            if (speeds.size() > k) {
                sumOfSpeed -= speeds.remove();
            }

            maxPerformance = Math.max(maxPerformance, sumOfSpeed * engineer[1]);
        }

        return (int) (maxPerformance % (long) (1e9 + 7));
    }
}
