/*
Problem:
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network 
where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers 
directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

Link: https://leetcode.com/problems/critical-connections-in-a-network/

Solution:
Critical edges are the one which aren't in a cycle, so the idea is to find the cycles in the graph 
and eliminate them. For detection of cycle we can use DFS.

Reference: https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/DFS-detailed-explanation-O(orEor)-solution
*/

import java.util.*;

public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }

        Set<List<Integer>> connectionsSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, connectionsSet);
        return new ArrayList<>(connectionsSet);
    }

    private int dfs(List<Integer>[] graph, int node, int depth, int[] rank, Set<List<Integer>> connectionsSet) {
        // already visited, return its rank
        if (rank[node] >= 0) {
            return rank[node];
        }

        rank[node] = depth;
        int minDepthFound = depth;
        for (Integer neighbour : graph[node]) {
            // ignore parent
            if (rank[neighbour] == depth - 1) {
                continue;
            }
            int minDepth = dfs(graph, neighbour, depth + 1, rank, connectionsSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            if (minDepth <= depth) {
                // is present in a cycle, so remove the non-critical edge
                connectionsSet.remove(Arrays.asList(node, neighbour));
                connectionsSet.remove(Arrays.asList(neighbour, node));
            }
        }

        return minDepthFound;
    }
}