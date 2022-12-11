/*
Problem:
There is an undirected graph consisting of n nodes numbered from 0 to n - 1. You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node.
You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

A star graph is a subgraph of the given graph having a center node containing 0 or more neighbors. In other words, it is a subset of edges of the given graph such that there exists 
a common node for all edges.

The star sum is the sum of the values of all the nodes present in the star graph.
Given an integer k, return the maximum star sum of a star graph containing at most k edges.

Link: https://leetcode.com/problems/maximum-star-sum-of-a-graph/description/

Solution:
Heap
*/

import java.util.*;

public class MaximumStarSumOfAGraph {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, PriorityQueue<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            graph.put(i, new PriorityQueue<>((a, b) -> b - a));
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(vals[edge[1]]);
            graph.get(edge[1]).add(vals[edge[0]]);
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < vals.length; i++) {
            int sum = vals[i];
            sum += Math.max(0, findSum(graph.get(i), k));
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    private int findSum(PriorityQueue<Integer> heap, int k) {
        int sum = 0;
        int k_ = k;
        while (!heap.isEmpty() && k > 0) {
            int val = heap.remove();
            if (val < 0) {
                break;
            }
            sum += val;
            k--;
        }

        return k == k_ ? Integer.MIN_VALUE : sum;
    }
}
