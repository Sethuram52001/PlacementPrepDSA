/*
Problem:
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Link: https://leetcode.com/problems/max-number-of-k-sum-pairs/

Solution:
1. We can sort the elements and do a 2 pointer approach.
2. We can use a hashmap to store the frequency of occurence of each num, now
   we can traverse the elements in keyset and count the number of pairs whose sum = k
*/

import java.util.*;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxOp = 0;
        for (Integer num : freqMap.keySet()) {
            if (num * 2 == k) {
                maxOp += freqMap.get(num) / 2;
            } else if (freqMap.containsKey(k - num)) {
                int minOp = Math.min(freqMap.get(num), freqMap.get(k - num));
                freqMap.put(num, freqMap.get(num) - minOp);
                freqMap.put(k - num, freqMap.get(k - num) - minOp);
                maxOp += minOp;
            }
        }

        return maxOp;
    }

    public int maxOperations_usingSort(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int maxOp = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                maxOp++;
                left++;
                right--;
            }
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            }
        }

        return maxOp;
    }
}