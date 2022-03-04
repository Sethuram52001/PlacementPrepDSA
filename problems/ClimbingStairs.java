/*
Problem:
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Link: https://leetcode.com/problems/climbing-stairs/

Solution: DP - fibanocci logic
*/

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        
        int oneStepBefore = 2, twoStepBefore = 1, noOfWays = 0;
        for(int i = 3; i <= n; i++) {
            noOfWays = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = noOfWays;
        }
        
        return noOfWays;
    }
}