/*
Problem:
There are n cities connected by some number of flights. You are given an array flights where 
flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k 
stops. If there is no such route, return -1.

Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

Solution: 
Graph - bfs
*/

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new ArrayList<>());
            }

            graph.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }

        int[] cheapestPrice = new int[n];
        Arrays.fill(cheapestPrice, Integer.MAX_VALUE);

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { src, 0 });
        int stops = 0;

        while (stops <= k && !queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int[] curr = queue.remove();
                int node = curr[0];
                int price = curr[1];

                if (!graph.containsKey(node)) {
                    continue;
                }

                for (int[] edge : graph.get(node)) {
                    int neighbour = edge[0];
                    if (price + edge[1] >= cheapestPrice[neighbour]) {
                        continue;
                    }

                    cheapestPrice[neighbour] = price + edge[1];
                    queue.offer(new int[] { neighbour, cheapestPrice[neighbour] });
                }
            }
            stops++;
        }

        return cheapestPrice[dst] == Integer.MAX_VALUE ? -1 : cheapestPrice[dst];
    }
}
