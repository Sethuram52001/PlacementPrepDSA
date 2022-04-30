/*
Problem:
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] 
represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is 
no contradiction.

Link: https://leetcode.com/problems/evaluate-division/

Solution:
We can think the problem as a graph.
Where a / b represnets an edge from a to b and the value represent the weight of the edge.
Similary for b / a the weight will be 1 / value(a, b).
Now, we will construct the graph based on this idea.
To calculate the equation, we can simply do a dfs on the graph and the path weight will be the product
of the weights edges connecting the nodes:
a/b = 5 and b/c = 2 then a/c = 10 (this, information can be interpretted from the question)
*/

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // graph: u -> (v, weight)
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        double[] result = new double[queries.size()];
        for (int idx = 0; idx < queries.size(); idx++) {
            String u = queries.get(idx).get(0);
            String v = queries.get(idx).get(1);
            result[idx] = calcPathWeight(graph, u, v, new HashSet<>());
        }

        return result;
    }

    private double calcPathWeight(Map<String, Map<String, Double>> graph, String u, String v, HashSet<String> visited) {
        if (!graph.containsKey(u)) {
            return -1;
        }

        // if the target node is found
        if (graph.get(u).containsKey(v)) {
            return graph.get(u).get(v);
        }

        visited.add(u);
        // else checking for neighbouring nodes using dfs
        for (Map.Entry<String, Double> neighbour : graph.get(u).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double pathWeight = calcPathWeight(graph, neighbour.getKey(), v, visited);
                if (pathWeight != -1) {
                    return neighbour.getValue() * pathWeight;
                }
            }
        }

        return -1;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int idx = 0; idx < values.length; idx++) {
            String u = equations.get(idx).get(0);
            String v = equations.get(idx).get(1);
            double weight = values[idx];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, weight);
            graph.get(v).put(u, 1 / weight);
        }

        return graph;
    }
}