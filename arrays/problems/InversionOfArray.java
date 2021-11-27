package problems;

/*
Problem:
For a given integer array/list 'ARR' of size 'N', find the total number of 'Inversions' that may exist.
An inversion is defined for a pair of integers in the array/list when the following two conditions are met.

A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:

1. 'ARR[i] > 'ARR[j]' 
2. 'i' < 'j'

Where 'i' and 'j' denote the indices ranging from [0, 'N').

Link: https://www.codingninjas.com/codestudio/problems/count-inversions_615

Solution:
merge sort
*/

public class InversionOfArray {

    private static long merge(long[] arr, long[] temp, int l, int m, int r) {
        int i, j, k;
        long inversions = 0;

        i = l;
        j = m;
        k = l;

        while ((i <= m - 1) && (j <= r)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += m - i;
            }
        }
        
        while (i <= m - 1) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (i = l; i <= r; i++) {
            arr[i] = temp[i];
        }
        return inversions;
    }

    private static long mergeSort(long[] arr, long[] temp, int l, int r) {
        int m = 0;
        long inversions = 0;
        if (l < r) {
            m = l + (r - l) / 2;
            inversions += mergeSort(arr, temp, l, m);
            inversions += mergeSort(arr, temp, m + 1, r);
            inversions += merge(arr, temp, l, m + 1, r);
        }
        return inversions;
    }

    private static long getInversions(int n, long[] arr) {
        long[] temp = new long[n];
        return mergeSort(arr, temp, 0, n - 1);
    }
    public static void main(String[] args) {
        int n = 5;
        long[] arr = new long[] { 2, 5, 1, 3, 4 };
        long ans = getInversions(n, arr);
        System.out.println("no of inversions: " + ans);
    }
}
