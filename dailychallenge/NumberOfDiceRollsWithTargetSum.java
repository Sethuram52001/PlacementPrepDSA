/*
Problem:
You have n dice and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll 
the dice so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 
10^9 + 7.

Link: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

Solution:
Use dynamic programming. The states are how many dice are remaining, and what sum total you have rolled so far.
*/

public class NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1_000_000_007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        
        for(int dice = 1; dice <= n; dice++) {
            for(int sum = 0; sum <= target; sum++) {
                for(int face = 1; face <= k; face++) {    
                    if(sum >= face) {
                        dp[dice][sum] = (dp[dice][sum] + dp[dice - 1][sum - face]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return dp[n][target];
    }    
}
