/*
Problem:
You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the 
highest overall score. The score of the team is the sum of scores of all the players in the team.

However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a 
strictly higher score than an older player. A conflict does not occur between players of the same age.

Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player,
respectively, return the highest overall score of all possible basketball teams.

Link: https://leetcode.com/problems/best-team-with-no-conflicts/description/

Solution:
DP:
1. First, sort players by age and break ties by their score. You can now consider the players from left to right.
2. If you choose to include a player, you must only choose players with at least that score later on.
*/

import java.util.*;

public class BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] candidates = new int[n][2];
        for (int idx = 0; idx < n; idx++) {
            candidates[idx][0] = ages[idx];
            candidates[idx][1] = scores[idx];
        }

        Arrays.sort(candidates,
                (candidate1, candidate2) -> candidate1[0] == candidate2[0] ? candidate1[1] - candidate2[1]
                        : candidate1[0] - candidate2[0]);
        int[] dp = new int[n];
        dp[0] = candidates[0][1];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = candidates[i][1];
            for (int j = 0; j < i; j++) {
                if (candidates[j][1] <= candidates[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + candidates[i][1]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
