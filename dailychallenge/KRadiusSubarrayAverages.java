/*
Problem:
You are given a 0-indexed array nums of n integers, and an integer k.
The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements 
in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, 
then the k-radius average is -1.
Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates 
toward zero, which means losing its fractional part.

For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
 
Link: https://leetcode.com/problems/k-radius-subarray-averages/description/

Solution:
* Maintain sum in the form of sliding window for window size of 2*k + 1.
*/

import java.util.Arrays;

public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int windowSize = 2 * k + 1;
        long windowSum = 0;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (n < windowSize) {
            return res;
        }

        for (int idx = 0; idx < n; idx++) {
            windowSum += nums[idx];
            if (idx - windowSize >= 0) {
                windowSum -= nums[idx - windowSize];
            }
            if (idx >= windowSize - 1) {
                res[idx - k] = (int) (windowSum / windowSize);
            }
        }

        return res;
    }
}
