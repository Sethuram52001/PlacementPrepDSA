/*
Problem:
You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge 
from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

Link: https://leetcode.com/problems/longest-cycle-in-a-graph/description/

Solution: 
for every node during our local dfs traversal, we can store the distance from our starting node.
if we find a node that we have aleady visited (we use a map x to check that), there exists a cycle
the length of the cycle would be dist-x.get(idx)

now we don't need to check if a cycle exists for any of the nodes that we visited during our traversal.
why? because since there only exists one directed edge from each node, we're sure that we've already visited any cycle from that node (if it exists).
so we can just ignore that node if we ever see it again.

Reference:
1. https://leetcode.com/problems/longest-cycle-in-a-graph/solutions/2357650/java-dfs-hashmap/?orderBy=most_votes&languageTags=java
*/

import java.util.*;

public class LongestCycleInAGraph {
    public int longestCycle(int[] edges) {
        int vertices = edges.length, longestCycle = -1;
        boolean[] visited = new boolean[vertices];

        for(int vertex = 0; vertex < vertices; vertex++) {
            if(visited[vertex]) {
                continue;
            }
            Map<Integer, Integer> localMap = new HashMap<>();
            for(int v = vertex, distance = 0; v != -1; v = edges[v]) {
                if(localMap.containsKey(v)) {
                    longestCycle = Math.max(longestCycle, distance - localMap.get(v));
                    break;
                }

                if(visited[v]) {
                    break;
                }

                visited[v] = true;
                localMap.put(v, distance++);
            }
        }

        return longestCycle;
    }
}
