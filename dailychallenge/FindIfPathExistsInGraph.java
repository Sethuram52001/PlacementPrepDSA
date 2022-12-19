/*
Problem:
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). 
The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a 
bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and 
no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, 
or false otherwise.

Link: https://leetcode.com/problems/find-if-path-exists-in-graph/description/

Solution:
1. Construct a graph using adjacency list and perform bfs.
2. Disjoint set - union find
*/

import java.util.*;

public class FindIfPathExistsInGraph {
    class UF {
        int[] root;
        int[] rank;

        UF(int n) {
            root = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while(x != root[x]) {
                x = root[x];
            }

            return x;
        }

        public void union(int u, int v) {
            int root_u = find(u);
            int root_v = find(v);

            if(root_u != root_v) {
                if(rank[root_u] > rank[root_v]) {
                    root[v] = root_u; 
                } else if(rank[root_u] < rank[root_v]) {
                    root[root_u] = root_v;
                } else {
                    root[root_v] = root_u;
                    rank[root_u] += 1;
                }
            }
        } 

        public boolean isConnected(int u, int v) {
            return find(u) == find(v);
        }
    }
    public boolean validPathUF(int n, int[][] edges, int source, int destination) {
        UF uf = new UF(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.isConnected(source, destination);
    }

    class Graph {
        List<Integer>[] adj;

        Graph(int n) {
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        Graph g = new Graph(n);
        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        for (List<Integer> i : g.adj) {
            System.out.println(i.toString());
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int currNode = queue.remove();
                for (int neighbour : g.adj[currNode]) {
                    if (neighbour == destination) {
                        return true;
                    } else if (!visited[neighbour]) {
                        queue.add(neighbour);
                    }
                }
                visited[currNode] = true;
            }
        }

        return false;
    }
}
