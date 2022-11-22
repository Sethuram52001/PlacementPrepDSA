/*
Problem:
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is 
the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Link: https://leetcode.com/problems/perfect-squares/description/

Solution:
BFS - try all combinations using perfect squares and sum of them within the value of n
*/

import java.util.*;

public class PerfectSquares {
    public int numSquares(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int leastCount = 0;

        while (!queue.isEmpty()) {
            leastCount++;
            for (int size = queue.size(); size > 0; size--) {
                int curr = queue.remove();
                for (int i = 1; i * i <= n; i++) {
                    int next = curr + i * i;
                    if (next == n) {
                        return leastCount;
                    }
                    if (next > n) {
                        break;
                    }
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }

        return leastCount;
    }
}
