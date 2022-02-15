/*
Problem:
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Link: https://leetcode.com/problems/single-number/

Solution:
Bitwise-xor
*/

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int singleNumber = nums[0];
        for(int i = 1; i < nums.length; i++) {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }   
}