/*
Problem:
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Link:https://leetcode.com/problems/max-consecutive-ones/

Solution:
easy just count when you see 1 and reset the count if you see an 0, keep track of the max count
*/

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                count = 0;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}
