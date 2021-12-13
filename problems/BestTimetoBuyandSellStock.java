/*
Question:
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

public class BestTimetoBuyandSellStock {
    private static int maxProfit(int[] prices) {
        int min = prices[0];
        int maxP = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > maxP) {
                maxP = prices[i] - min;
            }
        }
        return maxP;
    }
    
    public static void main(String[] args) {
        int maxP = maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        System.out.println("max profit: " + maxP);
    }
}
