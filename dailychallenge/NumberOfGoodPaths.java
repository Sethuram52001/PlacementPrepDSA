/*
Problem:
There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and 
exactly n - 1 edges.

You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node. You are also 
given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes 
ai and bi.

A good path is a simple path that satisfies the following conditions:

The starting node and the ending node have the same value.
All nodes between the starting node and the ending node have values less than or equal to the starting node 
(i.e. the starting node's value should be the maximum value along the path).
Return the number of distinct good paths.

Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to be the same as 
1 -> 0. A single node is also considered as a valid path.

Link: https://leetcode.com/problems/number-of-good-paths/description/

Reference:
1. https://leetcode.com/problems/number-of-good-paths/solutions/2892908/number-of-good-paths/?orderBy=most_votes
2. https://leetcode.com/problems/number-of-good-paths/solutions/2621772/c-java-diagram-union-find/?orderBy=most_votes
*/

import java.util.*;

public class NumberOfGoodPaths {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<Integer>[] graph = new ArrayList[n];
        UnionFind uf = new UnionFind(n);
        int res = 0;
        
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
            
            if(!treemap.containsKey(vals[i])) treemap.put(vals[i], new ArrayList<>());
            treemap.get(vals[i]).add(i);
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(vals[u] < vals[v]){
                graph[v].add(u);
            }else{
                graph[u].add(v);
            }
        }
        
        for(int key : treemap.keySet()){ // Set<Integer> keys
            for(int point : treemap.get(key)){ // ArrayList<Integer> points
                for(int next : graph[point]){ // the value of next point id less or equal than point
                    uf.union(point, next);
                }
            }
            
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int point : treemap.get(key)){
                map.put(uf.find(point), map.getOrDefault(uf.find(point), 0) + 1);
            }
            
            for(int k : map.keySet()){
                int size = map.get(k);
                res += size*(size + 1) / 2; // size * (size - 1)/2 + size = size*(size + 1) / 2
            }
        }
        
        return res;
        
        
        
    }
    
    private class UnionFind{
        private int[] roots;
        private int[] ranks;
        
        private UnionFind(int n){
            this.roots = new int[n];
            this.ranks = new int[n];
            
            for(int i = 0; i < n; i++){
                roots[i] = i;
                ranks[i] = 1;
            }
        }
        
        private int find(int x){
            if(x != roots[x]) roots[x] = find(roots[x]);
            
            return roots[x];
        }
        
        private void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            
            if(ranks[rootP] < ranks[rootQ]){
                roots[rootP] = rootQ;
                ranks[rootP]++;
            }else{
                roots[rootQ] = rootP;
                ranks[rootQ]++;
            }
        }
    }
}
