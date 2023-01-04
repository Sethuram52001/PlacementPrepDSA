/*
Problem:
You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. 
In each round, you can complete either 2 or 3 tasks of the same difficulty level.

Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

Link: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

Solution:
Group the tasks according to task difficulties.
Now,
1. 3*freq => minRounds += freq / 3
2. 3*freq + 1 => minRounds += freq / 3 + 1
3. 3*freq + 2 => minRounds += freq / 3 + 1
*/

import java.util.*;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        int minRounds = 0;
        for (Integer freq : freqMap.values()) {
            if (freq == 1) {
                return -1;
            }

            if (freq % 3 == 0) {
                minRounds += freq / 3;
            } else {
                minRounds += freq / 3 + 1;
            }
        }

        return minRounds;
    }
}
