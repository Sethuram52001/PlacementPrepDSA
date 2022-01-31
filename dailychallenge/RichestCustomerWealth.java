/*
Problem:
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. 
Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

Link: https://leetcode.com/problems/richest-customer-wealth/

Solution:
Simple qn
*/

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int amount : accounts[i]) {
                wealth += amount;
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }
}