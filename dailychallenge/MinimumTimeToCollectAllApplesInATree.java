/*
Problem:
Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. 
You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to 
collect all apples in the tree, starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge 
connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means 
that vertex i has an apple; otherwise, it does not have any apple.

Link: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

Solution:
Build a graph and perform DFS.
*/

import java.util.*;

public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, edges);
        Set<Integer> visited = new HashSet<>();
        return minTime(0, graph, hasApple, visited);
    }

    private int minTime(int node, Map<Integer, List<Integer>> graph, List<Boolean> hasApple, Set<Integer> visited) {
        visited.add(node);
        int res = 0;

        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (visited.contains(child)) {
                continue;
            }

            res += minTime(child, graph, hasApple, visited);
        }

        if ((res > 0 || hasApple.get(node)) && node != 0) {
            res += 2;
        }

        return res;
    }

    private void buildGraph(Map<Integer, List<Integer>> graph, int[][] edges) {
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
}
