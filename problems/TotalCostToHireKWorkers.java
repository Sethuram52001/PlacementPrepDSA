/*
Problem:
You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

You will run k sessions and hire exactly one worker in each session.
In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
A worker can only be chosen once.
Return the total cost to hire exactly k workers.

Link: https://leetcode.com/problems/total-cost-to-hire-k-workers/description/

Solution:
Maintain two min heaps on both sides of the array.
Now, move the pointers according to the given conditions in the
question.
*/

import java.util.*;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        long cost = 0;
        int left = 0, right = costs.length - 1;

        while (k > 0) {
            while (leftHeap.size() < candidates && left < right) {
                leftHeap.add(costs[left]);
                left++;
            }

            while (rightHeap.size() < candidates && right >= left) {
                rightHeap.add(costs[right]);
                right--;
            }

            int a = leftHeap.size() > 0 ? leftHeap.peek() : Integer.MAX_VALUE;
            int b = rightHeap.size() > 0 ? rightHeap.peek() : Integer.MAX_VALUE;

            if (a <= b) {
                cost += a;
                leftHeap.remove();
            } else {
                cost += b;
                rightHeap.remove();
            }
            k--;
        }

        return cost;
    }
}
