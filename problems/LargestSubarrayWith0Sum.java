package problems;

import java.util.*;

/*
 Problem:
 Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

 Link: https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

 Solution:
 if we know the sum at index i is same as the sum at index j
 then we can say that subarray from i to j sums to 0
*/

public class LargestSubarrayWith0Sum {
        private static int maxLen(int arr[], int n) {
            // Your code here
            int maxLen = 0;
            HashMap<Integer, Integer> h = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum == 0) {
                    maxLen = i + 1;
                } else {
                    if (h.containsKey(sum)) {
                        maxLen = Math.max(maxLen, i - h.get(sum));
                    } else {
                        h.put(sum, i);
                    }
                }
            }
            return maxLen;
        }
        
        public static void main(String[] args) {
            int[] arr = new int[] { 15, -2, 2, -8, 1, 7, 10, 23 };
            System.out.println(maxLen(arr, arr.length));
        }
}
