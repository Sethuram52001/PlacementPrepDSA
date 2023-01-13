/*
Problem:
You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes 
numbered from 0 to n - 1. The tree is represented by a 0-indexed array parent of size n, where parent[i] is the 
parent of node i. Since node 0 is the root, parent[0] == -1.

You are also given a string s of length n, where s[i] is the character assigned to node i.

Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same 
character assigned to them.

Link: https://leetcode.com/problems/longest-path-with-different-adjacent-characters/description/

Solution:
DFS - find max path length.
*/

public class LongestPathWithDifferentAdjacentCharacters {
    int longestPath = 1;

    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int idx = 0; idx < parent.length; idx++) {
            if(parent[idx] == -1) {
                continue;
            }

            graph.computeIfAbsent(parent[idx], value -> new ArrayList<Integer>()).add(idx);

        }  

        dfs(0, graph, s);
        return longestPath;
    }

    private int dfs(int source, Map<Integer, List<Integer>> graph, String s) {
        if(!graph.containsKey(source)) {
            return 1;
        }

        int longestChain1 = 0, longestChain2 = 0;
        for(int child : graph.get(source)) {
            int longestChildChain = dfs(child, graph, s);
            if(s.charAt(source) == s.charAt(child)) {
                continue;
            }

            if(longestChildChain > longestChain1) {
                longestChain2 = longestChain1;
                longestChain1 = longestChildChain;
            } else if(longestChildChain > longestChain2) {
                longestChain2 = longestChildChain;
            }
        } 

        longestPath = Math.max(longestPath, longestChain1 + longestChain2 + 1);
        return longestChain1 + 1;
    }    
}
