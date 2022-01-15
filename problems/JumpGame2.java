/*
Problem:
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.

Link: https://leetcode.com/problems/jump-game-ii/

Solution:
Greedy soln: The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the 
farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, 
and set the new curEnd with curFarthest, then keep the above steps, as the following
*/

public class JumpGame2 {
    public int jump(int[] nums) {
        int currFarthest = 0, currEnd = 0, jumps = 0;

        for (int pos = 0; pos < nums.length - 1; pos++) {
            currFarthest = Math.max(currFarthest, pos + nums[pos]);
            if (pos == currEnd) {
                jumps++;
                currEnd = currFarthest;
            }
        }

        return jumps;
    }
}
