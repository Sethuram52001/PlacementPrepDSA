/*
Problem:
There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there 
is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith 
node in the tree and all other nodes.

Link: https://leetcode.com/problems/sum-of-distances-in-tree/description/

Reference:
1. https://leetcode.com/problems/sum-of-distances-in-tree/solutions/130583/c-java-python-pre-order-and-post-order-dfs-o-n/?orderBy=most_votes
*/

import java.util.*;

public class SumOfDistancesInTree {
    int[] res, count;
    ArrayList<HashSet<Integer>> tree;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[n];
        count = new int[n];

        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return res;
    }

    private void dfs(int root, int prev) {
        for (int i : tree.get(root)) {
            if (i == prev) {
                continue;
            }

            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }

        count[root]++;
    }

    private void dfs2(int root, int prev) {
        for (int i : tree.get(root)) {
            if (i == prev) {
                continue;
            }

            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }
}
