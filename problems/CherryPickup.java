/*
Problem:
You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.

0 means the cell is empty, so you can pass through,
1 means the cell contains a cherry that you can pick up and pass through, or
-1 means the cell contains a thorn that blocks your way.
Return the maximum number of cherries you can collect by following the rules below:

* Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
* After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
* When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
* If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.

Link: https://leetcode.com/problems/cherry-pickup/

Solution:
Intuition:
Instead of walking from end to beginning, let's reverse the second leg of the path, so we are only considering two paths from the beginning to the end.
Notice after t steps, each position (r, c) we could be, is on the line r + c = t. So if we have two people at positions (r1, c1) and (r2, c2), 
then r2 = r1 + c1 - c2. That means the variables r1, c1, c2 uniquely determine 2 people who have walked the same r1 + c1 number of steps. 
This sets us up for dynamic programming quite nicely.

Algorithm:
Let dp[r1][c1][c2] be the most number of cherries obtained by two people starting at (r1, c1) and (r2, c2) and walking towards (N-1, N-1) 
picking up cherries, where r2 = r1+c1-c2.
If grid[r1][c1] and grid[r2][c2] are not thorns, then the value of dp[r1][c1][c2] is (grid[r1][c1] + grid[r2][c2]), plus the maximum of 
dp[r1+1][c1][c2], dp[r1][c1+1][c2], dp[r1+1][c1][c2+1], dp[r1][c1+1][c2+1] as appropriate. We should also be careful to not double count 
in case (r1, c1) == (r2, c2).

Why did we say it was the maximum of dp[r+1][c1][c2] etc.? It corresponds to the 4 possibilities for person 1 and 2 moving down and right:
* Person 1 down and person 2 down: dp[r1+1][c1][c2];
* Person 1 right and person 2 down: dp[r1][c1+1][c2];
* Person 1 down and person 2 right: dp[r1+1][c1][c2+1];
* Person 1 right and person 2 right: dp[r1][c1+1][c2+1];
*/

import java.util.*;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] memo = new int[n][n][n];
        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        int cherriesPicked = dp(memo, grid, 0, 0, 0);
        return Math.max(0, cherriesPicked);
    }

    private int dp(int[][][] memo, int[][] grid, int r1, int c1, int c2) {
        int n = grid.length;
        int r2 = r1 + c1 - c2;

        if (r1 == n || r2 == n || c1 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        else if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        else if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
            return memo[r1][c1][c2];
        }

        else {
            int ans = grid[r1][c1] + grid[r2][c2];
            if (r1 == r2 && c1 == c2) {
                ans /= 2;
            }

            int temp = Integer.MIN_VALUE;
            // trying all possible directions
            // 1 goes down and 2 goes down
            temp = Math.max(temp, dp(memo, grid, r1 + 1, c1, c2));
            // 1 goes down and 2 goes right
            temp = Math.max(temp, dp(memo, grid, r1 + 1, c1, c2 + 1));
            // 1 goes right and 2 goes down
            temp = Math.max(temp, dp(memo, grid, r1, c1 + 1, c2));
            // 1 goes right and 2 goes right
            temp = Math.max(temp, dp(memo, grid, r1, c1 + 1, c2 + 1));
            ans += temp;

            memo[r1][c1][c2] = ans;
            return ans;
        }
    }
}