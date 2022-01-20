/*
Problem: 
Given a list arr of N integers, print sums of all subsets in it.

Link: https://practice.geeksforgeeks.org/problems/subset-sums2234/1

Solution:
We can construct a basic recursive function with which we can either pick or not pick

Time complexity: O(2^N)
Space complexity: O(2^N)
*/

import java.util.*;
public class SubsetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        solve(arr, 0, N, 0, ans);
        return ans;
    }

    private void solve(ArrayList<Integer> arr, int idx, int n, int sum, ArrayList<Integer> ans) {
        if (idx == n) {
            ans.add(sum);
            return;
        }
        // pick
        solve(arr, idx + 1, n, sum + arr.get(idx), ans);
        // not pick
        solve(arr, idx + 1, n, sum, ans);
    }
}