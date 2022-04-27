/*
Problem:
You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 
2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

Link: https://leetcode.com/problems/smallest-string-with-swaps/

Solution:
Problem abstract: Sort the characters within each connected group.

* For each the given pairs, create connected groups using union-find. Always mark the smaller index as parent;
* For each character in s, create mapping from root -> a list of candidate char. Since we want to use the smallest 
one every time we pick from them, use PriorityQueue.
* Finally, for each index, choose the first char in the associated pq and append into result.
*/

import java.util.*;

public class SmallestStringWithSwaps {
    private int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            parent[i] = i;
        }

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        HashMap<Integer, PriorityQueue<Character>> connectedComponents = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            connectedComponents.putIfAbsent(root, new PriorityQueue<>());
            connectedComponents.get(root).offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(connectedComponents.get(find(i)).remove());
        }

        return sb.toString();
    }

    private int find(int u) {
        while (parent[u] != u) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;
    }

    private void union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);
        if (parentU < parentV) {
            parent[parentV] = parentU;
        } else {
            parent[parentU] = parentV;
        }
    }
}