/*
Problem:
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i < j < nums.length
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.

Link: https://leetcode.com/problems/k-diff-pairs-in-an-array/

Solution:
We can use a hashmap to cache in the freq of each number and check if k > 0 && freqMap.hasKey(i + k) or if k == 0 && freqMap.get(i) > 1

*/

import java.util.*;

public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int num : freqMap.keySet()) {
            if ((k > 0 && freqMap.containsKey(num + k)) || (k == 0 && freqMap.get(num) > 1)) {
                count++;
            }
        }
        return count;
    }
}