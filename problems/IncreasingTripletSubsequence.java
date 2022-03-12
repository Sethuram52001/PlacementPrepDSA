/*
Problem:
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Link: https://leetcode.com/problems/increasing-triplet-subsequence/

Solution:
2 pointers - start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
*/

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num <= a) {
                a = num;
            }
            else if(num <= b) {
                b = num;
            }
            else {
                return true;
            }
        }
        return false;
    }   
}