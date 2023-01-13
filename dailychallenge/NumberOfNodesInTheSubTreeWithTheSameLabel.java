/*
Problem:
You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered 
from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a 
label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).

The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi 
in the tree.

Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same 
label as node i.

A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.

Link: https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/

Solution: 
1. Construct a graph.
2. Traverse the graph, return the count of the present node level to its parent node.
*/

import java.util.*;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    int[] res;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            graph.computeIfAbsent(edge[0], value -> new ArrayList<Integer>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], value -> new ArrayList<Integer>()).add(edge[0]);
        }
        
        res = new int[n];
        countSubTrees(graph, 0, -1, labels);
        return res;
    }

    private int[] countSubTrees(Map<Integer, List<Integer>> graph, int source, int parent, String labels) {
        int[] count = new int[26];
        count[labels.charAt(source) - 'a'] = 1;
        if(!graph.containsKey(source)) {
            return count;
        }

        for(int child : graph.get(source)) {
            if(child == parent) {
                continue;
            }
            int[] childCounts = countSubTrees(graph, child, source, labels);
            for(int i = 0; i < 26; i++) {
                count[i] += childCounts[i];
            }
        }
        res[source] = count[labels.charAt(source) - 'a'];
        return count;
    }    
}
