/*
Problem:
Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.

Link: https://leetcode.com/problems/number-of-longest-increasing-subsequence/

Solution:
DP - we can maintain an addition frequence array to keep track of the number of
occurences of the longest increasing subsequences.
*/

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] freq = new int[n];

        int res = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            freq[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) {
                        freq[i] += freq[j];
                    }
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        freq[i] = freq[j];
                    }
                }
            }
            if (maxLen == dp[i]) {
                res += freq[i];
            } else if (maxLen < dp[i]) {
                res = freq[i];
                maxLen = dp[i];
            }
        }

        return res;
    }
}