/*
Problem:
Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent 
vertices of the graph are colored with the same color.

Link: https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
 
Solution:
Backtracking for every node check with m possible colors - time complexity is O(N^M)
*/

import java.util.*;

public class MColoring {
    private static boolean isValid(List<Integer>[] G, int[] color, int node, int colour) {
        for (int it : G[node]) {
            if (color[it] == colour) {
                return false;
            }
        }
        return true;
    }

    private static boolean solve(List<Integer>[] G, int[] color, int node, int m) {
        if (node == G.length) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isValid(G, color, node, i)) {
                color[node] = i;
                if (solve(G, color, node + 1, m))
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }

    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) {
        // Your code here
        return solve(G, color, i, m);
    }
}