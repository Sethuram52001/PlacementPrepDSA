/*
Problem:
Given a matrix of integers A of size N x M in which each row is sorted.

Find an return the overall median of the matrix A.

Note: No extra memory is allowed.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Link: https://www.interviewbit.com/problems/matrix-median/

Solution:
We can use binary search to solve this problem.
*/

public class MatrixMedian {
    private int countSmallerThanMid(int[] a, int mid) {
        int l = 0, r = a.length - 1;
        while(l <= r) {
            int m = (r + l)/2;
            if(a[m] <= mid) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return l;
    }

    public int findMedian(int[][] A) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;

        int n = A.length;
        int m = A[0].length;

        while(low <= high) {
            int mid = (high + low) / 2;
            int count = 0;
            for(int i = 0; i < n; i++) {
                count += countSmallerThanMid(A[i], mid);
            }

            if(count <= (n*m )/ 2) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }
}
