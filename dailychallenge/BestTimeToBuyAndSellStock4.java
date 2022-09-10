/*
Problem:
You are given an integer array prices where prices[i] is the price 
of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most 
k transactions.

Note: You may not engage in multiple transactions simultaneously 
(i.e., you must sell the stock before you buy again).

Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

Solution: 
 dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 dp[0, j] = 0; 0 transactions makes 0 profit
 dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
*/

public class BestTimeToBuyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // case 1: n <= 1, we can't make any transactions
        if (n <= 1) {
            return 0;
        }

        // case 2: k >= n/2, we can make maximum number of transactions
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // case 3: any other situation
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }
}
