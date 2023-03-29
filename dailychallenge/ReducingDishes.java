/*
Problem:
A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.

Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied 
by its satisfaction level i.e. time[i] * satisfaction[i].

Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.

Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.

Link: https://leetcode.com/problems/reducing-dishes/description/

Solution:
Use dynamic programming to find the optimal solution by saving the previous best like-time coefficient and its 
corresponding element sum.

If adding the current element to the previous best like-time coefficient and its corresponding element sum would 
increase the best like-time coefficient, then go ahead and add it. Otherwise, keep the previous best like-time coefficient.
*/

import java.util.*;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int maxTime = satisfaction.length;
        int[][] dp = new int[maxTime + 1][maxTime + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxSatisfaction(satisfaction, dp, 0, 1);
    }

    private int maxSatisfaction(int[] satisfaction, int[][] dp, int idx, int time) {
        if (idx == satisfaction.length) {
            return 0;
        }

        if (dp[idx][time] != -1) {
            return dp[idx][time];
        }

        dp[idx][time] = Math.max(satisfaction[idx] * time + maxSatisfaction(satisfaction, dp, idx + 1, time + 1),
                maxSatisfaction(satisfaction, dp, idx + 1, time));
        return dp[idx][time];
    }
}
