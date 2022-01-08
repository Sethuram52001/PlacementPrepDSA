/*
Problem:
You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.


Link: https://leetcode.com/problems/cherry-pickup-ii/

Solution:
We can either do a top down or bottom up dp to solve this problem
but there's a catch on how to move the robots:

We need to move two robots! Note that the order of moving robot1 or robot2 does not matter since it would not impact the cherries we can pick. The number of cherries we can pick only depends on the tracks of our robots.

Therefore, we can move the robot1 and robot2 in any order we want. We aim to apply DP, so we are looking for an order that suitable for DP.

Let's try a few possible moving orders.

Can we move robot1 firstly to the bottom row, and then move robot2?

Maybe not. In this case, the movement of robot1 will impact the movement of robot2. In other words, the optimal track of 
robot2 depends on the track of robot1. If we want to apply DP, we need to record the whole track of robot1 as the state. 
The number of sub-problems is too much.

In fact, in any case, when we move one robot several steps earlier than the other, the movement of the first robot will impact 
the movement of the second robot.

Unless we move them synchronously (i.e., move one step of robot1 and robot2 at the same time).

Let's define the DP state as (row1, col1, row2, col2), where (row1, col1) represents the location of robot1, and (row2, col2)
represents the location of robot2.

If we move them synchronously, robot1 and robot2 will always on the same row. Therefore, row1 == row2.
*/

public class CherryPick2 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(grid, dp, 0, 0, grid[0].length - 1);
    }

    private int solve(int[][] grid, int[][][] dp, int r, int c1, int c2) {
        if (r < 0 || r >= grid.length || c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length) {
            return 0;
        }

        if (dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }

        int result = (c1 == c2) ? grid[r][c1] : grid[r][c1] + grid[r][c2];

        if (r != grid.length - 1) {
            int max = 0;
            for (int newC1 = c1 - 1; newC1 <= c1 + 1; newC1++) {
                for (int newC2 = c2 - 1; newC2 <= c2 + 1; newC2++) {
                    max = Math.max(max, solve(grid, dp, r + 1, newC1, newC2));
                }
            }
            result += max;
        }

        dp[r][c1][c2] = result;
        return result;
    }
}
