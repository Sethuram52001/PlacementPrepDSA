/*
Problem:
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would 
be at the k’th position of the final sorted array.

Link: https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1#

Solution:
Similar to median of 2 sorted arrays.
We have to partition the 2 arrays such that we get:
left = left1 + right1
right = left2 + right2

such that the partition when merged are in sorted order:
(left1+left2) + (right1 + right2)

We can find partitions by making cuts on the arrays using binary search.
Here we make sure that the left portion has k elements exactly, so the kth element will be Math.max(left1, left2)
*/

public class KthElementOf2SortedArrays {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        if (n < m) {
            return kthElement(arr2, arr1, m, n, k);
        }
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            else if (l1 > r2) {
                high = cut1 - 1;
            }

            else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}