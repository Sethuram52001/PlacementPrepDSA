/*
Problem:
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Link: https://leetcode.com/problems/subarray-sum-equals-k/

Solution:
We can cache in the continuous sum and look for the occurence of currSum - k in the hash table.
Since we know that if currSum - k = x has occured earlier then we can say that there is a continous subarray of sum equals k between 
x's occurence and current index.

Note:
you can't use the sliding/stretching window technique when there are negative numbers in the array, because the sum doesn't grow 
monotonically with the window size.
*/

import java.util.*;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0, currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }

    public int subarraySum_(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (pre[j] - pre[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}