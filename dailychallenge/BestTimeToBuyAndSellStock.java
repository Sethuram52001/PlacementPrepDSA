/*
Problem:
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
 the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Solution:
Just have to keep track of the min price and max profit which can be gained at each day
*/

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            }
        }
        return maxProfit;
    }
}
