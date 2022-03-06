/*
Problem:
Given n orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.

Link: https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/

Solution: 
DP, recurrence relation:
// If we want to pick one order then,
waysToPick = unpicked * totalWays(unpicked - 1, undelivered)

// If we want to deliver one order then,    
waysToDeliver = (undelivered - unpicked) * totalWays(unpicked, undelivered - 1)
*/

public class CountAllValidPickupAndDeliveryOptions {
    private long[][] memo;
    private int mod = 1000000007;
    
    public int countOrders(int n) {
        memo = new long[n + 1][n + 1];
        return (int)solve(n, n);
    }
    
    private long solve(int unpicked, int undelivered) {
        if(unpicked < 0 || undelivered < 0 || undelivered < unpicked) {
            return 0;
        }
        
        if(unpicked == 0 && undelivered == 0) {
            return 1;
        }
        
        if(memo[unpicked][undelivered] != 0) {
            return memo[unpicked][undelivered];
        }
        
        long ans = 0;
        ans += unpicked * solve(unpicked - 1, undelivered);
        ans %= mod;
        
        ans += (undelivered - unpicked) * solve(unpicked, undelivered - 1);
        ans %= mod;
        
        memo[unpicked][undelivered] = ans;
        
        return ans;
    }
}
