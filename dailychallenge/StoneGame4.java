/*
Problem:
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square 
number of stones in the pile.

Also, if a player cannot make a move, he/she loses the game.

Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both players play optimally.

Link: https://leetcode.com/problems/stone-game-iv/

Solution:
We can do a dfs with memoization or dp straight up in an iterative manner
*/

import java.util.*;

public class StoneGame4 {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }

    public boolean winnerSquareGameDFS(int n) {
        HashMap<Integer, Boolean> dp = new HashMap<>();
        return solve(n, dp);
    }

    private boolean solve(int n, HashMap<Integer, Boolean> dp) {
        if (n <= 0) {
            return false;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        for (int i = 1; i * i <= n; i++) {
            if (!solve(n - i * i, dp)) {
                dp.put(n, true);
                return true;
            }
        }

        dp.put(n, false);
        return false;
    }
}