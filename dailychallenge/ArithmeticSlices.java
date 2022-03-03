/*
Problem:
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two 
consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

Link: https://leetcode.com/problems/arithmetic-slices/

Solution:
* Let dp[i] denote the number of arithmetic subarray ends at nums[i].
* If if nums[i-1] - nums[i-2] == nums[i] - nums[i-1] then we can form the Arithmetic subarray ends at nums[i].
* So dp[i] = dp[i-1] + 1.
* For example: nums = [1, 3, 5, 7, 9]
  dp[2] = 1 arithmetic subarrays are {1, 3, 5}
  dp[3] = dp[2] + 1 = 2, arithmetic subarrays are {1, 3, 5, 7}, {3, 5, 7}
  dp[4] = dp[3] + 1 = 3, arithmetic subarrays are {1, 3, 5, 7, 9}, {3, 5, 7, 9}, {5, 7, 9}
*/

public class ArithmeticSlices {
    public int numberOfArithmeticSlicesDP(int[] nums) {
        int ans = 0, curr = 0, n = nums.length;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;
            } else {
                curr = 0;
            }
            ans += curr;
        }

        return ans;
    }
    
    public int numberOfArithmeticSlicesDPTabluation(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        
        int[] dp = new int[n + 1];
        int ans = 0;
        for(int i = 2; i < n; i++) {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans += dp[i];
        }
        
        return ans;
    }

}