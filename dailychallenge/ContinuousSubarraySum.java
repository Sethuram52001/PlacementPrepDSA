/*
Problem:
Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least 
two whose elements sum up to a multiple of k, or false otherwise.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Link: https://leetcode.com/problems/continuous-subarray-sum/

Solution:
We can store the prefix sum and search for all possible subarray sums but this will lead
to an n^2 solution.
So, instead we can use a trick with modulus operator, where we can store the sum % k for each index.
If a value repeats while doing so, then we can be sure that the range contains the desired sum which 
is mulitple of k. Because to get the same (value % k) we should add the value with some multiple of k.

e.g.
[23,2,4,6,7] k = 6
23 % 6 = 5
(23 + 2) % 6 = 1
(23 + 2 + 4) % 6 = (29 % 6) = 5
As we can see the value repeats and see that a multiple of 6, in this case 6 was added to existing sum.
*/

import java.util.*;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            prefixSum += nums[idx];
            prefixSum %= k;
            if (map.containsKey(prefixSum)) {
                if (idx - map.get(prefixSum) >= 2) {
                    return true;
                }
            } else {
                map.put(prefixSum, idx);
            }
        }

        return false;
    }
}
