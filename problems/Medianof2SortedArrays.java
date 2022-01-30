/*
Problem:
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Link: https://leetcode.com/problems/median-of-two-sorted-arrays/

Solution:
We have to partition the 2 arrays such that we get:
left = left1 + right1
right = left2 + right2

such that the partition when merged are in sorted order:
(left1+left2) + (right1 + right2)

We can find partitions by making cuts on the arrays using binary search
*/

public class Medianof2SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        // making sure to do binary search on the smaller sized array
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0, right = n;
        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }
        return 0;
    }
}