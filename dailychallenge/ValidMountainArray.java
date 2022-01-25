/*
Problem:
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Link: https://leetcode.com/problems/valid-mountain-array/

Solution:
Let's walk up from left to right until we can't: that has to be the peak. We should ensure the peak is not the first or last element. 
Then, we walk down. If we reach the end, the array is valid, otherwise its not.
*/

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int curr = 0, n = arr.length;

        // walk up
        while (curr + 1 < n && arr[curr + 1] > arr[curr]) {
            curr++;
        }

        // peak can't be starting or ending point
        if (curr == 0 || curr == n - 1) {
            return false;
        }

        // walk down
        while (curr + 1 < n && arr[curr + 1] < arr[curr]) {
            curr++;
        }

        return curr == n - 1;
    }
}