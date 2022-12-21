/*
Problem:
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other 
people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like 
the person labeled bi, return true if it is possible to split everyone into two groups in this way.

Link: https://leetcode.com/problems/possible-bipartition/description/

Solution:
2 coloring
*/

import java.util.*;

public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0], b = dislike[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] color = new int[n + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) {
                continue;
            }
            queue.add(i);
            color[i] = 1;
            while (!queue.isEmpty()) {
                int curr = queue.remove();
                for (int neighbour : graph.get(curr)) {
                    if (color[neighbour] == 0) {
                        color[neighbour] = -color[curr];
                        queue.add(neighbour);
                    } else if (color[neighbour] == color[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
