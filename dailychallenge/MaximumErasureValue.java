/*
Problem:
You are given an array of positive integers nums and want to erase a subarray containing unique elements. 
The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it 
is equal to a[l],a[l+1],...,a[r] for some (l,r).

Link: https://leetcode.com/problems/maximum-erasure-value/

Solution:
We can use sliding window to compute the subarray sum and hashset to maintain unique elements.
*/

import java.util.*;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxSubSum = Integer.MIN_VALUE, currSum = 0;
        int l = 0, r = 0;

        while (l < nums.length && r < nums.length) {
            if (set.contains(nums[r])) {
                currSum -= nums[l];
                set.remove(nums[l++]);
            } else {
                set.add(nums[r]);
                currSum += nums[r++];
            }
            maxSubSum = Math.max(maxSubSum, currSum);
        }

        return maxSubSum;
    }
}