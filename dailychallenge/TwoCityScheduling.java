/*
Problem:
A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith 
person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

Link: https://leetcode.com/problems/two-city-scheduling/

Solution:
sort by difference in costs of a and b 
send the first n to a, rest to b 
*/

import java.util.*;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        int minCost = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            minCost += costs[i][0];
        }

        for (int i = n; i < costs.length; i++) {
            minCost += costs[i][1];
        }

        return minCost;
    }
}