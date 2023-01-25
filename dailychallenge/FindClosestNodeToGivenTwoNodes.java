/*
Problem:
You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge 
from node i to node edges[i]. If there is no outgoing edge from i, then edges[i] == -1.
You are also given two integers node1 and node2.

Return the index of the node that can be reached from both node1 and node2, such that the maximum between the distance 
from node1 to that node, and from node2 to that node is minimized. If there are multiple answers, return the node with 
the smallest index, and if no possible answer exists, return -1.

Note that edges may contain cycles.

Link: https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/

Solution: 
Use BFS to find the shortest distance from both node1 and node2 to all nodes in the graph. 
Then iterate over all nodes, and find the node with the minimum max distance.
*/

import java.util.*;

public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] node1Distance = new int[n];
        int[] node2Distance = new int[n];
        Arrays.fill(node1Distance, Integer.MAX_VALUE);
        Arrays.fill(node2Distance, Integer.MAX_VALUE);

        bfs(node1, node1Distance, edges, n);
        bfs(node2, node2Distance, edges, n);

        int res = Integer.MAX_VALUE, node = -1;
        for (int i = 0; i < n; i++) {
            if (node1Distance[i] == Integer.MAX_VALUE || node2Distance[i] == Integer.MAX_VALUE)
                continue;
            if (res > Math.max(node1Distance[i], node2Distance[i])) {
                node = i;
                res = Math.max(node1Distance[i], node2Distance[i]);
            }
        }

        return node;
    }

    private void bfs(int source, int[] dist, int[] edge, int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        dist[source] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (edge[curr] != -1 && dist[edge[curr]] == Integer.MAX_VALUE) {
                queue.add(edge[curr]);
                dist[edge[curr]] = dist[curr] + 1;
            }
        }
    }
}
