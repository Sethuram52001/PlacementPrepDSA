/*
Problem:
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, 
where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between 
any two points.

Link: https://leetcode.com/problems/min-cost-to-connect-all-points/

Solution:
Prim's algorithm - https://leetcode.com/problems/min-cost-to-connect-all-points/discuss/1982777/PRIMS-oror-KRUSCALS-ALGORITHM-with-explanation-(**)
*/

import java.util.*;

class Edge {
    int u, v, cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int n = points.length;
        boolean[] visited = new boolean[n];

        int requiredEdges = n - 1;
        int minCost = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[] coordinate1 = points[0];

        for (int i = 1; i < points.length; i++) {
            int[] coordinate2 = points[i];
            int cost = Math.abs(coordinate2[0] - coordinate1[0]) + Math.abs(coordinate2[1] - coordinate1[1]);
            Edge edge = new Edge(0, i, cost);
            pq.add(edge);
        }

        visited[0] = true;

        while (!pq.isEmpty() && requiredEdges > 0) {
            Edge edge = pq.remove();
            int u = edge.u;
            int v = edge.v;
            int cost = edge.cost;

            if (!visited[v]) {
                minCost += cost;
                visited[v] = true;

                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int distance = Math.abs(points[v][0] - points[i][0])
                                + Math.abs(points[v][1] - points[i][1]);
                        pq.add(new Edge(v, i, distance));
                    }
                }

                requiredEdges--;
            }
        }

        return minCost;
    }
}