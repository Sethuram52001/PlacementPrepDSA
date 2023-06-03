/*
Problem:
A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.

Link: https://leetcode.com/problems/time-needed-to-inform-all-employees/description/

Solution:
1. Construct a graph.
2. Do a bfs, and keep track of the maximum time required on each level.
*/

import java.util.*;

public class TimeNeededToInformAllEmployees {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int employee = 0; employee < manager.length; employee++) {
            if(!graph.containsKey(manager[employee])) {
                graph.put(manager[employee], new ArrayList<>());
            }
            graph.get(manager[employee]).add(employee);
        }

        int totalNumOfMinutes = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{headID, informTime[headID]});
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                int[] curr = queue.remove();
                for(int neighbour : graph.computeIfAbsent(curr[0], k -> new ArrayList<>())) {
                    if(informTime[neighbour] == 0) {
                        totalNumOfMinutes = Math.max(totalNumOfMinutes, curr[1]);
                    } else {
                        queue.offer(new int[]{neighbour, curr[1] + informTime[neighbour]});
                    }
                }
            }
        }
        return totalNumOfMinutes;
    }
}
