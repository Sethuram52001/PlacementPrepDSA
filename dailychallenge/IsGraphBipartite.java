/*
Problem:
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. 
You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. 
More formally, for each v in graph[u], there is an undirected edge between node u and node v. 

The graph has the following properties:
* There are no self-edges (graph[u] does not contain u).
* There are no parallel edges (graph[u] does not contain duplicate values).
* If v is in graph[u], then u is in graph[v] (the graph is undirected).
* The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.

A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the 
graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

Link: https://leetcode.com/problems/is-graph-bipartite/

Solution:
A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge 
(u, v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either
u belongs to U and v to V, or u belongs to V and v to U. We can also say that there is no edge that connects vertices 
of same set.

2 coloring - The two sets U and V may be thought of as a coloring of the graph with two 
colors: if one colors all nodes in U blue, and all nodes in V green, each edge has endpoints of 
differing colors, as is required in the graph coloring problem.
*/

import java.util.*;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) {
                continue;
            }

            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            color[i] = 1;

            while (!queue.isEmpty()) {
                int node = queue.remove();
                for (int neighbour : graph[node]) {
                    if (color[neighbour] == 0) {
                        color[neighbour] = -color[node];
                        queue.add(neighbour);
                    } else if (color[neighbour] == color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}