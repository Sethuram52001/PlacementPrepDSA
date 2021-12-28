/* 
Problem:
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Link: https://leetcode.com/problems/trapping-rain-water/

Soln:
We can use a prefix max and suffix max to store the max heights on left and right of a index
else 
we can two pointer method
*/

public class TrappingRainWater {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int l = 0, r = height.length - 1;
        
        int waterTrapped = 0;
        while(l < r) {
            if(height[l] < height[r]) {
                if(height[l] >= leftMax) {
                    leftMax = Math.max(leftMax, height[l]);
                }
                else {
                    waterTrapped += leftMax - height[l];
                }
                l++;
            }
            else {
                if(height[r] >= rightMax) {
                    rightMax = Math.max(rightMax, height[r]);
                }
                else {
                    waterTrapped += rightMax - height[r];
                }
                r--;
            }
        }
        
        return waterTrapped;
    }
}    

