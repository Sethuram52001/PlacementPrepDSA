/*
Problem:
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents 
your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Link: https://leetcode.com/problems/jump-game/

Solution:
We can maintain a canReach variable and greedily solve the problem
*/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length - 1, canReach = 0;
        for (int pos = 0; pos <= canReach; pos++) {
            if (pos == n) {
                return true;
            }
            canReach = Math.max(canReach, pos + nums[pos]);
        }
        return false;
    }
}
