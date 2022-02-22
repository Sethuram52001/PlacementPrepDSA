/*
Problem:
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Link: https://leetcode.com/problems/squares-of-a-sorted-array/

Solution:
We can use 2 pointers, to compare the absolute values of each element.
*/

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sqNums = new int[n];
        int i = 0, j = n - 1;
        
        for(int k = n - 1; k >= 0; k--) {
            if(Math.abs(nums[i]) >= Math.abs(nums[j])) {
                sqNums[k] = (int)Math.pow(nums[i++], 2);
            }
            else {
                sqNums[k] = (int)Math.pow(nums[j--], 2);
            }
        }
        
        return sqNums;
    }   
}