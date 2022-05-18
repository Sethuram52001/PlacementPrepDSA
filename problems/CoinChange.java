/*
Problem:
You are given an integer array coins representing coins of different denominations and an integer amount 
representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be 
made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Link: https://leetcode.com/problems/coin-change/ 

Solution:
DP - bottom up approach
We can first create a dp table of size [amount + 1], and fill it with maxima value.
Now we fill the values by comparing:
    dp[value] = min(dp[value], 1 + dp[value - coin])
    where 1 in (1 + dp[value - coin]) is the coin which we are currently using to form the amount
*/

import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int sum = 0; sum <= amount; sum++) {
            for (int coin : coins) {
                if (coin <= sum) {
                    dp[sum] = Math.min(dp[sum], 1 + dp[sum - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}