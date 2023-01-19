/*
Problem:
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.

Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

Solution:
1. Store the sum of the array using modulo of k at each index.
2. If the remainders of i and j are equal (ri=rj) the subarray 
from i to j has a remainder of 0, which means It's the type of subarrays we're looking for.

Reference:
1. https://leetcode.com/problems/subarray-sums-divisible-by-k/solutions/413234/detailed-whiteboard-beats-100-do-you-really-want-to-understand-it/?orderBy=most_votes
*/

import java.util.*;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            sum %= k;

            if (sum < 0) {
                sum += k;
            }

            if (modMap.containsKey(sum)) {
                count += modMap.get(sum);
                modMap.put(sum, modMap.get(sum) + 1);
            } else {
                modMap.put(sum, 1);
            }
        }

        return count;
    }
}
