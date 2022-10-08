/*
Problem:
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Link: https://leetcode.com/problems/3sum-closest/

Solution:
Sort and two pointer method.
*/
import java.util.*;
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int n = nums.length;

        Arrays.sort(nums);

        int l = 0, r = n - 1;

        for (int i = 0; i < n; i++) {
            l = i + 1;
            r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(closest)) {
                    closest = target - sum;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return target - closest;
    }
}
