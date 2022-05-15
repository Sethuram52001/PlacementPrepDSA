/*
Problem:
You are a professional robber planning to rob houses along a street. Each house has a certain amount of 
money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor 
of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of
money you can rob tonight without alerting the police.

Link: https://leetcode.com/problems/house-robber-ii/

Solution:
Since House[1] and House[n] are adjacent, they cannot be robbed together. 
Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n], 
depending on which choice offers more money. Now the problem has degenerated to the House Robber, 
to make the decision to either pick or not pick a house to steal.
*/

public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int maxRob = Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        return maxRob;
    }

    private int rob(int[] nums, int startIdx, int endIdx) {
        int prev1 = 0, prev2 = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }
}