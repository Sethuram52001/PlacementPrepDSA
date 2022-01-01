/*
Problem:
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. 
You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, 
then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

Link: https://leetcode.com/problems/burst-balloons/

Soln:
dp:
we can divide the problem into sub-problems based on the fact -
we know that cost is ballons[i - 1]*ballons[i]*ballons[i + 1]
so the base case when there is only 1 ballon
this concept can be expanded to a dp soln 
*/

public class BurstBallons {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] ballons = new int[n];

        ballons[0] = ballons[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            ballons[i + 1] = nums[i];
        }

        int[][] dp = new int[n][n];
        for (int win = 1; win < n; win++) {
            for (int left = 0; left < n - win; left++) {
                int right = win + left;
                for (int pivot = left + 1; pivot < right; pivot++) {
                    dp[left][right] = Math.max(dp[left][right],
                            ballons[left] * ballons[pivot] * ballons[right] + dp[left][pivot] + dp[pivot][right]);
                }
            }
        }

        return dp[0][n - 1];
    }
}