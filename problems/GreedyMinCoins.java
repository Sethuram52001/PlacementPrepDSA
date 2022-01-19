/*
Problem:
Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, 
i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins 
and/or notes needed to make the change.

Link: https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

Solution:
just greedily traverse the denominations from highest to lowest and calculate the no of coins
*/

public class GreedyMinCoins {
    public static int findMinimumCoins(int amount) {
        // Write your code here.
        int[] denominations = new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int n = denominations.length;

        int minCoins = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (amount >= denominations[i]) {
                minCoins += amount / denominations[i];
                amount %= denominations[i];
            }
        }

        return minCoins;
    }
}