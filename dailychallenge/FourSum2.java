/*
Problem:
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
* 0 <= i, j, k, l < n
* nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

Link: https://leetcode.com/problems/4sum-ii/

Solution:
A[i] + B[i] + C[i] + D[i] = 0 can be written as:
A[i] + B[i] = -(C[i] + D[i])
*/

import java.util.*;

public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> freqSum = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                freqSum.put(sum, freqSum.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                res += freqSum.getOrDefault(-sum, 0);
            }
        }

        return res;
    }
}
