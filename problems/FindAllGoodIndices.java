
/*
Problem:
You are given a 0-indexed integer array nums of size n and a positive integer k.

We call an index i in the range k <= i < n - k good if the following conditions are satisfied:

The k elements that are just before the index i are in non-increasing order.
The k elements that are just after the index i are in non-decreasing order.
Return an array of all good indices sorted in increasing order.

Link: https://leetcode.com/problems/find-all-good-indices/

Solution:
We precompute the no of elements which are non-increasing from left to right.
We precompute the no of elements which are non-decreasing from right to left.
Now we check for every idx, whether non-increasing[idx - 1] >= k && non-decreasing[idx + 1] >= k, then
that is a good idx.
*/
import java.util.*;

public class FindAllGoodIndices {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] nonInc = new int[n];
        int[] nonDec = new int[n];
        Arrays.fill(nonInc, 1);
        Arrays.fill(nonDec, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                nonInc[i] = nonInc[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                nonDec[i] = nonDec[i + 1] + 1;
            }
        }

        List<Integer> goodIdx = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (nonInc[i - 1] >= k && nonDec[i + 1] >= k) {
                goodIdx.add(i);
            }
        }

        return goodIdx;
    }
}