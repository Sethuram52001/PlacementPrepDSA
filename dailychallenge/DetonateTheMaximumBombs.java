/*
Problem:
You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.

Link: https://leetcode.com/problems/detonate-the-maximum-bombs/description/

Solution:
* Construct a DAG where every bomb is connected to another bomb if and only if it can trigger it.(It has to be directed graph
because bomb x can trigger bomb y but we cannot say that bomb y can trigger bomb x)

* We can find whether a bomb is triggered using distance formula => dist = Math.sqrt((xi - xj)**2 + (yi - yj)**2)

* Now, we can perform dfs from every bomb to find the max no of bombs it can trigger. 
*/

import java.util.*;

public class DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < bombs.length; i++) {
            for(int j = 0; j < bombs.length; j++) {
                if(i == j) {
                    continue;
                }

                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];
                if((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
                    if(!graph.containsKey(i)) {
                        graph.put(i, new ArrayList<>());
                    }

                    graph.get(i).add(j);
                }
            }
        }

        int maxBombs = 0;
        for(int i = 0; i < bombs.length; i++) {
            int count = dfs(i, graph, new HashSet<>());
            maxBombs = Math.max(maxBombs, count);
        }

        return maxBombs;
    }

    private int dfs(int curr, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(curr);
        int count = 1;
        for(int neighbour: graph.getOrDefault(curr, new ArrayList<>())) {
            if(!visited.contains(neighbour)) {
                count += dfs(neighbour, graph, visited);
            }
        }
        return count;
    }    
}
