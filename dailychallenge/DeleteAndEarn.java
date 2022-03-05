/*
Problem:
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation 
any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every 
element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

Link: https://leetcode.com/problems/delete-and-earn/

Solution:
DP - we decide at each state whether we pick the number or not.
*/

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];
        for(int num : nums) {
            bucket[num] += num;
        }
        
        int[] dp = new int[10001];
        dp[0] = bucket[0];
        dp[1] = bucket[1];
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(bucket[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[10000];
    }   
}
