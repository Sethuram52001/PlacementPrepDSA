/*
Problem:
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like 
(i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

Solution:
DP:
To represent the decision at index i:
buy[i]: Max profit till index i. The series of transaction is ending with a buy.
sell[i]: Max profit till index i. The series of transaction is ending with a sell.

Decision:
1. buy[i]: To make a decision whether to buy at i, we either take a rest, by just using the old decision at i - 1, 
or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.

2. sell[i]: To make a decision whether to sell at i, we either take a rest, by just using the old decision at i - 1, 
or buy at/before i - 1, then sell at i.
*/

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for (int day = 1; day < n; day++) {
            b0 = Math.max(b1, s2 - prices[day]);
            s0 = Math.max(s1, b1 + prices[day]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }

        return s0;
    }
    
    public int maxProfit_ExtraSpace(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int[] buy = new int[n], sell = new int[n];
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[1] = Math.max(0, buy[0] + prices[1]);

        for (int day = 2; day < n; day++) {
            buy[day] = Math.max(buy[day - 1], sell[day - 2] - prices[day]);
            sell[day] = Math.max(sell[day - 1], buy[day - 1] + prices[day]);
        }

        return sell[n - 1];
    }
}
