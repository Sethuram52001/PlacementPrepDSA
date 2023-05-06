/*
Problem:
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is 
less or equal to target. Since the answer may be too large, return it modulo 10^9 + 7.

Link: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

Solution:
* We can sort the array as we're only concerned about subsequences so order doesn't really matter.
* Now, we can follow similar approach to 2 sum problem using 2 pointers here, to check whether nums[left] + nums[right] <= target
if so, the count = count + 2 ^ (right - left).
* We're using 2^(right- left); as in a subsequence a element can be either present or absent.
*/

import java.util.*;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        int mod = (int) 1e9 + 7;
        Arrays.sort(nums);
        int n = nums.length;
        int[] powers = new int[n];
        powers[0] = 1;
        for (int idx = 1; idx < n; idx++) {
            powers[idx] = 2 * powers[idx - 1] % mod;
        }

        int left = 0, right = n - 1, count = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + powers[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
