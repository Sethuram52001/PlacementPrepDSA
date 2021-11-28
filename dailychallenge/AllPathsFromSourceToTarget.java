import java.util.*;
/*
 Problem:
 Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 
 and return them in any order.

 The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge 
 from node i to node graph[i][j]).

 Link: https://leetcode.com/problems/all-paths-from-source-to-target/

 Solution:
 We can use backtracking here to trace all paths
*/

public class AllPathsFromSourceToTarget {
    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(graph, 0, allPaths, path);
        return allPaths;
    }
    
    private static void backtrack(int[][] graph, int node, List<List<Integer>> allPaths, List<Integer> path) {
        if(node == graph.length - 1) {
            allPaths.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int neighbour : graph[node]) {
            path.add(neighbour);
            backtrack(graph, neighbour, allPaths, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] { { 1, 2 }, { 3 }, { 3 }, {} };
        List<List<Integer>> allPaths = allPathsSourceTarget(graph);
        for (List<Integer> path : allPaths) {
            System.out.println(path.toString());
        }
    }
}
